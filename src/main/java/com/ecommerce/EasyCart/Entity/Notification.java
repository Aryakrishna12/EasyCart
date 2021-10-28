package com.ecommerce.EasyCart.Entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer notificationId;
	    private String message;
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createDate;
	   // @ManyToOne(optional = false, fetch = FetchType.LAZY)
	  //  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	    //@ManyToOne(cascade = CascadeType.MERGE,optional = false, fetch = FetchType.LAZY)
	    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @ManyToOne(cascade = CascadeType.MERGE)
	    private Customer customer;
	    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
	   //@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	   //@ManyToOne(cascade = CascadeType.MERGE,optional = false, fetch = FetchType.LAZY)
        //@JoinColumn(name="product_id", nullable=false)
	    //@ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @ManyToOne(cascade = CascadeType.MERGE)
	    private Product product;
	    
	    public Notification(Integer customerId,Integer productId,String message) {
	    	this.message=message; 	
	    	this.customer=new Customer(customerId);
	    	this.product=new Product(productId);
	    	Date dt = new Date();
		    this.createDate=dt;

	    }
	    public Notification() {
	    	
	    }
		public Integer getNotificationId() {
			return notificationId;
		}

		public void setNotificationId(Integer notificationId) {
			this.notificationId = notificationId;
		}
         

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
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

		
}
