package com.ecommerce.EasyCart.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ImageModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;
	private String image;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

    private Customer customer;
	
	public ImageModel(String image) {
		this.image=image;
	}
	
	public ImageModel(String image, Integer customerId) {
		 this.customer = new Customer(customerId);
		this.image=image;
		}
	
	public ImageModel(Integer imageId) {
		this.imageId=imageId;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ImageModel() {
		super();
	}	
}
