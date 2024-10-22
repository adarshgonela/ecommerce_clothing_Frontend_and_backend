package com.adarsh.Booking_Service.FeignConfig;

import com.adarsh.Booking_Service.Responses.SareesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient("VIJAYALAKSHMISAREESSPRINGBOOT")
public interface SareesCall {

    @GetMapping("/sarees/all")
    public List<SareesResponse> getallcontroller();

    @PostMapping("/sarees/savesaree")
    public SareesResponse savesareecontroller(@RequestBody SareesResponse sarees);
}
