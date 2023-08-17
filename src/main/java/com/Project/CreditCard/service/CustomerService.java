package com.Project.CreditCard.service;

import com.Project.CreditCard.entity.Customer;
import com.Project.CreditCard.repo.CustomerRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo _customerRepo){
        this.customerRepo=_customerRepo;
    }

    public List<Customer> getCustomerByGender(String _gender)
    {
        System.out.println("In customer service");
        return customerRepo.findByGender(_gender);
    }

    public List<Customer> getCustomerByProfession(String _profession)
    {
        return customerRepo.findByProfession(_profession);
    }

    public Customer createCustomer(Customer customer)
    {
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(String id, Customer customer) {
        System.out.println("Printing from Service Class" + id + customer);
        Customer existingCustomer = customerRepo.findByCustomerId(id);
        System.out.println("old object"+existingCustomer);
        if (existingCustomer != null) {
//            Customer existingCustomer= existingCustomerOptional.get();
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setGender(customer.getGender());
            existingCustomer.setProfession(customer.getProfession());
            System.out.println("*************"+existingCustomer);
            customerRepo.save(existingCustomer);
        }

        return existingCustomer;
    }


    public boolean deleteCustomer(String id)
    {
        Customer customerOptional=customerRepo.findByCustomerId(id);
        if(customerOptional !=null)
        {
            customerRepo.deleteByCustomerId(id);
            return true;
        }
        else {
            return false;
        }
    }


}
