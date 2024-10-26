package com.adarsh.Booking_Service.Booking;

import com.adarsh.Booking_Service.Responses.SareesListBooking;
import com.adarsh.Booking_Service.Responses.SareesResponse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @NotNull(message = "enter  totalprice")
        private int totalprice;
    @NotNull(message = "enter Payment Method")
    private String paymentMethod;
    @PastOrPresent
    private LocalDateTime Bookingdateandtime;

@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinTable
//    @Transient // Mark this as transient to avoid persistence
    private List<SareesListBooking> sareesList; // Updated to use SareesListBooking

    @NotNull(message = "Enter items count")
    private int items;



  }
