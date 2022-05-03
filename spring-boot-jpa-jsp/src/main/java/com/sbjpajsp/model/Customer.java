package com.sbjpajsp.model;

import javax.persistence.*;
import lombok.Data;

/**
 * This model class is use to define column in database and use getter and
 * setter value to pass the information between page
 * 
 */
@Entity
@Data
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", columnDefinition = "varchar(45)", nullable = false, length = 45)
	private String firstName;

	@Column(name = "last_name", columnDefinition = "varchar(45)", nullable = false, length = 45)
	private String lastName;

	@Column(name = "email", columnDefinition = "varchar(45)", nullable = false, length = 45)
	private String email;

	@Column(name = "birth_date", nullable = false)
	private String birthDate;

	@Column(name = "mobile", columnDefinition = "varchar(45)", nullable = false, length = 45)
	private String mobile;

	@Column(name = "address_1", columnDefinition = "varchar(255)", nullable = false, length = 255)
	private String address_1;

	@Column(name = "address_2", columnDefinition = "varchar(255)", length = 255)
	private String address_2;

	@Column(name = "age", columnDefinition = "int", nullable = false, length = 45)
	private String age;

	@Column(name = "gender", columnDefinition = "varchar(20)", nullable = false, length = 20)
	private String gender;

}
