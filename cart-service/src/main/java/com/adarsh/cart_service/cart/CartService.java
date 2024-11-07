package com.adarsh.cart_service.cart;

import com.adarsh.cart_service.Feign.SareesFeignController;
import com.adarsh.cart_service.exceptionHandlings.exceptions.ListIsEmptyException;
import com.adarsh.cart_service.sareesResponse.Sareesresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartDao dao;

    @Autowired
    SareesFeignController sareesFeignController;
//    public Cart saveservice(Cart cart) {
//        if (cart.getCartItems() != null) {
//            int totalPrice = 0; // Initialize total price variable
//            for (CartItems cartItems : cart.getCartItems()) {
//                Optional<Sareesresponse> sareesresponse = sareesFeignController.getbyidpost(cartItems.getProductid());
//System.out.println(sareesresponse);
//                if (sareesresponse.isPresent()) {
//                    // Get the saree price and calculate the total price for the current item
//                    Sareesresponse sareesResponse = sareesresponse.get();
//                    int pricePerSaree = sareesResponse.getSareesprice();
//                    totalPrice += pricePerSaree * cartItems.getProductquantity(); // Add to the total price
//                } else {
//                    // Log a warning or handle the missing saree case appropriately
//                    System.out.println("Saree not found for product ID: " + cartItems.getProductid());
//                }
//            }
//
//            // After the loop, set the total price
//            cart.setTotalprice(totalPrice);
//        }
//
//        // Save the cart after calculating the total price
//        return dao.savecart(cart);
//    }

    @PostMapping("/save")
    public Cart saveservice(Cart cart) {
        try {
            if (cart.getCartItems() != null) {
                int totalPrice = 0; // Initialize total price variable

                for (CartItems cartItems : cart.getCartItems()) {
                    Optional<Sareesresponse> sareesresponse = sareesFeignController.getbyidpost(cartItems.getProductid());
                    System.out.println(sareesresponse);

                    if (sareesresponse.isPresent()) {
                        // Get the saree price and calculate the total price for the current item
                        Sareesresponse sareesResponse = sareesresponse.get();
                        int pricePerSaree = sareesResponse.getSareesprice();
                        totalPrice += pricePerSaree * cartItems.getProductquantity(); // Add to the total price
                    } else {
                        // Log a warning or handle the missing saree case appropriately
                        System.out.println("Saree not found for product ID: " + cartItems.getProductid());
                    }
                }

                // After the loop, set the total price
                cart.setTotalprice(totalPrice);
            }

            // Save the cart after calculating the total price
            return dao.savecart(cart);

        } catch (NullPointerException e) {
            // Handle cases where cart or cart items might be null
            System.err.println("Error: Null pointer exception while processing the cart. " + e.getMessage());
            e.printStackTrace();
            // You can rethrow or return a specific error message
            throw new RuntimeException("Invalid cart data encountered", e);

        } catch (Exception e) {
            // Catch any general exception that could occur during processing (e.g. database errors, feign client issues)
            System.err.println("Error occurred while saving the cart: " + e.getMessage());
            e.printStackTrace();
            // You can throw a custom exception or rethrow the exception
            throw new RuntimeException("An error occurred while processing the cart", e);
        }
    }


    public List<Cart> getallcartitems() {
        try {
            // Fetch all cart items from the DAO
            List<Cart> cartItems = dao.getallcartitems();

            // Check if the list is null or empty, and handle accordingly
            if (cartItems == null || cartItems.isEmpty()) {
                System.out.println("No cart items found.");
            }

            return cartItems;

        } catch (ListIsEmptyException e) {
            // Handle database-related exceptions (e.g., connection failure, query issues)
            System.err.println("Database error occurred while fetching cart items: " + e.getMessage());
            e.printStackTrace();
            // Return an empty list or throw a custom exception depending on your requirements
            return new ArrayList<>(); // You could also throw a custom exception or return null

        } catch (Exception e) {
            // Handle any unexpected general exceptions
            System.err.println("Error occurred while fetching cart items: " + e.getMessage());
            e.printStackTrace();
            // Return an empty list or handle the error in a way that suits your application
            return new ArrayList<>();
        }
    }


    public Optional<Cart> getbyidcart(int id) {
        try {
            // Validate the input id (e.g., check if it's a positive number)
            if (id <= 0) {
                throw new IllegalArgumentException("Invalid cart ID. ID must be greater than zero.");
            }

            // Fetch the cart by ID from the DAO
            Optional<Cart> cart = dao.getbyidcart(id);

            if (cart.isEmpty()) {
                // Log or handle the case when no cart is found
                System.out.println("No cart found with ID: " + id);
            }

            return cart;

        } catch (IllegalArgumentException e) {
            // Handle invalid input (e.g., non-positive ID)
            System.err.println("Invalid input: " + e.getMessage());
            e.printStackTrace();
            // Return an empty Optional or a custom error message depending on your use case
            return Optional.empty();  // You can also throw a custom exception if needed

        } catch (Exception e) {
            // Handle unexpected errors such as database connection issues
            System.err.println("Error occurred while fetching the cart: " + e.getMessage());
            e.printStackTrace();
            // Return an empty Optional or throw a custom exception depending on the scenario
            return Optional.empty();
        }
    }


    public String updateservice(Cart cart) {
        try {
            // Check if cart is valid (e.g., not null or empty)
            if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
                throw new IllegalArgumentException("Cart or Cart items cannot be null or empty");
            }

            // Attempt to update the cart using the DAO
            return dao.updatecart(cart);

        } catch (IllegalArgumentException e) {
            // Handle specific validation errors (e.g., invalid cart input)
            System.err.println("Validation error: " + e.getMessage());
            e.printStackTrace();
            return "Error: Invalid cart data provided";

        } catch (Exception e) {
            // Handle general exceptions (e.g., database errors, external service failures)
            System.err.println("Error occurred while updating the cart: " + e.getMessage());
            e.printStackTrace();
            return "Error: Unable to update the cart due to a system error";
        }
    }

}
