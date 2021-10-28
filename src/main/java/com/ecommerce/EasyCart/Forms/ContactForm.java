package com.ecommerce.EasyCart.Forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactForm {
	    @Size(max = 30)
	    @NotBlank
	    private String firstName;
	    @Size(max = 30)
	    private String lastName;
	    @Size(max = 200)
	    @NotBlank
	    private String address;
	    @Size(max = 50)
	    @NotBlank
	    private String city;
	    @Size(max = 50)
	    @NotBlank
	    private String landmark;
	    @Size(max = 50)
	    @NotBlank
	    private String state;
	    @Size(max = 50)
	    @NotBlank
	    private String country;
	    @Size(max = 8)
	    @NotBlank
	    private String pinCode;
	    @Size(max = 20)
	    @NotBlank
	    private String phone;
	    @Size(max = 225)
	    @NotBlank
	    private String email;
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
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
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

	    
}