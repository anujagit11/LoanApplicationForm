package com.finalpro.appform.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CibilDetails {
	
	@Id
	private String cibilId;
	private int cibilScore;
	private String remark;
	private String isApplicable;

}
