package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductListView;


public interface ProductRepository extends Repository<Product,Integer> {
	
	Product save(Product product);
	
	Collection<ProductListView> findAllByCustomerCustomerId(Integer customerId);
	//Collection<ProductListView> findAllByCustomerCustomerId();
	//Collection <ProductListView> findAll();
	
	Collection<ProductListView> findAllByProductName(String productName);
	
	Collection<ProductListView> findAllByCategory(String category);
	
	Collection<ProductListView> findAllByProductId(Integer productId);

   Optional<Product> findByProductIdAndCustomerCustomerId(Integer productId, Integer customerId);
   
    void delete(Product product);

	List<Product> findAll();
}
