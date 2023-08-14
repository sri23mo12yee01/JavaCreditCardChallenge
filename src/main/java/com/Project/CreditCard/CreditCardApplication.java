package com.Project.CreditCard;

import com.Project.CreditCard.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class CreditCardApplication {
	Logger logger = Logger.getLogger(CreditCardApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);
	}

	@Autowired
	private CustomerRepo repo;

	public void init()
	{
		logger.info("Initialized");
	}
}
