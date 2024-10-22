package com.adarsh.Booking_Service.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingDao {
    @Autowired
    private BookingRepo bookingRepo;

    public Booking saveBooking(Booking booking){
        return  bookingRepo.save(booking);
    }
    public List<Booking> getBooking()
    {
        return bookingRepo.findAll();

    }
}
