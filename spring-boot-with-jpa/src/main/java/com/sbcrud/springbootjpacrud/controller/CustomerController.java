package com.sbcrud.springbootjpacrud.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sbcrud.springbootjpacrud.model.Customer;
import com.sbcrud.springbootjpacrud.repository.CustomerRepository;

/**
 * To perform the CRUD operation
 * 
 * @CrossOrigin(origins = "http://localhost:8080")
 */
@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	/**
	 * Get all the customer
	 *
	 * @return ResponseEntity
	 */
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getCustomerList() {
		try {
			return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Get the employee by id
	 *
	 * @param id
	 * @return ResponseEntity
	 */
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
		try {
			// check if employee exist in database
			Customer customer = getCustById(id);

			if (customer != null) {
				return new ResponseEntity<>(customer, HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * To add new Customer
	 *
	 * @param userInput
	 * @return ResponseEntity
	 */
	@PostMapping("/customer")
	public ResponseEntity<Customer> newCustomer(@RequestBody Customer userInput) {
		Customer newCustomer = customerRepository.save(Customer.builder().firstName(userInput.getFirstName())
				.lastName(userInput.getLastName()).address(userInput.getAddress()).build());
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

	/**
	 * Update Customer record by using it's id
	 *
	 * @param id
	 * @param userInput
	 * @return
	 */
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomerInfo(@PathVariable("id") long id, @RequestBody Customer userInput) {

		// check if employee exist in database
		Customer customerUpdatedObj = getCustById(id);

		if (customerUpdatedObj != null) {
			customerUpdatedObj.setFirstName(userInput.getFirstName());
			customerUpdatedObj.setLastName(userInput.getLastName());
			return new ResponseEntity<>(customerRepository.save(customerUpdatedObj), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Delete Customer by Id
	 *
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable("id") long id) {
		try {
			// check if employee exist in database
			Customer customer = getCustById(id);

			if (customer != null) {
				customerRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.OK);
			}

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete all customer
	 *
	 * @return ResponseEntity
	 */
	@DeleteMapping("/customer")
	public ResponseEntity<HttpStatus> deleteAllCustomers() {
		try {
			customerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Method to get the record by id
	 *
	 * @param id
	 * @return Employee
	 */
	private Customer getCustById(long id) {
		Optional<Customer> empObj = customerRepository.findById(id);

		if (empObj.isPresent()) {
			return empObj.get();
		}
		return null;
	}
	
}
