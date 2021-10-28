package com.ecommerce.EasyCart.Service;

import java.util.Collection;
import java.util.List;

import com.ecommerce.EasyCart.Entity.Notification;


public interface NotificationService {

	Notification send(Integer productId,String message);
	
	Collection<Notification> get();
}
