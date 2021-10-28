package com.ecommerce.EasyCart.View;

import java.util.Date;

//import java.sql.Date;

import com.ecommerce.EasyCart.Entity.Purchase;
import com.ecommerce.EasyCart.Json.Json;
public class PurchaseView {
	private final int purchaseId;
	private final String purchaseName;
	@Json.DateFormat(pattern = "yyyy-MM-dd")
	private final Date purchaseDate;
	
	public PurchaseView (Purchase purchase) {
		this.purchaseId=purchase.getPurchaseId();
		this.purchaseName=purchase.getPurchaseName();
		this.purchaseDate=purchase.getPurchaseDate();
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public String getPurchaseName() {
		return purchaseName;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	  }
	
	 
	
	
	
	

}
