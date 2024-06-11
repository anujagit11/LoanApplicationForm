package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Medicalinfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private int patientId;
	private String professionsalpatientName;
	private String billingDate;
	private double loanAmount;
	private String treatment;
}
