package com.ecommerce.EasyCart.Repository;

import org.springframework.data.repository.Repository;

import com.ecommerce.EasyCart.Entity.ImageModel;

public interface ImageRepository extends Repository<ImageModel,Integer>{
	
	public ImageModel findByImage(String image);

	public void save(ImageModel filemode);
	
	public ImageModel findByCustomerCustomerId(Integer customerId);

	public void delete(ImageModel findByCustomerCustomerId);
	
	public ImageModel findByImageId(Integer imageId);
	
}
