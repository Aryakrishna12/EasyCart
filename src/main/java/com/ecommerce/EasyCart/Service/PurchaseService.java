package com.ecommerce.EasyCart.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;



import com.ecommerce.EasyCart.Forms.PurchaseForm;
import com.ecommerce.EasyCart.View.PurchaseView;

public interface PurchaseService {
	
	PurchaseView add(PurchaseForm form);
	
	//Collection <PurchaseView> List(String purchase_name);

	//Collection<PurchaseView> findByPurchaseName(String purchase_name);
	
	Collection<PurchaseView> findAllByPurchaseDate(LocalDate d);
	
}
