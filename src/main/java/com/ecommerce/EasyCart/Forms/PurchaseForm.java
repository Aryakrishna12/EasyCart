package com.ecommerce.EasyCart.Forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PurchaseForm {
	
	@NotBlank
    @Size(max = 225)
    private String orderName;

	public String getOrderName() {
		return orderName;
	}
	
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	


}
