package com.adarsh.cart_service.sareesResponse;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Sareesresponse {
    private int id;
    private String sareetype;
    private String sareename;
    private int sareesmrp;
    private int sareesprice;
    private int sareesquantity;

}
