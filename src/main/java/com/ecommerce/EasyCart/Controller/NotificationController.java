package com.ecommerce.EasyCart.Controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.EasyCart.Entity.Notification;
import com.ecommerce.EasyCart.Repository.NotificationRepository;
import com.ecommerce.EasyCart.Service.NotificationService;
import com.ecommerce.EasyCart.View.ProductListView;

@RestController
@RequestMapping("notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@PostMapping()
	public Notification save(@RequestParam(value="productId", required = false) Integer productId,
			@RequestParam(value="message", required = false) String message) {
		return notificationService.send(productId,message);
	}
	 @GetMapping()
	    public Collection<Notification> get() {
	        return notificationService.get();
	 }

}
