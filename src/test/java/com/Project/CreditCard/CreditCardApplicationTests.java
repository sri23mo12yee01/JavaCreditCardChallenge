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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreditCardApplicationTests {

	@Mock
	private CustomerRepo customerRepo;

	@InjectMocks
	private CustomerService customerService;

	private List<Customer> mockCustomers;

	private Customer customer1;
	private Customer customer2;
	private Customer customer3;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		// Create mock customers
		customer1 = new Customer();
		customer1.setId(new ObjectId());
		customer1.setFirstName("John");
		customer1.setLastName("Doe");
		customer1.setGender("Male");
		customer1.setProfession("Engineer");

		customer2 = new Customer();
		customer2.setId(new ObjectId());
		customer2.setFirstName("Jane");
		customer2.setLastName("Smith");
		customer2.setGender("Female");
		customer2.setProfession("Doctor");

		customer3 = new Customer();
		customer3.setId(new ObjectId());
		customer3.setFirstName("Michael");
		customer3.setLastName("Johnson");
		customer3.setGender("Male");
		customer3.setProfession("Teacher");

		mockCustomers = new ArrayList<>();
		mockCustomers.add(customer1);
		mockCustomers.add(customer2);
		mockCustomers.add(customer3);

		// Set up mock behavior for customerRepo.findByGender
		when(customerRepo.findByGender(any(String.class))).thenReturn(mockCustomers);

		// Set up mock behavior for customerRepo.findByProfession
		when(customerRepo.findByProfession(any(String.class))).thenReturn(mockCustomers);
	}

	@Test
	public void testGetCustomerByGender() {
		List<Customer> result = customerService.getCustomerByGender("Male");
		assertEquals(mockCustomers, result);
	}

	@Test
	public void testGetCustomerByProfession() {
		List<Customer> result = customerService.getCustomerByProfession("Engineer");
		assertEquals(mockCustomers, result);
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
