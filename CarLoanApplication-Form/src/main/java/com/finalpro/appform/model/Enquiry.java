package com.finalpro.appform.model;

import lombok.Data;


@Data
public class Enquiry {
	
	
	private String enquiryid;
	private String fullName;
	private String applicantEmail;
	private long contactNo;
	private  long alternativeContactNo;
	private int age;
	private String panCardNo;
	
	
	private CibilDetails cibil;
	

}
