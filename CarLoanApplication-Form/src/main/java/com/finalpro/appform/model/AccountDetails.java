package com.finalpro.appform.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class AccountDetails {
	@Id
	private int accountId;
	private String accounType;
	private double accountBalance;
	private String accountHolderName;
	private String accountStatus;
	private long accountNumber;

}
