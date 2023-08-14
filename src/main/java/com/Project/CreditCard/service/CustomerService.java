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

    public Customer updateCustomer(ObjectId id, Customer customer)
    {
        Optional<Customer> existingCustomerOptional=  customerRepo.findById(id);
        if(existingCustomerOptional.isPresent())
        {
            Customer existingCustomer= existingCustomerOptional.get();
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setGender(customer.getGender());
            existingCustomer.setProfession(customer.getProfession());
            return customerRepo.save(existingCustomer);
        }
        else {
            return null;
    }
    }

    public boolean deleteCustomer(ObjectId id)
    {
        Optional<Customer> customerOptional=customerRepo.findById(id);
        if(customerOptional.isPresent())
        {
            customerRepo.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }


}
