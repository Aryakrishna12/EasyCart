package com.ecommerce.EasyCart.Service;

import java.util.Collection;
import java.util.List;

import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Forms.ProductForm;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductDto;
import com.ecommerce.EasyCart.View.ProductListView;

public interface ProductService {
	
	ProductDetailView add(ProductForm form);
	
	//Collection<ProductListView> list();
	//Collection<ProductListView> list();
	
	//ProductDetailView get(Integer productId) throws NotFoundException;
	
	ProductDetailView update(Integer productId, ProductForm form) throws NotFoundException;
	
	void delete (Integer productId) throws NotFoundException;

	Collection<ProductListView> findAllByProductName(String productName) throws NotFoundException;
	
	Collection<ProductListView> findAllByCategory(String category) throws NotFoundException;
	
	List<ProductDto> listProducts();
	Collection<ProductListView> get(Integer productId);
}
