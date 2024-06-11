package com.finalpro.appform.CustomException;

public class LoanApplicationNotFoundException extends RuntimeException

{

	public LoanApplicationNotFoundException(String msg) {
		super(msg);
	}

}
