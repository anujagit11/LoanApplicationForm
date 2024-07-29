package com.finalpro.appform.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SanctionLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sanctionId;
	private Date sanctionDate;
	private String applicantName;
	private double contactDetails;
	private String producthomeEquity;
	private double loanAmtSanctioned;
	private String interestType;
	private float rateOfInterest;
	private int loanTenureInYear;
	private double monthlyEmiAmount;
	private String modeOfPayment;
	private String remarks;
	private String termsCondition;
	private String status;
	

}
