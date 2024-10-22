package com.adarsh.vijayalakshmisarees_Springboot.sarees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Sareesservice {
    @Autowired
    private Sareesdao sareesdao;
    @Transactional
    public Sarees saveService(Sarees sarees) {
        return sareesdao.saveSarees(sarees);
    }

    public List<Sarees> getallservice(){
        return sareesdao.getAllsarees();
    }
    public Optional<Sarees> getbyIdService(int id){
        return sareesdao.getbyId(id);
    }

    public List<Sarees> getsareesbytype(String name) {
        return sareesdao.getsareesbytype(name);
    }
    public List<Sarees> getsareesbyname(String name) {
        return sareesdao.getsareesbyname(name);
    }

    public ResponseEntity<List<Sarees>> findByPriceRange(Double minPrice, Double maxPrice) {
        try {
            List<Sarees> sareesList = sareesdao.findSareesByPriceRange(minPrice, maxPrice);
            return Optional.ofNullable(sareesList)
                    .filter(list -> !list.isEmpty())
                    .map(list -> new ResponseEntity<>(list, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            System.err.println("Error retrieving sarees by price range: " + e.getMessage());
            e.printStackTrace(); // Or use a logger
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
