package com.ecommerce.EasyCart.ServiceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.EasyCart.Entity.Contact;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Forms.ContactForm;
import com.ecommerce.EasyCart.Repository.ContactRepository;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import com.ecommerce.EasyCart.Service.ContactService;
import com.ecommerce.EasyCart.View.ContactDetailView;
import com.ecommerce.EasyCart.View.ContactListView;


@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
    private ContactRepository contactRepository;

	@Override
	public Collection<ContactListView> list() {
		 return contactRepository.findAllByCustomerCustomerId(SecurityUtil.getCurrentCustomerId());
	}

	@Override
	public ContactDetailView add(ContactForm form) {
		return new ContactDetailView(contactRepository.save(new Contact(form, SecurityUtil.getCurrentCustomerId())));
	}

	@Override
	public ContactDetailView get(Integer contactId) throws NotFoundException {
		return contactRepository.findByContactIdAndCustomerCustomerId(contactId, SecurityUtil.getCurrentCustomerId())
                .map((contact) -> {
                    return new ContactDetailView(contact);
                }).orElseThrow(NotFoundException::new);
	}

	@Override
	 @Transactional
	public ContactDetailView update(Integer contactId, ContactForm form) throws NotFoundException {
		 return contactRepository.findByContactIdAndCustomerCustomerId(contactId, SecurityUtil.getCurrentCustomerId())
	                .map((contact) -> {
	                    return new ContactDetailView(contactRepository.save(contact.update(form)));
	                }).orElseThrow(NotFoundException::new);
	    }
	}	

	


