package com.ecommerce.EasyCart.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EasyCart.Entity.Purchase;
import com.ecommerce.EasyCart.Forms.PurchaseForm;
import com.ecommerce.EasyCart.Json.Json.DateFormat;
import com.ecommerce.EasyCart.Json.Json.DateTimeFormat;
import com.ecommerce.EasyCart.Repository.PurchaseRepository;
import com.ecommerce.EasyCart.Service.PurchaseService;
import com.ecommerce.EasyCart.View.PurchaseView;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	@Autowired
    private PurchaseService purchaseService;
	
	 @Autowired
	 private PurchaseRepository purchaseRepository;
    
    @PostMapping
    public PurchaseView add(@Valid @RequestBody PurchaseForm form) {
        return purchaseService.add(form);
    }
    
    @GetMapping("{purchaseDate}")
    public Collection<PurchaseView> findAllByPurchaseDate(
    @PathVariable(value="purchaseDate")
    @DateFormat(pattern = "yyyy-MM-dd") String purchaseDate) throws ParseException{
    
    	DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDate d=LocalDate.parse(purchaseDate,df);
    	System.out.println(d);
    	return purchaseService.findAllByPurchaseDate(d);

    }
    
   


}
