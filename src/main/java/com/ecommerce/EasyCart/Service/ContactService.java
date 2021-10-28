package com.ecommerce.EasyCart.Service;

import java.util.Collection;

import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Forms.ContactForm;
import com.ecommerce.EasyCart.View.ContactDetailView;
import com.ecommerce.EasyCart.View.ContactListView;


public interface ContactService {
	

    Collection<ContactListView> list();
    
    ContactDetailView add(ContactForm form);

    ContactDetailView get(Integer contactId) throws NotFoundException;

    ContactDetailView update(Integer contactId, ContactForm form) throws NotFoundException;

}
