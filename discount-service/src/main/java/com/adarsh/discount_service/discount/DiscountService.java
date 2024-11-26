package com.adarsh.discount_service.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

@Autowired
private DiscountDao dao;

    public double applyDiscount(double originalPrice, String discountType) {
    return dao.applyDiscount(originalPrice, discountType);
    }
 public Page<Discount> getallDiscounts(Pageable pageable){
        return dao.getallDiscounts(pageable);
    }
    
    }
