package com.ecommerce.EasyCart.View;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ecommerce.EasyCart.Entity.Product;

public class ProductDto {
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
     private byte status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
	public ProductDto(Product product) {
		// TODO Auto-generated constructor stub
		this.setProductId(product.getProductId());
		this.setProductName(product.getProductName());
		this.setDescription(product.getDescription());
		this.setUnitPrice(product.getUnitPrice());
		this.setMsrp(product.getMsrp());
		this.setSize(product.getSize());
		this.setColor(product.getColor());
		this.setCategory(product.getCategory());
		this.setStock(product.getStock());
		this.setFileName(product.getFileName());
		this.setImage(product.getImage());
		
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
    
    

}
