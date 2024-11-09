package com.adarsh.Booking_Service.Booking;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.adarsh.Booking_Service.ExceptionHandling.Exceptions.NoDataPresentInDb;

import java.util.List;
@Service
public class Bookingservice {
    @Autowired
    private  BookingDao dao;

   public Booking saveServiceBooking(Booking booking) {
    try {
        return dao.saveBooking(booking); // Attempt to save the booking
    } catch (DataAccessException e) {
        throw new ServiceException("Unable to save booking at the moment. Please try again later.", e);
    }   
}


public List<Booking> getAllServiceBooking() throws NoDataPresentInDb {
    try {
        return dao.getBooking();  // Attempt to retrieve all bookings
    } catch (DataAccessException e) {
        throw new NoDataPresentInDb("no data present in db");
    }
}




}
