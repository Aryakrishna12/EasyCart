package com.ecommerce.EasyCart.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.EasyCart.Entity.Product;
import com.ecommerce.EasyCart.Exception.NotFoundException;
import com.ecommerce.EasyCart.Forms.ProductForm;
import com.ecommerce.EasyCart.Repository.ProductJpaRepository;
import com.ecommerce.EasyCart.Repository.ProductRepository;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import com.ecommerce.EasyCart.Service.ProductService;
import com.ecommerce.EasyCart.View.ContactListView;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductDto;
import com.ecommerce.EasyCart.View.ProductListView;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	


	@Override
	public ProductDetailView add(ProductForm form) {
		// TODO Auto-generated method stub
		return new ProductDetailView(productRepository.save(new Product(form,SecurityUtil.getCurrentCustomerId())));
	}
	
	public List<ProductDto> listProducts(){
		List<Product> products = productRepository.findAll();
		List<ProductDto>  productDtos = new ArrayList<>();
		for(Product product:products) {
			ProductDto productDto = getProductListFromProduct(product);
			productDtos.add(productDto);
		}
		return productDtos;
		
	}
	public static ProductDto getProductListFromProduct(Product product) {
		ProductDto productDto =new ProductDto(product);
		return productDto;
	}

	/*@Override
	public Collection<ProductListView> list() {
		// TODO Auto-generated method stub
		return productRepository.findAllByCustomerCustomerId(SecurityUtil.getCurrentCustomerId());
	    // return productRepository.findAll();
	    		
	}*/

	/*@Override
	public ProductDetailView get(Integer productId) throws NotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findByProductIdAndCustomerCustomerId(productId, SecurityUtil.getCurrentCustomerId())
                .map((product) -> {
                    return new ProductDetailView(product);
                }).orElseThrow(NotFoundException::new);
	}*/
	
	@Override
	public Collection<ProductListView> get(Integer productId) throws NotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findAllByProductId(productId);
               
	}
	@Override
	public Collection<ProductListView> findAllByProductName(String productName) throws NotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findAllByProductName(productName);
               
	}
	
	@Override
	public Collection<ProductListView> findAllByCategory(String category) throws NotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findAllByCategory(category);
	}

	@Override
	@Transactional
	public ProductDetailView update(Integer productId, ProductForm form) throws NotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findByProductIdAndCustomerCustomerId(productId, SecurityUtil.getCurrentCustomerId())
				.map((product) ->{
					return new ProductDetailView(productRepository.save(product.update(form)));
				}).orElseThrow(NotFoundException::new);
	}

	@Override
	@Transactional
	public void delete(Integer productId) throws NotFoundException{
		// TODO Auto-generated method stub
		System.out.println(SecurityUtil.getCurrentCustomerId());
		productRepository.delete(
                productRepository.findByProductIdAndCustomerCustomerId(productId, SecurityUtil.getCurrentCustomerId())
                        .orElseThrow(NotFoundException::new)
        );
	}



	

	
}
