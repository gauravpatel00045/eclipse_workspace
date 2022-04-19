package com.sbcrud.springbootjpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbcrud.springbootjpacrud.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
