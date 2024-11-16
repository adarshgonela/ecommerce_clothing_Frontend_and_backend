package com.adarsh.Booking_Service.Booking;

import com.adarsh.Booking_Service.ExceptionHandling.Exceptions.SareeNotFoundException;
import com.adarsh.Booking_Service.FeignConfig.SareesCall;
import com.adarsh.Booking_Service.Responses.SareesListBooking;
import com.adarsh.Booking_Service.Responses.SareesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    // @PostMapping("/save")
    // @Async
    // public Booking saveControllerBooking(@RequestBody Booking booking)
    // {
    //     return  bookingservice.saveServiceBooking(booking);
    // }

    @PostMapping("/save")
    @Async
    public Booking savebooking(@RequestBody Booking booking){
        int totalPrice = 0;
        int items=0;
        if (booking.getSareesList() != null) {
            for (SareesListBooking sareesList : booking.getSareesList()) {
                // Fetch saree by ID

                Optional<SareesResponse> optionalSareesResponse = sareesCall.getbyidpost(sareesList.getSareeid());
                // Check if the saree is present
                System.out.println(optionalSareesResponse);
                if (optionalSareesResponse.isPresent()) {
                    // Calculate the price for the current saree
                    SareesResponse sareesResponse = optionalSareesResponse.get();
                    int pricePerSaree = sareesResponse.getSareesprice();
                    totalPrice += pricePerSaree * sareesList.getSareequantity(); // Accumulate total price
                    items += sareesList.getSareequantity();
                } else {
                    // Handle case where saree is not found (optional)
                    // You can throw an exception or log a warning
                    throw new SareeNotFoundException();
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
    public ResponseEntity<List<Booking>> saveControllerBooking() {
        try {
            List<Booking> bookingList = bookingservice.getAllServiceBooking();

            if (bookingList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 if no bookings found
            }
            return new ResponseEntity<>(bookingList, HttpStatus.OK); // Return 200 with the list
        } catch (Exception e) {
            // Log the exception (use a logger for production code)
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Return 500 for any other errors
        }
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
