package com.sbjpajsp.service;

import com.sbjpajsp.model.Customer;

public abstract class AbCustomerServiceImpl implements ICustomerService {
	

	public abstract void isEmailIdAlreadyExist(Customer customer);
	
	public abstract void isMobileAlreadyExist(Customer customer); 
}
