package com.finalpro.appform.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CibilDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String cibilId;
	private int cibilScore;
	private String remark;
	private String isApplicable;

}
