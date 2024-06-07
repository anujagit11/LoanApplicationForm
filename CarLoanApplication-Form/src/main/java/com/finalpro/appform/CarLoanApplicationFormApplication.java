package com.finalpro.appform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarLoanApplicationFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarLoanApplicationFormApplication.class, args);
	}
	@Bean
	public RestTemplate rs()
	{
		RestTemplate r=new RestTemplate();
		return r;
	}
}
