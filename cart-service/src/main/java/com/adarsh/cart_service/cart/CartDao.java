package com.adarsh.cart_service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CartDao {
    @Autowired
    private CartRepo cartRepo;
    public Cart savecart(Cart cart){
       return cartRepo.save(cart);
    }

    public List<Cart> getallcartitems(){
        return  cartRepo.findAll();
    }
    
    public Optional<Cart> getbyidcart(int id){
        return cartRepo.findById(id);
    }

    public String updatecart(Cart cart){
       Optional<Cart> optionalCart= cartRepo.findById(cart.getId());
       if (optionalCart.isPresent()){
            cartRepo.save(cart);
            return "update Done";
       }
       return "update not done";
    }


}
