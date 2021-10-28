package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.ecommerce.EasyCart.Entity.Contact;
import com.ecommerce.EasyCart.View.ContactListView;

public interface ContactRepository extends Repository <Contact, Integer> {
	
	Optional<Contact> findByContactIdAndCustomerCustomerId(Integer contactId,Integer customerId);
	
	Collection<ContactListView> findAllByCustomerCustomerId(Integer customerId);
	
	Contact save(Contact contact);

}
