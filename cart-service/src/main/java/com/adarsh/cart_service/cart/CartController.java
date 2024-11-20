package com.adarsh.cart_service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@Transactional
@Async
public class CartController {
    @Autowired
private CartService service;
@PostMapping("/save")
    public Cart savecontroller(@RequestBody Cart cart){
        return  service.saveservice(cart);
    }

    @GetMapping("/all")
    public List<Cart> getallcartitems(){
        return  service.getallcartitems();
    }


    @GetMapping("/id/{id}")
    public Optional<Cart> getbyidcart(@PathVariable int id){
        return service.getbyidcart(id);
    }
    @PostMapping("/idpost/{id}")
    public Optional<Cart> getbyidcartpost(@PathVariable int id){
        return service.getbyidcart(id);
    }

    @PutMapping("/update")
    public String updatecontroller(@RequestBody Cart cart){
        return  service.updateservice(cart);
    }

}
