package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GuarantorDetails {
	@Id
	private int GuarantorId;
	private String GuarantorName;
	private String GuarantorDateOfBirth;
	private String GuarantorRelationshipwithCustomer;
	private long GuarantorMobileNumber;
	private long GuarantorAdharCardNo;
	private String GuarantorMortgageDetails;
	private String GuarantorJobDetails;
	private String GuarantorLoaclAddress;
	private String GuarantorPermanentAddress;
}
