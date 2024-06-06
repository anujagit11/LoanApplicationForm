package com.finalpro.appform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerVarification {
	@Id
	private int verificationID;
	private String verificationDate;
	private String status;
	private String remarks;

}
