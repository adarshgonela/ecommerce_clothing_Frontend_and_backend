package com.adarsh.vijayalakshmisarees_Springboot.Images.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adarsh.vijayalakshmisarees_Springboot.Images.entity.FileData;

//import com.mdtalalwasim.fileproject2.service.impl.FileDataServiceImpl;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{

	Optional<FileData> findByName(String fileName);

}
