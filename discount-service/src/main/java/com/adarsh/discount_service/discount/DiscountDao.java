package com.adarsh.discount_service.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class DiscountDao {
@Autowired
private DiscountRepo discountRepository;
    public double applyDiscount(double originalPrice, String discountType) {
        Optional<Discount> discountOptional = discountRepository.findByDiscountPercentage(discountType);

        if (discountOptional.isPresent()) {
            Discount discount = discountOptional.get();

            switch (discount.getDiscountPercentage()) {
                case "10%":
                    return originalPrice * 0.90;
                case "50%":
                    return originalPrice * 0.50;
                case "B1G1":
                    return originalPrice * 0.50; // effectively 50% off (2 products for the price of 1)
                default:
                    throw new IllegalArgumentException("Unsupported discount type");
            }
        } else {
            throw new IllegalArgumentException("Discount type not found");
        }
    }


    public Page<Discount> getallDiscounts(Pageable pageable){
        return discountRepository.findAll(pageable);
    }

}
