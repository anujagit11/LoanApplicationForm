package com.finalpro.appform.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.dto.CustomerDto;
import com.finalpro.appform.model.CarLoanApplication;
import com.finalpro.appform.model.CustomerVarification;
import com.finalpro.appform.service.AppFormServiceI;

@RestController
public class VarificationAndSanctionController
{
	  @Autowired
	  AppFormServiceI ap;
	  
	  
	     @PatchMapping("/verify/{customerId}")
          public ResponseEntity<CustomerDto> verifyApplication(@PathVariable int customerId,@RequestBody CustomerVarification cv)
          {
	    	  CarLoanApplication  cd=  ap.verifyApplication(customerId,cv);
	    	  CustomerDto c=new CustomerDto("Data has been Verify", new Date());
	    	    return new ResponseEntity<CustomerDto>(c,HttpStatus.OK);
          }
	   
	   
}
	
