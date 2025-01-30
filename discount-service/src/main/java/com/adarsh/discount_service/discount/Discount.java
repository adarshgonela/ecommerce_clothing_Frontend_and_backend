package com.adarsh.discount_service.discount;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // Field to store discount percentage/type (e.g., "10%", "50%", "B1G1")
    private String discountpercentage;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDiscountpercentage() {
        return discountpercentage;
    }
    public void setDiscountpercentage(String discountpercentage) {
        this.discountpercentage = discountpercentage;
    }
    

}
