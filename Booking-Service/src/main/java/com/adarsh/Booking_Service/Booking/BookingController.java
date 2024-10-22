package com.adarsh.Booking_Service.Booking;

import com.adarsh.Booking_Service.FeignConfig.SareesCall;
import com.adarsh.Booking_Service.Responses.SareesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    Bookingservice bookingservice;
@Autowired
private SareesCall sareesCall;
    @PostMapping("/save")
    public Booking saveControllerBooking(@RequestBody Booking booking)
    {
        return  bookingservice.saveServiceBooking(booking);
    }

    @GetMapping("/getall")
    public List<Booking> saveControllerBooking() {
        List<Booking> bookingList = bookingservice.getAllServiceBooking();
        return bookingList;
    }

    @GetMapping("/getall1")
    public List<SareesResponse> saveControllerBooking1() {
     return  sareesCall.getallcontroller();
    }
@PostMapping("/s")
    public SareesResponse savesarees(@RequestBody SareesResponse sareesResponse){
        return sareesCall.savesareecontroller(sareesResponse);
    }


}
