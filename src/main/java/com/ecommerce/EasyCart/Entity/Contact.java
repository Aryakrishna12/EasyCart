package com.ecommerce.EasyCart.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.ecommerce.EasyCart.Forms.ContactForm;

@Entity
public class Contact {
	public static enum Status {
        DELETED((byte) 0),
        ACTIVE((byte) 1);

        public final byte value;

        private Status(byte value) {
            this.value = value;
        }
    }
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String pinCode;
    private String landmark;
    private String state;
    private String country;
    private String phone;
    private String email;
    private byte status;

   @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
   

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }
    
    public Contact(ContactForm form, Integer customerId) {
    	this.customer = new Customer(customerId);
    	this.firstName = form.getFirstName();
    	this.lastName = form.getLastName();
    	this.address = form.getAddress();
    	this.city = form.getCity();
    	this.landmark = form.getLandmark();
    	this.pinCode = form.getPinCode();
    	this.state = form.getState();
    	this.country = form.getCountry();
    	this.phone = form.getPhone();
    	this.email = form.getEmail();
    	
    	this.status = Status.ACTIVE.value;

        
    }
    public Contact update(ContactForm form) {
    	this.firstName = form.getFirstName();
    	this.lastName = form.getLastName();
    	this.address = form.getAddress();
    	this.city = form.getCity();
    	this.landmark = form.getLandmark();
    	this.pinCode = form.getPinCode();
    	this.state = form.getState();
    	this.country = form.getCountry();
    	this.phone = form.getPhone();
    	this.email = form.getEmail();
    	
    	return this;
    }

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}


}
