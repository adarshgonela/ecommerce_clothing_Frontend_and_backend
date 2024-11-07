package com.adarsh.cart_service.cart;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class CartItems {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int cartitemsid;
   private int productid;
   private int productquantity;
}
