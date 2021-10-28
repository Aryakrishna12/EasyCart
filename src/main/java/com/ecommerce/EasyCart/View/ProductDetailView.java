package com.ecommerce.EasyCart.View;

import java.util.Collection;
import java.util.Collections;

import com.ecommerce.EasyCart.Entity.Product;

public class ProductDetailView extends ProductListView{
	
	// private final Collection<String> categoryName;
	 
	 public ProductDetailView(Product product) {
		 super(
			product.getProductId(),
			product.getProductName(),
			product.getDescription(),
			product.getUnitPrice(),
			product.getMsrp(),
			product.getCategory(),
			product.getStock(),
			product.getSize(),
			product.getColor(),
			product.getImage(),
			product.getFileName(),
			product.getStatus(),
			product.getCreateDate()
			
		);
		 // this.categoryName = Collections.unmodifiableCollection(product.getCategoryName());
	 }

	//public Collection<String> getCategoryName() {
		//return categoryName;
	//}
	 

}
