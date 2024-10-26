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

import java.awt.print.Book;
import java.time.LocalDateTime;
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
//    @PostMapping("/save")
//    @Async
//    public Booking saveControllerBooking(@RequestBody Booking booking)
//    {
//        return  bookingservice.saveServiceBooking(booking);
//    }

    @PostMapping("/save11")
    @Async
    public Booking savebooking(@RequestBody Booking booking){
        int totalPrice = 0;
        int items=0;
        if (booking.getSareesList() != null) {
            for (SareesListBooking sareesList : booking.getSareesList()) {
                // Fetch saree by ID
                Optional<SareesResponse> optionalSareesResponse = sareesCall.getbyidpost(sareesList.getSareeid());
                // Check if the saree is present
                if (optionalSareesResponse.isPresent()) {
                    // Calculate the price for the current saree
                    SareesResponse sareesResponse = optionalSareesResponse.get();
                    int pricePerSaree = sareesResponse.getSareesprice();
                    totalPrice += pricePerSaree * sareesList.getSareequantity(); // Accumulate total price
                    items += sareesList.getSareequantity();
                } else {
                    // Handle case where saree is not found (optional)
                    // You can throw an exception or log a warning
                    System.out.println("Saree with ID " + sareesList.getSareeid() + " not found.");
                }
            }
        }
        booking.setTotalprice(totalPrice);
        booking.setItems(items);
        booking.setBookingdateandtime(LocalDateTime.now());

        // Save the booking using the service
        return bookingservice.saveServiceBooking(booking);
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







}
