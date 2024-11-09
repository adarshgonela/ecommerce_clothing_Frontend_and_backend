package com.adarsh.Booking_Service.ExceptionHandling.Exceptions;

public class NoDataPresentInDb extends RuntimeException{

    public NoDataPresentInDb(String msg){
    super(msg);
    }

}
