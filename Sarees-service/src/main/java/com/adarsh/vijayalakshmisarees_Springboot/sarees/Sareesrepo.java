package com.adarsh.vijayalakshmisarees_Springboot.sarees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface Sareesrepo extends JpaRepository<Sarees,Integer> {

    @Query("SELECT s FROM Sarees s WHERE s.sareetype LIKE %:name%")
    List<Sarees> getsareesbytype(@PathVariable("name") String name);

    @Query("SELECT s FROM Sarees s WHERE s.sareename LIKE %:name%")
    List<Sarees> getsareesbyname(@PathVariable("name") String name);


    @Query("SELECT s FROM Sarees s WHERE s.sareesprice BETWEEN :minPrice AND :maxPrice")
    List<Sarees> findByPriceRange(@PathVariable("minPrice") Double minPrice, @PathVariable("maxPrice") Double maxPrice);

    List<Sarees> findAllById(Iterable<Integer> ids);

}
