package com.adarsh.Booking_Service.Combined;

import com.adarsh.Booking_Service.FeignConfig.SareesCall;
import com.adarsh.Booking_Service.Responses.RepoSareeList;
import com.adarsh.Booking_Service.Responses.SareesListBooking;
import com.adarsh.Booking_Service.Responses.SareesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/list")
@Transactional
public class SareeListControl {

    @Autowired
    private RepoSareeList repoSareeList;

    @Autowired
    private SareesCall sareesCall;

//    @GetMapping("/all")
//    public List<SareesBookingResponse> getall() {
//        List<SareesListBooking> sareesList = repoSareeList.findAll();
//        List<SareesBookingResponse> combinedList = new ArrayList<>();
//
//        for (SareesListBooking sareesListBooking : sareesList) {
//            Optional<SareesResponse> optionalResponse = sareesCall.getbyidpost(sareesListBooking.getSareeid());
//
//            // Create a new SareesBookingResponse with the booking and the optional response
//            SareesBookingResponse combinedResponse = new SareesBookingResponse(sareesListBooking, optionalResponse.orElse(null));
//
//            combinedList.add(combinedResponse); // Add to the combined list
//
//            // Print the combined response
//            System.out.println(combinedResponse);
//        }
//
//        return combinedList; // Return the combined list
//    }

}