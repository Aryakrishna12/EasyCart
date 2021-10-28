package com.ecommerce.EasyCart.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EasyCart.Entity.Customer;
import com.ecommerce.EasyCart.Forms.CustomerForm;
import com.ecommerce.EasyCart.Service.CustomerService;
import com.ecommerce.EasyCart.View.CustomerView;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerView add(@Valid @RequestBody CustomerForm form) {
        return customerService.add(form);
    }
    
    @GetMapping("/get")
    public Collection<Customer> list() {
        return customerService.list();
    }
    
    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable("customerId") Integer customerId) {
    	customerService.delete(customerId);
    }
    
    //update
    @PutMapping("/{customerId}")
    public CustomerView update(
            @PathVariable("customerId") Integer customerId,
            @Valid @RequestBody CustomerForm form) {
        return customerService.update(customerId, form);
    }
    
    @GetMapping("/getId/{email}")
    public Optional<Customer> getId(@PathVariable("email") String email) {
        return customerService.getCustomerIdByEmail(email);
    }
    
    
    
}
