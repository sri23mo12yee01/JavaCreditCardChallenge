package com.Project.CreditCard;

import com.Project.CreditCard.entity.Customer;
import com.Project.CreditCard.repo.CustomerRepo;
import com.Project.CreditCard.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CreditCardApplicationTests {

	@Mock
	private CustomerRepo customerRepo;

	@InjectMocks
	private CustomerService customerService;

	private List<Customer> mockCustomers;
	private Customer mockCustomer;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockCustomers = new ArrayList<>();
		mockCustomer = new Customer();
	}

	@Test
	public void testGetCustomerByGender() {
		// Set up mock behavior
		when(customerRepo.findByGender(any(String.class))).thenReturn(mockCustomers);

		// Call the service method
		List<Customer> result = customerService.getCustomerByGender("Male");

		// Assert the result
		assertEquals(mockCustomers, result);
	}

	@Test
	public void testGetCustomerByProfession() {
		// Set up mock behavior
		when(customerRepo.findByProfession(any(String.class))).thenReturn(mockCustomers);

		// Call the service method
		List<Customer> result = customerService.getCustomerByProfession("Engineer");

		// Assert the result
		assertEquals(mockCustomers, result);
	}

	@Test
	public void testCreateCustomer() {
		// Set up mock behavior
		when(customerRepo.save(any(Customer.class))).thenReturn(mockCustomer);

		// Call the service method
		Customer result = customerService.createCustomer(mockCustomer);

		// Assert the result
		assertEquals(mockCustomer, result);
	}

	@Test
	public void testUpdateCustomer() {
		// Set up mock behavior
		String mockId = "mockId";
		when(customerRepo.findByCustomerId(any(String.class))).thenReturn(mockCustomer);
		when(customerRepo.save(any(Customer.class))).thenReturn(mockCustomer);

		// Call the service method
		Customer result = customerService.updateCustomer(mockId, mockCustomer);

		// Assert the result
		assertEquals(mockCustomer, result);
	}

	@Test
	public void testDeleteCustomer() {
		// Set up mock behavior
		String mockId = "mockId";
		when(customerRepo.findByCustomerId(any(String.class))).thenReturn(mockCustomer);

		// Call the service method
		boolean result = customerService.deleteCustomer(mockId);

		// Assert the result
		Assertions.assertTrue(result);
	}
}
