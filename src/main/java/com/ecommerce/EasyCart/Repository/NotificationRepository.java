package com.ecommerce.EasyCart.Repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.ecommerce.EasyCart.Entity.Notification;


public interface NotificationRepository extends Repository<Notification,Integer>{
	
	Notification save(String message);

	Notification save(Notification notification);
	
//Collection<Notification> findAllByCreateDateDesc();
	Collection<Notification> findAll();
}
