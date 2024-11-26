package com.adarsh.discount_service.discount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Integer> {
    Optional<Discount> findByDiscountPercentage(String discountPercentage);
}
