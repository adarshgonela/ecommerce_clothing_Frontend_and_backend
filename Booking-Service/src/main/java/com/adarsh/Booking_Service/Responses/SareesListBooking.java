package com.adarsh.Booking_Service.Responses;

import jakarta.persistence.*;
import lombok.Data;
//@Embeddable//This way, it will not create a separate table but will still allow you to store its fields in the Booking table
@Data
@Entity
public class SareesListBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sareeid;
    private int sareequantity;
}
