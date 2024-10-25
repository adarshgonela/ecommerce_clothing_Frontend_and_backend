package com.adarsh.Booking_Service.Booking;

import com.adarsh.Booking_Service.FeignConfig.SareesCall;
import com.adarsh.Booking_Service.Responses.SareesListBooking;
import com.adarsh.Booking_Service.Responses.SareesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    Bookingservice bookingservice;
@Autowired
private SareesCall sareesCall;
    @PostMapping("/save")
    @Async
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

    @PostMapping("/get-sarees-id")
    @Async
    public List<SareesResponse> getsareesbyids(@RequestBody List<Integer> ids){
        return sareesCall.getsareesbyids(ids);
    }

    @PostMapping("/get-sarees-id1")
    @Async
    public List<SareesResponse> getsareesbyids1(@RequestBody List<Integer> ids){

        return sareesCall.getsareesbyids(ids);
    }



}
