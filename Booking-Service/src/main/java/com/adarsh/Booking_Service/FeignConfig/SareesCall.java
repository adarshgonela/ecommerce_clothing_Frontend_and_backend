package com.adarsh.Booking_Service.FeignConfig;

import com.adarsh.Booking_Service.Responses.SareesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@FeignClient("VIJAYALAKSHMISAREESSPRINGBOOT")
public interface SareesCall {

    @GetMapping("/sarees/all")
    public List<SareesResponse> getallcontroller();

    @PostMapping("/sarees/savesaree")
    public SareesResponse savesareecontroller(@RequestBody SareesResponse sarees);

    @PostMapping("/sarees/get-sarees-id")
    public List<SareesResponse> getsareesbyids(@RequestBody List<Integer> ids);

    @GetMapping("/sarees/{id}")
    public Optional<SareesResponse> getbyid(@PathVariable int id);
    @PostMapping("/sarees/{id}")
    public Optional<SareesResponse> getbyidpost(@PathVariable int id);
}
