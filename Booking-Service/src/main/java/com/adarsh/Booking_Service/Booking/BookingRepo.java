package com.adarsh.Booking_Service.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
