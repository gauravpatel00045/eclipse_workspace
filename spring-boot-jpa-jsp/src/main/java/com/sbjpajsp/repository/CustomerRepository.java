package com.sbjpajsp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sbjpajsp.model.Customer;

/**
 * Customer repository class to perform insert,update and delete
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	/**
	 * To find record by emailId
	 */
	public List<Customer> findByEmail(String email);

	/**
	 * To find record by mobile
	 */
	public List<Customer> findByMobile(String mobile);

	/**
	 * To find email record by emailId and id that use while edit the information
	 */
	@Query(value = "SELECT COUNT(*) FROM customer WHERE id NOT IN (:id)  AND email = :email", nativeQuery = true)
	public int findByEmailAndId(Long id, String email);

	/**
	 * To find mobile record by mobile and id that use while edit the information
	 */
	@Query(value = "SELECT COUNT(*) FROM customer WHERE id NOT IN (:id)  AND mobile = :mobile", nativeQuery = true)
	public int findByMobileAndId(Long id, String mobile);

}
