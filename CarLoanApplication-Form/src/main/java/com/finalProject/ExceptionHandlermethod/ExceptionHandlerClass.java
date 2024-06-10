package com.finalProject.ExceptionHandlermethod;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.finalProject.dto.CustomerDto;
import com.finalpro.appform.CustomException.CustomerIdIsNotFoundException;



@RestControllerAdvice
public class ExceptionHandlerClass {

	

	@ExceptionHandler(CustomerIdIsNotFoundException.class)
	public ResponseEntity<CustomerDto> handleuser(CustomerIdIsNotFoundException ee)
	{
		CustomerDto respo=new CustomerDto();
		respo.setMsg(ee.getMessage());
		respo.setTimestamp(new Date());
		
		return new ResponseEntity<CustomerDto>(respo,HttpStatus.OK);
	}
}
