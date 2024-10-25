package com.adarsh.Booking_Service.Booking;

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
    @NotNull(message = "enter  amount")
        private int amount;
    @NotNull(message = "enter Payment Method")
    private String paymentMethod;
    @PastOrPresent
    private LocalDateTime Bookingdateandtime;
//    @NotNull//for more ids
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<SareesResponse> sareeslist;
//    @NotNull //1product * quantities
//    private int items;



  }
