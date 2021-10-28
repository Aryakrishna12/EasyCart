package com.ecommerce.EasyCart.ServiceImpl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.EasyCart.Entity.Notification;
import com.ecommerce.EasyCart.Repository.NotificationRepository;
import com.ecommerce.EasyCart.Security.Util.SecurityUtil;
import com.ecommerce.EasyCart.Service.NotificationService;


@Service
public class NotificationServiceImpl implements NotificationService{
	
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public Notification send(Integer productId,String message) {
		// TODO Auto-generated method stub
		return notificationRepository.save(new Notification(SecurityUtil.getCurrentCustomerId(),productId,message));
	}

	@Override
	public Collection<Notification> get() {
		// TODO Auto-generated method stub
		return notificationRepository.findAll();
	}
	

}
