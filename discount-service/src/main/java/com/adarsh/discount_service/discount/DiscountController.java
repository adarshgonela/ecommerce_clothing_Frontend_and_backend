package com.adarsh.discount_service.discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {
@Autowired
private  DiscountService discountService;
   
// @GetMapping("/apply-discount")
// public String applyDiscount(@RequestParam int discountType) {
//     switch (discountType) {
//         case 1:
//             return "You get a 10% discount!";
//         case 2:
//             return "You get a 50% discount!";
//         case 3:
//             return "You get a 90% discount with 10% off!";
//         case 4:
//             return "You get a Buy 1 Get 1 offer!";
//         default:
//             return "Invalid discount type! Please press 1, 2, 3, or 4.";
//     }
// }

// // 10% Discount Method
// @GetMapping("/discount-10")
// public String discount10(@RequestParam int amount) {
//     return "Amount after 10% discount: " + (amount - (amount * 0.10));
// }

// // 50% Discount Method
// @GetMapping("/discount-50")
// public String discount50(@RequestParam int amount) {
//     return "Amount after 50% discount: " + (amount - (amount * 0.50));
// }

// // 90% Discount Method (10% off)
// @GetMapping("/discount-90")
// public String discount90(@RequestParam int amount) {
//     return "Amount after 90% discount (you pay only 10%): " + (amount * 0.10);
// }

// // Buy 1 Get 1 Method
// @GetMapping("/buy1-get1")
// public String buy1Get1(@RequestParam int quantity) {
//     return "You bought " + quantity + " items. You get " + (quantity) + " free items as part of the Buy 1 Get 1 offer!";
// }



    // Endpoint to apply discount based on discount type and amount
    @GetMapping("/apply-discount/{amount}/{discountpercentage}")
    public String applyDiscount(@PathVariable int amount, @PathVariable String discountpercentage) {
        return discountService.applyDiscount(amount, discountpercentage);
    }
    
}
