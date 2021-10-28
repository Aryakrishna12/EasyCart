package com.ecommerce.EasyCart.View;

import java.util.Date;

import com.ecommerce.EasyCart.Json.Json;

public class NotificationListView {
	private final int notificationId;
	private final int customerId;
	private final int productId;
	private final String message;
	 @Json.DateTimeFormat
     private final Date createDate;
	 
	 
	 
	public NotificationListView(int notificationId, int customerId, int productId, String message, Date createDate) {
		super();
		this.notificationId = notificationId;
		this.customerId = customerId;
		this.productId = productId;
		this.message = message;
		this.createDate = createDate;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public int getProductId() {
		return productId;
	}
	public String getMessage() {
		return message;
	}
	public Date getCreateDate() {
		return createDate;
	}
	 
	 

}
