package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.ecommerce.EasyCart.Entity.Customer;


public interface CustomerRepository extends Repository<Customer, Integer>{
	
	Optional<Customer> findById(Integer customerId);
	
	Optional<Customer> findByCustomerIdAndPassword(Integer customerId, String password);
	
	Optional<Customer> findByEmail(String email);
	
	Customer save(Customer customer);
	
	Collection <Customer> findAll();
	
	void delete(Customer orElseThrow);
	
	Optional<Customer> findIdByEmail(String email);
	
	
	//Customer save(String name, String email, String encode);

}
