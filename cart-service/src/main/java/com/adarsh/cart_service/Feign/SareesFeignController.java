package com.adarsh.cart_service.Feign;

import com.adarsh.cart_service.sareesResponse.Sareesresponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient("VIJAYALAKSHMISAREESSPRINGBOOT")
public interface SareesFeignController {

    @PostMapping("/sarees/{id}")
    public Optional<Sareesresponse> getbyidpost(@PathVariable int id);

}
