package com.sbjpajsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.sbjpajsp.exception.CustomerNotFoundException;
import com.sbjpajsp.model.Customer;
import com.sbjpajsp.repository.CustomerRepository;

/**
 * This class implements the insert,update,delete operation for Customer
 * operation.
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	// class object declaration
	@Autowired
	CustomerRepository customerRepository;

	/**
	 * To save record
	 * 
	 * @param customer Customer class object
	 */
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	/**
	 * To get the customer list
	 */
	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	/**
	 * 
	 * To get customer information by id
	 * 
	 * @param id customer id that needs to find the data
	 */
	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new CustomerNotFoundException("Customer with Id : " + id + " Not Found");
		}
	}

	/**
	 * To delete all record from database
	 */
	@Override
	public void deleteAllCustomerRecord() {
		// TODO Auto-generated method stub
		customerRepository.deleteAll();
	}

	/**
	 * To delete particular data by id
	 * 
	 * @param id customer id to find and remove record from the database
	 */
	@Override
	public void deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
		customerRepository.delete(getCustomerById(id));
	}

	/**
	 * To save modified record
	 * 
	 * @param customer modified information that bind with object
	 */
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	/**
	 * TODO Needs to implement the code
	 */
	@Override
	public Customer addOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * To find record by emailId
	 * 
	 * @param emailId record that needs to check with database
	 * @return It return true if record found else return false
	 */
	public boolean isEmailAlreadyExist(String emailId) {
		if (customerRepository.findByEmail(emailId).size() > 0) {
			int repeatCount = customerRepository.findByEmail(emailId).size();
			System.err.println("emailId: " + emailId + "repeatCount: " + repeatCount);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To find record by emailId while user use edit operation.
	 * 
	 * @param id      user id
	 * @param emailId record that needs to check with database
	 * @return It return true if record found else return false
	 */
	public boolean isEmailAlreadyExist(Long id, String emailId) {
		if (customerRepository.findByEmailAndId(id, emailId) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To find record by mobile
	 * 
	 * @param mobile record that needs to check with database
	 * @return It return true if record found else return false
	 */
	public boolean isMobileAlreadyExist(String mobile) {
		if (customerRepository.findByMobile(mobile).size() > 0) {
			int repeatCount = customerRepository.findByMobile(mobile).size();
			System.err.println("mobile: " + mobile + "repeatCount: " + repeatCount);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To check mobile record with database while user use edit operation.
	 * 
	 * @param id     customer's id
	 * @param mobile mobile no which user typed in input text
	 * @return It return true if record is already exist except the same id
	 */
	public boolean isMobileAlreadyExist(Long id, String mobile) {
		if (customerRepository.findByMobileAndId(id, mobile) > 0) {
			int repeatCount = customerRepository.findByMobileAndId(id, mobile);
			System.err.println("mobile: " + mobile + "repeatCount: " + repeatCount);
			return true;
		} else {
			return false;
		}
	}

}
