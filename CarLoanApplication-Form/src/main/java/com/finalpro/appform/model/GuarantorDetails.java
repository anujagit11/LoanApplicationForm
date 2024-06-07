package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GuarantorDetails {
	@Id
	private int guarantorId;
	private String guarantorName;
	private String guarantorDateOfBirth;
	private String guarantorRelationshipwithCustomer;
	private long guarantorMobileNumber;
	private long guarantorAdharCardNo;
	private String guarantorMortgageDetails;
	private String guarantorJobDetails;
	private String guarantorLoaclAddress;
	private String guarantorPermanentAddress;
}
