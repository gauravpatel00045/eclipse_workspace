package com.sbjpajsp.service;

import java.util.List;
import com.sbjpajsp.model.Customer;
/**
 * Interface that performs the insert,update,delete for CustomerService
 * */
public interface ICustomerService {

	public Customer saveCustomer(Customer customer);

	public List<Customer> getCustomerList();

	public Customer getCustomerById(Long id);

	public void deleteAllCustomerRecord();

	public void deleteCustomerById(Long id);

	public void updateCustomer(Customer customer);

	public Customer addOrUpdateCustomer(Customer customer);
	
}