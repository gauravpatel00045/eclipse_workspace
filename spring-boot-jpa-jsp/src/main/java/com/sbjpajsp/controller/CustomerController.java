package com.sbjpajsp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sbjpajsp.constant.Constant;
import com.sbjpajsp.exception.CustomerNotFoundException;
import com.sbjpajsp.model.Customer;
import com.sbjpajsp.service.CustomerServiceImpl;

/**
 * Controller class is used to call api and redirect the users as per
 * requirement
 * 
 */
@Controller
@RequestMapping("/")
public class CustomerController {

	// class object declaration
	@Autowired
	CustomerServiceImpl customerService;

	/**
	 * 
	 * To go index page
	 */
	@GetMapping("/")
	public String home() {
		return "index";
	}

	/**
	 * To display customerform.jsp page
	 */
	@GetMapping("customerform")
	public String customerForm() {
		return "customerform";
	}

	/**
	 * 
	 * To get the customer list
	 * 
	 * @param model It is used to pass list to the view with key parameter
	 * @return It redirect to customerlist.jsp with customerList
	 * 
	 */
	@GetMapping("/customerlist")
	public String customerList(Model model) {
		List<Customer> customerList = customerService.getCustomerList();
		model.addAttribute("customerList", customerList);
		return "customerlist";
	}

	/**
	 * To register new customer
	 * 
	 * @param customer It will get the customer named value and save it to the
	 *                 database
	 * @return It redirect to customerList.jsp file by calling
	 *         <code>customerlist</code> api
	 * @see CustomerController#customerList(Model)
	 */
	@RequestMapping("/register")
	public String registerCustomer(@ModelAttribute("customer") Customer customer) {
		System.err.println("register api call");
		customerService.saveCustomer(customer);
		return "redirect:/customerlist";
	}

	/**
	 * To check the email existence with the database
	 * 
	 * @param email email that needs to be check with database record
	 * @param model
	 * @return it return either duplicate or unique, after validating with the
	 *         database record
	 */
	@RequestMapping("/checkemail")
	public @ResponseBody String checkEmailValidity(String email, Model model) {
		if (customerService.isEmailAlreadyExist(email)) {
			return Constant.DUPLICATE;
		} else {
			return Constant.UNIQUE;
		}
	}

	/**
	 * To check email and mobile details with existing record and manage the
	 * duplication while edit or add operation
	 * 
	 * @param id     customer id
	 * @param email  customer email
	 * @param mobile customer mobile
	 * @return It return the <code>duplicate<code> if record found in database
	 *         except with same id
	 */
	@RequestMapping("/checkemailandmobile")
	public @ResponseBody String checkEmailAndMobile(Long id, String email, String mobile) {
		boolean isEmailExist;
		boolean isMobileExist;

		if (id != Constant.FROM_EDIT) {
			// existing user
			isEmailExist = customerService.isEmailAlreadyExist(id, email);
			isMobileExist = customerService.isMobileAlreadyExist(id, mobile);

			if (isEmailExist || isMobileExist) {
				return Constant.DUPLICATE;
			} else {
				return Constant.UNIQUE;
			}
		} else {
			// new user
			isEmailExist = customerService.isEmailAlreadyExist(email);
			isMobileExist = customerService.isMobileAlreadyExist(mobile);

			if (isEmailExist || isMobileExist) {
				return Constant.DUPLICATE;
			} else {
				return Constant.UNIQUE;
			}
		}
	}

	/**
	 * To redirect user to the form to modify information.
	 * 
	 * @param model      It use to set an object
	 * @param id         customer id that needs to find the record from the database
	 * @param attributes to display the error if there is any issue
	 * @return It redirect to customerform.jsp to display the data
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEditPage(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page = null;
		try {
			Customer customer = customerService.getCustomerById(id);
			model.addAttribute("customer", customer);
			page = "customerform";
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:/customerlist";
		}
		return page;
	}

	/**
	 * To modify the existing customer information
	 * 
	 * @param customer updated information from customerform.jsp file
	 * @return It redirect to customerlist.jsp by calling customerlist api
	 * @see CustomerController#customerList(Model)
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute Customer customer) {
		customerService.updateCustomer(customer);
		return "redirect:/customerlist";
	}

	/**
	 * To delete the required customer
	 * 
	 * @param id customer id that needs to remove from database
	 * @return It redirect to the customerlist.jsp file
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteCustomerById(@RequestParam Long id) {
		String page = null;
		try {
			customerService.deleteCustomerById(id);
			page = "redirect:/customerlist";
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			page = "redirect:/customerlist";
		}
		return page;
	}

	/**
	 * To delete all record from the table
	 * 
	 * @return It redirects to the customerlist.jsp
	 * @see CustomerServiceImpl#deleteAllCustomerRecord()
	 */
	@RequestMapping("/deleteall")
	public String deleteAllCustomer() {
		String page = null;
		try {
			customerService.deleteAllCustomerRecord();
			page = "redirect:/customerlist";
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			page = "redirect:/customerlist";
		}
		return page;
	}

	/**
	 * To log the data in the console
	 * 
	 * @param customer object details
	 */
	public String toString(Customer customer) {
		String modelData = customer.getId() + " " + customer.getFirstName() + " " + customer.getLastName()
				+ customer.getAddress_1() + " " + customer.getAddress_2() + " " + customer.getBirthDate() + " "
				+ customer.getGender() + " " + customer.getAge();
		return modelData;
	}

}
