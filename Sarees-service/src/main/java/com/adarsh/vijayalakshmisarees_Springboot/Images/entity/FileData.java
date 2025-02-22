package com.adarsh.vijayalakshmisarees_Springboot.Images.entity;

import com.adarsh.vijayalakshmisarees_Springboot.sarees.Sarees;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "file_data")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String type;
	
	private String filePath;
	

}
