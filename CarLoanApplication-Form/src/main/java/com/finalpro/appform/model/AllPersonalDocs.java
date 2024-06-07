package com.finalpro.appform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
public class AllPersonalDocs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int documentId;
	
	@Lob
	@Column(length = 999999999)
	private byte[] addressProof;
	
	@Lob
	@Column(length = 999999999)
	private byte[] panCard;
	@Lob
	@Column(length = 999999999)
	private byte[] incomeTax;

	@Lob
	@Column(length = 999999999)
	private byte[] adharCard;

	@Lob
	@Column(length = 999999999)
	private byte[] photo;

	@Lob
	@Column(length = 999999999)
	private byte[] signature;

	@Lob
	@Column(length = 999999999)
	private byte[] bankCheque;

	@Lob
	@Column(length = 999999999)
	private byte[] salarySlips;

}
