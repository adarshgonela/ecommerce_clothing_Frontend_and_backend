package com.adarsh.discount_service.discount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiscountRepo extends JpaRepository<Discount,Integer> {
    Discount findByDiscountPercentage(String discountpercentage);
    

}
