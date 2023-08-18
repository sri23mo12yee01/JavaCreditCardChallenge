package com.Project.CreditCard;

import com.Project.CreditCard.entity.Customer;
import com.Project.CreditCard.repo.CustomerRepo;
import com.Project.CreditCard.service.CustomerService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest

public class CustomerTest {
    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private CustomerService customerService;
    private List<Customer> mockCustomers = new ArrayList<>();

    private List<Customer> maleCustomers = new ArrayList<>();

    Customer customer1;
    Customer customer2;
    Customer customer3;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        System.out.println("Mock Initialized" + customerRepo);
    }

    @BeforeEach
    public void Init() {
        customer1 = new Customer();

        customer1.setId(new ObjectId());
        customer1.setCustomerId("1");
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setGender("Male");
        customer1.setProfession("Engineer");

        customer2 = new Customer();
        customer2.setId(new ObjectId());
        customer2.setCustomerId("2");
        customer2.setFirstName("Jane");
        customer2.setLastName("Smith");
        customer2.setGender("Female");
        customer2.setProfession("Doctor");

        customer3 = new Customer();
        customer3.setId(new ObjectId());
        customer3.setCustomerId("3"); // Set customer ID
        customer3.setFirstName("Michael");
        customer3.setLastName("Johnson");
        customer3.setGender("Male");
        customer3.setProfession("Teacher");

        mockCustomers = Arrays.asList(customer1,customer2,customer3);
        maleCustomers = Arrays.asList(customer1,customer3);

    }
    @Test
    public void testGetCustomerByGender() {
        // Set up mock behavior for customerRepo.findByGender
        when(customerRepo.findByGender("Male")).thenReturn(maleCustomers);
        List<Customer> result = customerService.getCustomerByGender("Male");
        assertEquals(maleCustomers.size(), result.size());
    }
    @Test
    public void testCreateCustomer() {
        // Set up mock behavior for customerRepo.save
        when(customerRepo.save(any(Customer.class))).thenReturn(customer1);
        Customer createdCustomer = customerService.createCustomer(customer1);
        assertEquals(customer1, createdCustomer);
    }
    @Test
    public void testUpdateCustomer() {
        // Set up mock behavior for customerRepo.findByCustomerId
        when(customerRepo.findByCustomerId(any(String.class))).thenReturn(customer1);
        // Set up mock behavior for customerRepo.save
        when(customerRepo.save(any(Customer.class))).thenReturn(customer1);
        Customer updatedCustomer = customerService.updateCustomer(customer1.getCustomerId(), customer1);
        assertEquals(customer1, updatedCustomer);
    }
    @Test
    public void testDeleteExistingCustomer() {
        // Set up mock behavior for customerRepo.findByCustomerId
        when(customerRepo.findByCustomerId(any(String.class))).thenReturn(customer1);
        boolean result = customerService.deleteCustomer(customer1.getCustomerId());
        assertTrue(result);
    }
    @Test
    public void testDeleteNonExistingCustomer() {
        // Set up mock behavior for customerRepo.findByCustomerId
        when(customerRepo.findByCustomerId(any(String.class))).thenReturn(null);
        boolean result = customerService.deleteCustomer("nonExistentId");
        assertFalse(result);
    }

}
