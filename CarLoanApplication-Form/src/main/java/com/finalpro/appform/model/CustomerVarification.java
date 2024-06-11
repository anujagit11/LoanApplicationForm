package com.finalpro.appform.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerVarification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int verificationID;

    
	private Date verificationDate;
	private String status;
	private String remarks;

}
