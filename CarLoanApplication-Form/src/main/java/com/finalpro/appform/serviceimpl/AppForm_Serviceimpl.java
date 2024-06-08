package com.finalpro.appform.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalpro.appform.model.AllPersonalDocs;
import com.finalpro.appform.model.CarLoanApplication;
import com.finalpro.appform.model.CibilDetails;
import com.finalpro.appform.model.Enquiry;
import com.finalpro.appform.repo.AppFormRepository;
import com.finalpro.appform.service.AppFormServiceI;

@Service
public class AppForm_Serviceimpl implements AppFormServiceI {

	@Autowired
	AppFormRepository apf;
	@Autowired
	RestTemplate rs;

	@Override
	public CarLoanApplication saveCarAppFormData(String formjson, MultipartFile addressProof, MultipartFile panCard,
			MultipartFile incomeTax, MultipartFile adharCard, MultipartFile photo, MultipartFile signature,
			MultipartFile bankCheque, MultipartFile salarySlips)
			 {
		try {
			ObjectMapper mapper = new ObjectMapper();
			CarLoanApplication ca = mapper.readValue(formjson, CarLoanApplication.class);
			
			   
            if (ca.getAllpersonalDocs() == null) {
                ca.setAllpersonalDocs(new AllPersonalDocs());
            }
            

            AllPersonalDocs allPersonalDocs = ca.getAllpersonalDocs();

            allPersonalDocs.setAddressProof(addressProof.getBytes());
            allPersonalDocs.setPanCard(panCard.getBytes());
            allPersonalDocs.setIncomeTax(incomeTax.getBytes());
            allPersonalDocs.setAdharCard(adharCard.getBytes());
            allPersonalDocs.setPhoto(photo.getBytes());
            allPersonalDocs.setSignature(signature.getBytes());
            allPersonalDocs.setBankCheque(bankCheque.getBytes());
            allPersonalDocs.setSalarySlips(salarySlips.getBytes());
            
            String url="http://localhost:8081/getpan/"+ca.getPanCardNo();
            Enquiry e =rs.getForObject(url, Enquiry.class);
            
            
           // Enquiry ee=new Enquiry();
           ca.getEn().setCibil(e.getCibil());
           //// c.setCibilId(e.getCibil().getCibilId());
         //   c.setCibilScore(e.getCibil().getCibilScore());
         ////   c.setIsApplicable(e.getCibil().getIsApplicable());;
          //  c.setRemark(e.getCibil().getRemark());;
			
			return apf.save(ca);

		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;

	}

	
}
