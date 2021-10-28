package com.ecommerce.EasyCart.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.validation.Errors;

import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Forms.CustomerLoginForm;
import com.ecommerce.EasyCart.View.CustomerLoginView;
import com.ecommerce.EasyCart.View.CustomerView;
import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Exception.BadRequestException;
import com.ecommerce.EasyCart.Exception.NotFoundException;

public interface CustomerService {
	
	CustomerView add(CustomerForm form);
	
	CustomerView currentCustomer();
	
	CustomerLoginView login(CustomerLoginForm form, Errors errors) throws BadRequestException;
	
	CustomerLoginView refresh(String refreshToken) throws BadRequestException;
	
	Collection<Customer> list();
	
	void delete(Integer customerId);
	
	CustomerView update(Integer customerId,CustomerForm form) throws NotFoundException;
	
	Optional<Customer> getCustomerIdByEmail(String email);
	//List<Object> findByEmail(String n);
}
