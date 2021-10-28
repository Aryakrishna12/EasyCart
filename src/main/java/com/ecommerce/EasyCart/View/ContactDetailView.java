package com.ecommerce.EasyCart.View;

import com.ecommerce.EasyCart.Entity.Contact;

public class ContactDetailView extends ContactListView{

	public ContactDetailView(Contact contact) {
		super(
				contact.getContactId(),
				contact.getFirstName(),
				contact.getLastName(),
				contact.getAddress(),
				contact.getCity(),
				contact.getLandmark(),
				contact.getPinCode(),
				contact.getState(),
				contact.getCountry(),
				contact.getPhone(),
				contact.getEmail(),
				contact.getStatus()
				);
		
	}

}
