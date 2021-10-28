package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.View.ProductListView;

public interface ProductJpaRepository extends JpaRepository<Product,Integer> {
	
	public static final String Find_Description="SELECT product_id,product_name,description,unit_price,msrp,size,color,image,create_date FROM product Where product_name=?";
	@Query(value =  Find_Description , nativeQuery=true)
	Collection findByProductName(String description);
	
	public static final String Find_All_By_Category="SELECT product_id,product_name,description,unit_price,msrp,category,size,color,image,create_date FROM product Where category=?";
	@Query(value =  Find_All_By_Category , nativeQuery=true)
	Collection findAllByCategory(String category);
	
	
}
