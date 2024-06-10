package com.finalpro.appform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PatchMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.finalProject.dto.CustomerDto;
import com.finalpro.appform.model.CarLoanApplication;
import com.finalpro.appform.service.AppFormServiceI;

@RestController
public class LoanApplicationController {
	@Autowired
	AppFormServiceI afs;

	@PostMapping("/addcardata")
	public ResponseEntity<CarLoanApplication> LoanFormData(@RequestPart("customerfield") String formjson,
			@RequestPart("docaddress") MultipartFile addressProof, @RequestPart("pan") MultipartFile panCard,
			@RequestPart("income") MultipartFile incomeTax, @RequestPart("adhar") MultipartFile adharCard,
			@RequestPart("photo") MultipartFile photo, @RequestPart("sign") MultipartFile signature,
			@RequestPart("cheque") MultipartFile bankCheque, @RequestPart("salarySlips") MultipartFile salarySlips) {
		System.out.println(formjson);
		System.out.println(addressProof.getOriginalFilename());
		System.out.println(panCard.getOriginalFilename());
		System.out.println(incomeTax.getOriginalFilename());
		System.out.println(adharCard.getOriginalFilename());
		System.out.println(photo.getOriginalFilename());
		System.out.println(signature.getOriginalFilename());
		System.out.println(bankCheque.getOriginalFilename());
		System.out.println(salarySlips.getOriginalFilename());

		CarLoanApplication cd = afs.saveCarAppFormData(formjson, addressProof, panCard, incomeTax, adharCard, photo,
				signature, bankCheque, salarySlips);

		return new ResponseEntity<CarLoanApplication>(cd, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CarLoanApplication>> getAllloanData() {
		List<CarLoanApplication> list = (List<CarLoanApplication>) afs.getAllloanData();
		return new ResponseEntity<List<CarLoanApplication>>(list, HttpStatus.OK);
	}

	@GetMapping("/getSingleloandata/{customerId}")
	public ResponseEntity<CarLoanApplication> getSingleLoanApplicationController(
			@PathVariable("customerId") int customerId) {
		CarLoanApplication user = afs.getSingleloandata(customerId);
		return new ResponseEntity<CarLoanApplication>(user, HttpStatus.OK);
	}

	@PatchMapping("/updateData/{customerId}")
	public ResponseEntity<CarLoanApplication> update(@RequestPart("customerfield") String formjson,
			@RequestPart("docaddress") MultipartFile addressProof, @RequestPart("pan") MultipartFile panCard,
			@RequestPart("income") MultipartFile incomeTax, @RequestPart("adhar") MultipartFile adharCard,
			@RequestPart("photo") MultipartFile photo, @RequestPart("sign") MultipartFile signature,
			@RequestPart("cheque") MultipartFile bankCheque, @RequestPart("salarySlips") MultipartFile salarySlips,
			@PathVariable int customerId) {

		CarLoanApplication cd = afs.saveUpdateData(formjson, addressProof, panCard, incomeTax, adharCard, photo,
				signature, bankCheque, salarySlips, customerId);

		return new ResponseEntity<CarLoanApplication>(cd, HttpStatus.OK);
	}

}
