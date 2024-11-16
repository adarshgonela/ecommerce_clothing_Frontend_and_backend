package com.adarsh.springjwt.clients;

import com.adarsh.springjwt.clientResponses.SareesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class SareeClient {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getallsareescontroller() {
        String productEndpoint = "http://localhost:8765/SAREES-SERVICE/sarees/all";
        ResponseEntity<String> response = restTemplate.getForEntity(
                productEndpoint,
                String.class);
        return response;
    }

    @PostMapping("/product/save")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<String> createProduct(@RequestBody SareesResponse sareesResponse) {
        String createsareeEndpoint = "http://localhost:8765/SAREES-SERVICE/sarees/savesaree";
        ResponseEntity<String> response = restTemplate.exchange(
                createsareeEndpoint,
                HttpMethod.POST,
                new HttpEntity<>(sareesResponse),
                String.class
        );
        return response;
    }

    @PostMapping("/product/save")
    @PreAuthorize("hasRole('ADMIN') ")
    public ResponseEntity<String> createDistribusi(@RequestBody DistribusiRequest distribusiRequest) {
        String distribusiEndpoint = "http://localhost:8765/SAREES-SERVICE/sarees/savesaree";
        ResponseEntity<String> response = restTemplate.exchange(
                distribusiEndpoint,
                HttpMethod.POST,
                new HttpEntity<>(distribusiRequest),
                String.class
        );
        return response;
    }


}
