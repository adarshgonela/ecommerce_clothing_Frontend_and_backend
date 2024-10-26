package com.adarsh.Booking_Service.Responses;

import jakarta.persistence.Entity;
import lombok.Data;
@Entity
@Data
public class SareesListBooking {
    private int sareeid;
    private int sareequantity;
}
