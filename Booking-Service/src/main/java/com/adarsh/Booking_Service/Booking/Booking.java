package com.adarsh.Booking_Service.Booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "enter customer Id")
    private  String customerId;
    @NotNull(message = "enter sareesId")
    private String sareesId;
    @NotNull(message = "enter orderid")
    private String orderid;
    @NotNull(message = "enter  amount")
        private int amount;
    @NotNull(message = "enter Payment Method")
    private String paymentMethod;
    @PastOrPresent
    private LocalDateTime Bookingdateandtime;

  }
