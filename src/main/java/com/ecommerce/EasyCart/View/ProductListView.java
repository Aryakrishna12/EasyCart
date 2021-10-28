package com.ecommerce.EasyCart.View;

import java.util.Date;

import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Json.Json;

public class ProductListView {
	
	 private final int productId;
	 private final String productName;
	 private final String description;
	 private final int unitPrice;
	 private final int msrp;
	 private final String category;
	 private final int stock;
	 private final String size;
	 private final String color;
	 private final byte status;
	 @Json.DateTimeFormat
     private final Date createDate;
	private final byte[] image;
	private final String fileName;
    
	/*public ProductListView(int productId, String productName, String description, int unitPrice, int msrp, String size,
			String color, byte[] image, String fileName,byte status, Date createDate, Date updateDate) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.msrp = msrp;
		this.size = size;
		this.color = color;
		//this.image= image;
		//this.fileName=fileName;
		this.status = status;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}*/

	/*public ProductListView(Integer productId2, String productName2, String description2, int unitPrice2, int msrp2,
			String size2, String color2, byte[] image, String fileName, byte status2, Date createDate2) {
		// TODO Auto-generated constructor stub
	}*/

	public ProductListView(Integer productId, String productName, String description, int unitPrice, int msrp,
			String category,int stock,String size, String color, byte[] image, String fileName, byte status, Date createDate) {
		
		// TODO Auto-generated constructor stub
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.msrp = msrp;
		this.category=category;
		this.stock=stock;
		this.size = size;
		this.color = color;
		this.image= image;
		this.fileName=fileName;
		this.status = status;
		this.createDate = createDate;
		
	}

	

	public int getProductId() {
		return productId;
	}
	public int setProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getDescription() {
		return description;
	}

	public int getUnitPrice() {
		return unitPrice;
	}
	
	

	public String getCategory() {
		return category;
	}

	public int getMsrp() {
		return msrp;
	}

	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public byte getStatus() {
		return status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public byte[] getImage() {
		return image;
	}

	public String getFileName() {
		return fileName;
	}



	public int getStock() {
		return stock;
	}



	
	
	
    
    

}
