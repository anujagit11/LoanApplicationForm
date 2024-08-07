package com.finalpro.appform.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CarLoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String customerDateOfBirth;
	private int customerAge;
	private String customerGender;
	private String customerEmail;
	private Double customerMobileNumber;
	private String panCardNo;
	private Double customerAdditionalMobileNumber;
	private Double customerAmountPaidForHome;
	private Double customerTotalLoanRequired;
	private String loanStatus;

	@OneToOne(cascade = CascadeType.ALL)
	private CibilDetails cibill;

	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private AllPersonalDocs allpersonalDocs;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;

	@OneToOne(cascade = CascadeType.ALL)
	private CustomerVarification customerVarification;

	@OneToOne(cascade = CascadeType.ALL)
	private FamilyDependentInfo familyDependentInfo;

	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private Ledger ledger;

	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursement;

	@OneToOne(cascade = CascadeType.ALL)
	private Medicalinfo medicalinfo;

	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;

}
