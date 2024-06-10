package com.finalpro.appform.model;

import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
	private String verificationDate;
	private String status;
	private String remarks;

}
