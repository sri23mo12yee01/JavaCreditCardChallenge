package com.Project.CreditCard.service;

import com.Project.CreditCard.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getCustomerByGender(String _gender);
    public List<Customer> getCustomerByProfession(String _profession);
}
