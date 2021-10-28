package com.ecommerce.EasyCart.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.ecommerce.EasyCart.Entity.Purchase;
import com.ecommerce.EasyCart.View.PurchaseView;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
	
	Purchase save(Purchase purchase);
	
	public static final String FIND_PurchaseName="SELECT purchase_name FROM purchase Where purchase_date=?";
	@Query(value =  FIND_PurchaseName , nativeQuery=true)
	Collection findByPurchaseDate(LocalDate d);
}
