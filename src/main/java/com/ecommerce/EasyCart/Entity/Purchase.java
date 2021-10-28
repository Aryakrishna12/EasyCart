package com.ecommerce.EasyCart.Entity;

//import java.sql.Date;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Purchase {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer purchaseId;
	    private String purchaseName;
	    @Temporal(TemporalType.DATE)
	    private Date purchaseDate;
	 
	    
		public Purchase(String purchaseName) {
			this.purchaseName=purchaseName;
			Date dt = new Date();				
	        this.purchaseDate = dt;
		}
		
		public Purchase() {
			
		}

		public Integer getPurchaseId() {
			return purchaseId;
		}

		public void setPurchaseId(Integer purchaseId) {
			this.purchaseId = purchaseId;
		}

		public String getPurchaseName() {
			return purchaseName;
		}

		public void setPurchaseName(String purchaseName) {
			this.purchaseName = purchaseName;
		}

		public Date getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
        
		
		

}
