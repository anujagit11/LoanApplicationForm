package com.finalpro.appform.ExceptionHandlermethod;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.finalpro.appform.CustomException.CustomerIdIsNotFoundException;
import com.finalpro.appform.CustomException.LoanApplicationNotFoundException;
import com.finalpro.appform.dto.CustomerDto;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(CustomerIdIsNotFoundException.class)
	public ResponseEntity<CustomerDto> handleuser(CustomerIdIsNotFoundException ee) {
		CustomerDto respo = new CustomerDto(ee.getMessage(), new Date());
		return new ResponseEntity<CustomerDto>(respo, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LoanApplicationNotFoundException.class)
	public ResponseEntity<CustomerDto> verify(LoanApplicationNotFoundException ll) {
		CustomerDto cc = new CustomerDto(ll.getMessage(), new Date());	
		return new ResponseEntity<CustomerDto>(cc, HttpStatus.NOT_FOUND);
	}
}
