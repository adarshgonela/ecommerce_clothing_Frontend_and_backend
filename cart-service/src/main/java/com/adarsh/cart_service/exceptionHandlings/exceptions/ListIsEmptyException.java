package com.adarsh.cart_service.exceptionHandlings.exceptions;

public class ListIsEmptyException extends RuntimeException{
    public ListIsEmptyException() {
        super("list is empty");
    }
}
