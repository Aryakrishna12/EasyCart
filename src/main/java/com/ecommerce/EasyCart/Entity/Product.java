/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.EasyCart.Entity;

/**
 *
 * @author user
 */

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ecommerce.EasyCart.Forms.ProductForm;
@Entity
public class Product {
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
    private Integer productId;
    private String productName;
    private String description;
    private int unitPrice;
    private int msrp;
    private String category;
    private int stock;
    private String size;
    private String color;
    private byte[] image;
    private String fileName;
    //@ElementCollection(fetch = FetchType.LAZY)
    //private Collection<String> categoryName;
     private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    //@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    private Customer customer;
    
    public Product() {
    	
    }
    
    public Product(ProductForm form, Integer customerId) {
        this.customer = new Customer(customerId);

        this.productName = form.getProductName();
        this.description = form.getDescription();
        this.unitPrice=form.getUnitPrice();
        this.msrp=form.getMsrp();
        this.size=form.getSize();
        this.color=form.getColor();
        
        this.image=form.getImage();
        this.fileName=form.getFileName();
        this.category=form.getCategory();
        this.stock=form.getStock();
        

        this.status = Status.ACTIVE.value;

        Date dt = new Date();
        this.createDate = dt;
    }
    
    
    
    //need to change
    
    public Product(Integer productId) {
		// TODO Auto-generated constructor stub
    	 this.productId=productId;
    	 this.description = description;
         this.unitPrice=unitPrice;
         this.msrp=msrp;
         this.size=size;
         this.color=color;
         
         this.image=image;
       this.fileName=fileName;
         this.category=category;
         this.stock=stock;
	}

    
    
	public Product update(ProductForm form) {
         this.productName = form.getProductName();
         this.description = form.getDescription();
         this.unitPrice=form.getUnitPrice();
         this.msrp=form.getMsrp();
         this.size=form.getSize();
         this.color=form.getColor();
         
         this.image=form.getImage();
       this.fileName=form.getFileName();
         this.category=form.getCategory();
         this.stock=form.getStock();
          
         this.status = Status.ACTIVE.value;
         
         Date dt = new Date();
         this.createDate = dt;
        

        
        return this;
    }
   
    
    
     public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getMsrp() {
		return msrp;
	}
	public void setMsrp(int msrp) {
		this.msrp = msrp;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
		
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public byte getStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }
        return Objects.equals(productId, ((Product) object).productId);
    }

    @Override
    public String toString() {
        return "com.ecommerce.EasyCart.Entity.Product[ productId=" + productId + " ]";
    }

}