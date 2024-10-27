package com.adarsh.Booking_Service.ExceptionHandling.Exceptions;

public class SareeNotFoundException extends RuntimeException{
    public SareeNotFoundException() {
        super("No Saree Found");
    }
}
