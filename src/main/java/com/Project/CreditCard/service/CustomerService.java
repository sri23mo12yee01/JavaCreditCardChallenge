package com.Project.CreditCard.service;

import com.Project.CreditCard.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    CustomerRepo repo;


}
