package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LoanDisbursement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int agreementId;
private int loanNo;
private String agreementDate;
 private String amountPayType;
 private double totalAmount;
 private String bankName;
 private long accountNumber;
 private String iFSCCode;
 private String accountType;
 private double transferAmount;
 private String paymentStatus;
 private String amountPaidDate;
}















