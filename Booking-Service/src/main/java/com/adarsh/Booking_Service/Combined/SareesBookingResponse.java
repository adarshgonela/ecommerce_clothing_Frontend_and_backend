package com.adarsh.Booking_Service.Combined;

import com.adarsh.Booking_Service.Responses.SareesListBooking;
import com.adarsh.Booking_Service.Responses.SareesResponse;

public class SareesBookingResponse {
    private SareesListBooking sareesListBooking;
    private SareesResponse sareesResponse;

    public SareesBookingResponse(SareesListBooking sareesListBooking, SareesResponse sareesResponse) {
        this.sareesListBooking = sareesListBooking;
        this.sareesResponse = sareesResponse;
    }

    // Getters and Setters
    public SareesListBooking getSareesListBooking() {
        return sareesListBooking;
    }

    public void setSareesListBooking(SareesListBooking sareesListBooking) {
        this.sareesListBooking = sareesListBooking;
    }

    public SareesResponse getSareesResponse() {
        return sareesResponse;
    }

    public void setSareesResponse(SareesResponse sareesResponse) {
        this.sareesResponse = sareesResponse;
    }

    @Override
    public String toString() {
        return "SareesBookingResponse{" +
                "sareesListBooking=" + sareesListBooking +
                ", sareesResponse=" + sareesResponse +
                '}';
    }
}

