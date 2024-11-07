package com.adarsh.cart_service.exceptionHandlings.exceptions;

public class SareeNotFoundException extends RuntimeException {
    public SareeNotFoundException() {
        super("No Saree Found");
    }
}
