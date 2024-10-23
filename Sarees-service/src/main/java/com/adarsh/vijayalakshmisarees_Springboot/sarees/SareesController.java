package com.adarsh.vijayalakshmisarees_Springboot.sarees;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@CrossOrigin
@RequestMapping("/sarees")
@Transactional
public class SareesController {
    @Autowired
    private  Sareesservice sareesservice;

//    @PostMapping("/savesaree")
//    public ResponseEntity<Sarees> savesareecontroller(@RequestBody Sarees sarees) throws IOException {
//        return Optional.of(sareesservice.saveService(sarees))
//                .map(savedSaree -> new ResponseEntity<>(savedSaree, HttpStatus.CREATED))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
//    }

    @PostMapping("/savesaree")
    public ResponseEntity<Sarees> savesareecontroller(@RequestBody Sarees sarees) {
        try {
            // Use Optional to handle the result of the save operation
            return Optional.ofNullable(sareesservice.saveService(sarees))
                    .map(savedSaree -> new ResponseEntity<>(savedSaree, HttpStatus.CREATED))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
        } catch (Exception e) {
            // Handle any other exceptions
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/all")
    @Async
    public ResponseEntity<List<Sarees>> getallcontroller() {
        try {
            List<Sarees> sareeList = sareesservice.getallservice();
            return Optional.ofNullable(sareeList)
                    .filter(list -> !list.isEmpty())
                    .map(list -> new ResponseEntity<>(list, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            // Log the exception if necessary
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{name}")
    public List<Sarees> getsareesbytype( @PathVariable String name) {
        return sareesservice.getsareesbytype(name);
    }

    @GetMapping("/name/{name}")
    public List<Sarees> getsareesbyname( @PathVariable String name) {
        return sareesservice.getsareesbyname(name);
    }
    @GetMapping("/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Sarees>> findByPriceRange(@PathVariable("minPrice") Double minPrice, @PathVariable("maxPrice") Double maxPrice){
        return sareesservice.findByPriceRange(minPrice,maxPrice);
    }



    @GetMapping("/{id}")
public Optional<Sarees> getbyid(@PathVariable int id){
        return sareesservice.getbyIdService(id);
}
    @GetMapping("/get-sarees-id")
    public List<Sarees> getsareesbyid(List<Integer> ids){
        return sareesservice.getsareesbyid(ids);
    }



}