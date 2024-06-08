package com.finalpro.appform.CustomException;

public class CustomerIdIsNotFoundException extends RuntimeException {

	public CustomerIdIsNotFoundException (String msg) {
		super(msg);
	}
}
