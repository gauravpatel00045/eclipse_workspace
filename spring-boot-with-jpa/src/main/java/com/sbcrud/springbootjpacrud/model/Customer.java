package com.sbcrud.springbootjpacrud.model;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * Getter and Setter methods
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public @Data class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column(name = "firstName")
	String firstName;

	@Column(name = "lastName")
	String lastName;

	@Column(name = "address")
	String address;
	
}
