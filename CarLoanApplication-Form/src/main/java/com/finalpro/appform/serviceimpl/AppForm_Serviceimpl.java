package com.finalpro.appform.serviceimpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalProject.model.Enquiry;
import com.finalpro.appform.CustomException.CustomerIdIsNotFoundException;
import com.finalpro.appform.CustomException.LoanApplicationNotFoundException;
import com.finalpro.appform.controller.LoanApplicationController;
import com.finalpro.appform.model.AllPersonalDocs;
import com.finalpro.appform.model.CarLoanApplication;
import com.finalpro.appform.model.CibilDetails;
import com.finalpro.appform.model.CustomerVarification;
import com.finalpro.appform.model.SanctionLetter;
import com.finalpro.appform.repo.AppFormRepository;
import com.finalpro.appform.service.AppFormServiceI;

@Service
public class AppForm_Serviceimpl implements AppFormServiceI {

	@Autowired
	AppFormRepository apf;
	@Autowired
	RestTemplate rs;

	// @Autowired
	// CarLoanApplication cc;

	@Override
	public CarLoanApplication saveCarAppFormData(String formjson, MultipartFile addressProof, MultipartFile panCard,
			MultipartFile incomeTax, MultipartFile adharCard, MultipartFile photo, MultipartFile signature,
			MultipartFile bankCheque, MultipartFile salarySlips) {
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

			String url = "http://localhost:8081/getpan/" + ca.getPanCardNo();
			Enquiry e = rs.getForObject(url, Enquiry.class);
			System.out.println(e.getCibil());
			System.out.println(e.getCibil().getCibilScore());
			if (ca.getCibill() == null) {
				ca.setCibill(new CibilDetails());
			}

			ca.getCibill().setCibilId(e.getCibil().getCibilId());
			ca.getCibill().setCibilScore(e.getCibil().getCibilScore());
			ca.getCibill().setIsApplicable(e.getCibil().getIsApplicable());
			ca.getCibill().setRemark(e.getCibil().getRemark());

			return apf.save(ca);

		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;

	}

	@Override
	public Iterable<CarLoanApplication> getAllloanData() {
		return apf.findAll();
	}

	@Override
	public CarLoanApplication getSingleloandata(int customerId) {
		Optional<CarLoanApplication> op = apf.findById(customerId);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new CustomerIdIsNotFoundException("CustomerId is not present..");
		}

	}

	@Override
	public CarLoanApplication saveUpdateData(String formjson, MultipartFile addressProof, MultipartFile panCard,
			MultipartFile incomeTax, MultipartFile adharCard, MultipartFile photo, MultipartFile signature,
			MultipartFile bankCheque, MultipartFile salarySlips, int customerId) {
		Optional<CarLoanApplication> op = apf.findById(customerId);
		if (op.isPresent()) {

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

				String url = "http://localhost:8081/getpan/" + ca.getPanCardNo();
				Enquiry e = rs.getForObject(url, Enquiry.class);
				System.out.println(e.getCibil());
				System.out.println(e.getCibil().getCibilScore());
				if (ca.getCibill() == null) {
					ca.setCibill(new CibilDetails());
				}

				ca.getCibill().setCibilId(e.getCibil().getCibilId());
				ca.getCibill().setCibilScore(e.getCibil().getCibilScore());
				ca.getCibill().setIsApplicable(e.getCibil().getIsApplicable());
				ca.getCibill().setRemark(e.getCibil().getRemark());

				return apf.save(ca);

			} catch (IOException ie) {
				ie.printStackTrace();
			}
			return null;

		} else {
			throw new CustomerIdIsNotFoundException("CustomerId is not present For Update Data..");
		}

	}

	@Override
	public CarLoanApplication verifyApplication(int customerId, CustomerVarification cv) {

		// CarLoanApplication cr = new CarLoanApplication();
		// if (cr.getCustomerVarification() == null) {
		// cr.setCustomerVarification(new CustomerVarification());

		Optional<CarLoanApplication> op = apf.findById(customerId);
		if (op.isPresent()) {
			CarLoanApplication cc = op.get();

			cv.setVerificationDate(new Date());
			cc.setCustomerVarification(cv);

			apf.save(cc);
			return cc;
		} else {
			throw new CustomerIdIsNotFoundException("customer is not register");
		}

	}

	@Override
	public void save(SanctionLetter sqd, int customerId) {
		Optional<CarLoanApplication> opcust = apf.findById(customerId);
		if (opcust.isPresent()) {
			CarLoanApplication cd = opcust.get();
			sqd.setSanctionId(cd.getCustomerId());
			sqd.setSanctionDate(new Date());
			sqd.setStatus("Created");
			sqd.setTermsCondition(
					"The Sanction is valid till 15 days you can accept or reject this sanction if no replay recived then it will consider as rejected by applicant ");

			cd.setSanctionLetter(sqd);
			apf.save(cd);
		} else {
			throw new CustomerIdIsNotFoundException("invalid customer id");
		}
	}
}
