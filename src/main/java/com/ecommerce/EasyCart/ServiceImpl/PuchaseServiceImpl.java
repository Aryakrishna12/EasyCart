package com.ecommerce.EasyCart.ServiceImpl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

//import java.sql.Date;
//import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.EasyCart.Entity.Purchase;
import com.ecommerce.EasyCart.Forms.PurchaseForm;
import com.ecommerce.EasyCart.Repository.PurchaseRepository;
import com.ecommerce.EasyCart.Service.PurchaseService;
import com.ecommerce.EasyCart.View.PurchaseView;
@Service
public class PuchaseServiceImpl implements PurchaseService {
	 @Autowired
	 private PurchaseRepository purchaseRepository;

	@Override
	public PurchaseView add(PurchaseForm form) {
		// TODO Auto-generated method stub
		return new PurchaseView(purchaseRepository.save(new Purchase(
				form.getOrderName())));
	}

	@Override
	public Collection<PurchaseView> findAllByPurchaseDate(LocalDate d) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findByPurchaseDate(d);
		return result;
	}

	

	
	/*@Override
	public Collection<PurchaseView> findAllByPurchaseDate(Date localDate) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findAllByPurchaseDate(localDate);
		return result;
	}*/

	/*@Override
	public Collection<PurchaseView> findAllByPurchaseDate(Date purchase_date) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findAllByPurchaseDate((java.sql.Date) purchase_date);
		return result;
	}*/

	/*@Override
	public Collection<PurchaseView> findByPurchaseName(String purchase_name) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findByPurchaseName(purchase_name);
		return result; 
	}*/

	/*@Override
	public Collection<PurchaseView> findByPurchaseDate(String purchase_date) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findByPurchaseDate(purchase_date);
		return result;
	}*/

	//@Override
	/*public Collection<PurchaseView> findByPurchaseDate(Date purchase_date) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findByPurchaseDate(purchase_date);
		return result;
	}*/

	/*@Override
	public Collection<PurchaseView> findByPurchaseDate(java.util.Date date) {
		// TODO Auto-generated method stub
		Collection<PurchaseView> result=this.purchaseRepository.findByPurchaseDate(date);
		return result;
	}*/

	
}

