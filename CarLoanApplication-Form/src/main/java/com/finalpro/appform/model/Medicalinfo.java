package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Medicalinfo {
	@Id
	private int billId;
	private int patientId;
	private String professionsalpatientName;
	private String billingDate;
	private double loanAmount;
	private String treatment;
}
