package com.adarsh.discount_service.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class DiscountDao {
@Autowired
private DiscountRepo discountRepository;
    

public String applyDiscount(int amount, String discountpercentage) {
    Discount discount = discountRepository.findByDiscountPercentage(discountpercentage);
    
    if (discount == null) {
        return "Invalid discount type!";
    }

    switch (discountpercentage) {
        case "10%":
            return "Discounted amount after 10%: " + (amount - (amount * 0.10));
        case "50%":
            return "Discounted amount after 50%: " + (amount - (amount * 0.50));
        case "B1G1":
            return "You bought " + amount + " items. You get " + amount + " free items!";
        default:
            return "Unknown discount type!";
    }
}
}
