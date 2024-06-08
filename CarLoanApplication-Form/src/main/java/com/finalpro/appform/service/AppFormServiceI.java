package com.finalpro.appform.service;



import org.springframework.web.multipart.MultipartFile;

import com.finalpro.appform.model.CarLoanApplication;

public interface AppFormServiceI {

	CarLoanApplication saveCarAppFormData(String formjson, MultipartFile addressProof, MultipartFile panCard,
			MultipartFile incomeTax, MultipartFile adharCard, MultipartFile photo, MultipartFile signature,
			MultipartFile bankCheque, MultipartFile salarySlips);

	

	CarLoanApplication getSingleloandata(int customerId);

	Iterable<CarLoanApplication> getAllloanData();

	



}
