package jspservlet_crud;

import java.io.Serializable;

/**
 * This model class perform to get and set the value from database to user view.
 * 
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String contact;
	
	/**
	 * @return id It returns the integer value
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id To set the integer value
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return firstName It returns the String value
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName To set the String value
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return firstName It returns the String value
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName To set the String value
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName It returns the String value
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username To set the String value
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password It returns the String value
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password To set the String value
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return address It returns the String value
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address To set the String value
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return contact It returns the String value
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact To set the String value
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

}
