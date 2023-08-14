package com.Project.CreditCard.controller;

import com.Project.CreditCard.entity.Customer;
import com.Project.CreditCard.service.CustomerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService _customerService)
    {
        this.customerService=_customerService;
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Customer>> getCustomersByGender(@PathVariable String gender)
    {
        List<Customer> customers = customerService.getCustomerByGender(gender);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/profession/{profession}")
    public ResponseEntity<List<Customer>> getCustomersByProfession(@PathVariable String profession)
    {
        List<Customer> customers=customerService.getCustomerByProfession(profession);
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        Customer createdCustomer= customerService.createCustomer(customer);
        return ResponseEntity.created(URI.create("/customers/"+createdCustomer.getCustomerId())).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable ObjectId id, @RequestBody Customer customer)
    {
        Customer updatedCustomer=customerService.updateCustomer(id,customer);
        if(updatedCustomer !=null)
        {
            return ResponseEntity.ok(updatedCustomer);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@PathVariable ObjectId id)
    {
        if(customerService.deleteCustomer(id))
        {
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }





}
