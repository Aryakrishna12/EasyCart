package com.ecommerce.EasyCart.Controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.ecommerce.EasyCart.Entity.ImageModel;
import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Forms.ProductForm;
import com.ecommerce.EasyCart.Repository.ImageRepository;
import com.ecommerce.EasyCart.Repository.ProductRepository;
import com.ecommerce.EasyCart.Security.Util.FileUploadUtil;
import com.ecommerce.EasyCart.Service.ProductService;
import com.ecommerce.EasyCart.View.CustomerView;
import com.ecommerce.EasyCart.View.ProductDetailView;
import com.ecommerce.EasyCart.View.ProductDto;
import com.ecommerce.EasyCart.View.ProductListView;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.supercsv.io.CsvBeanWriter;
//import org.supercsv.io.ICsvBeanWriter;
//import org.supercsv.prefs.CsvPreference;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/product")
public class ProductController {
     @Autowired
    private ProductService productService;

     @Autowired
    private ProductRepository productRepository;
     
     @Autowired
     private NotificationController notficationController;
   /* @GetMapping
    public Collection<ProductListView> list(Principal p) {
        return productService.list();
    }*/
    @GetMapping("get/all")
    public ResponseEntity<List<ProductDto>> getProducts(){
    	List<ProductDto> body = productService.listProducts();
    	return new ResponseEntity<List<ProductDto>>(body,HttpStatus.OK);
    }

    @GetMapping("get/id/{productId}")
    public Collection<ProductListView> get(@PathVariable("productId") Integer productId) {
        return productService.get(productId);
    }
    
    //Collection<ProductListView>
    @GetMapping("get/name/{productName}")
    public Collection<ProductListView> getByProductName(@PathVariable("productName") String productName)
    {
    	return productService.findAllByProductName(productName);
    
    }
    @GetMapping("get/category/{category}")
    public Collection<ProductListView> getByCategory(@PathVariable("category") String category)
    {
    	return productService.findAllByCategory(category);
  
    }

    /*@PutMapping("/{productId}")
    public ProductDetailView update(
            @PathVariable("productId") Integer productId,
            @Valid @RequestBody ProductForm form) {
        return productService.update(productId, form);
    }*/
    @PutMapping("/{productId}")
    public ProductDetailView update(
    		 @RequestParam("file") MultipartFile file, 
            @PathVariable("productId") Integer productId,
            @RequestParam("product") String product) throws IOException {
    
        ProductForm form=new ObjectMapper().readValue(product,ProductForm.class);
        System.out.println(form);
       
           form.setImage(file.getBytes());
           form.setFileName(file.getOriginalFilename());
           String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            ProductDetailView p=productService.update(productId,form);
            String uploadDir = "main/product-photos/" + p.getProductId();
            System.out.println(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, file);
            
          
            
            return p;
    }


    @DeleteMapping("/delete/{productId}")
    public void delete(@PathVariable("productId") Integer productId) throws IOException {
        productService.delete(productId);
    }
    
    @PostMapping
        public ProductDetailView saveProduct(
            @RequestParam("file") MultipartFile file, @RequestParam("product") String product) throws IOException {
         System.out.println(product);
         System.out.println(file.getBytes());
         ProductForm form=new ObjectMapper().readValue(product,ProductForm.class);
         System.out.println(form);
        
            form.setImage(file.getBytes());
            form.setFileName(file.getOriginalFilename());
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
             ProductDetailView p=productService.add(form);
             String uploadDir = "main/product-photos/" + p.getProductId();
             System.out.println(uploadDir);
             FileUploadUtil.saveFile(uploadDir, fileName, file);
             
             //notificationController.
             return p;
         
    }
   
     
}




