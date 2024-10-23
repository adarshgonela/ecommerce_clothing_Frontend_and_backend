package com.adarsh.vijayalakshmisarees_Springboot.sarees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Sareesdao{
    @Autowired
    private Sareesrepo sareesrepo;
    public Sarees saveSarees(Sarees sarees) {
        return sareesrepo.save(sarees);
    }
    public List<Sarees> getAllsarees(){
        return sareesrepo.findAll();
    }


public Optional<Sarees> getbyId(int id){
       return sareesrepo.findById(id);
}


    public List<Sarees> getsareesbytype(String name) {
        return sareesrepo.getsareesbytype(name);
    }

    public List<Sarees> getsareesbyname(String name) {
        return sareesrepo.getsareesbyname(name);
    }


    public List<Sarees> findSareesByPriceRange(Double minPrice, Double maxPrice) {
        return sareesrepo.findByPriceRange(minPrice,maxPrice);
    }


    public List<Sarees> getsareesbyid(List<Integer> ids){
        return sareesrepo.findAllById(ids);
    }



}
