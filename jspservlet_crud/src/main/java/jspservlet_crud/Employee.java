package jspservlet_crud;

import java.io.Serializable;
import lombok.Data;

/**
 * This model class perform to get and set the value from database to user view.
 * 
 */
public @Data class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String contact;
	
}
