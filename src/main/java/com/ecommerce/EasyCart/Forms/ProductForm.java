package com.ecommerce.EasyCart.Forms;

import java.util.Collection;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductForm {
	
	@Size(max = 30)
    @NotBlank
    private String productName;
	@Size(max = 200)
    @NotBlank
    private String description;
    @NotNull
    private Integer unitPrice;
    @NotNull
    private Integer msrp;
    @Size(max = 30)
    @NotBlank
    private String category;
    @NotNull
    private Integer stock;
    @Size(max = 30)
    private String size;
    @Size(max = 30)
    private String color;
    @Column(nullable = true, length = 225)
    private byte[] image;
    @Column(nullable = true, length = 225)
    private String fileName;
    
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
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getMsrp() {
		return msrp;
	}
	public void setMsrp(Integer msrp) {
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
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
    
    

}
