package com.adarsh.Booking_Service.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Bookingservice {
    @Autowired
    private  BookingDao dao;
    public Booking saveServiceBooking(Booking booking) {
        return dao.saveBooking(booking);
    }

    public List<Booking> getAllServiceBooking() {
        return  dao.getBooking();
    }



}
