package com.adarsh.discount_service.discount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

@Autowired
private DiscountDao dao;


public String applyDiscount(int amount, String discountpercentage) {
return dao.applyDiscount(amount, discountpercentage);
}
   
    
    }
