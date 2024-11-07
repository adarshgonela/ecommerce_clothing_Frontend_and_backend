package com.adarsh.cart_service.cart;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "type List of products")
    @OneToMany(cascade = CascadeType.ALL)
private List<CartItems> cartItems;
    @NotNull(message = "total price should not be zero" )
    private int totalprice;

    public void setId(int id) {
        this.id = id;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
}
