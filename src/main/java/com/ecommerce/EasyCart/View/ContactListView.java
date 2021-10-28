package com.ecommerce.EasyCart.View;

import java.sql.Date;

import com.ecommerce.EasyCart.Entity.Contact;
import com.ecommerce.EasyCart.Json.Json;

public class ContactListView {
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

		public ContactListView(Integer contactId, String firstName, String lastName, String address, String city,
				String pinCode, String landmark, String state, String country, String phone, String email, byte status) {
			super();
			this.contactId = contactId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.city = city;
			this.pinCode = pinCode;
			this.landmark = landmark;
			this.state = state;
			this.country = country;
			this.phone = phone;
			this.email = email;
			this.status = status;
			
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
