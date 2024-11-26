package com.adarsh.discount_service.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
@Autowired
private  DiscountService discountService;
    @PostMapping("/apply/{originalPrice}/{discountType}")
    public ResponseEntity<Double> applyDiscount(@PathVariable double originalPrice, @PathVariable String discountType) {
        try {
            // Call the service method to calculate the discount
            double discountedPrice = discountService.applyDiscount(originalPrice, discountType);
            return ResponseEntity.ok(discountedPrice); // Return the discounted price with 200 OK status
        } catch (IllegalArgumentException e) {
            // Return a bad request if the discount type is invalid or not found
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // @GetMapping("/all/{pagenumber}")
    //  public Page<Discount> getallDiscounts(Pageable pageable,@PathVariable int pagenumber){
    //     pageable = PageRequest.of(pagenumber, 1); // Limit to 10 records per page

    //     return discountService.getallDiscounts(pageable);
    // }

    
}
