package com.adarsh.vijayalakshmisarees_Springboot.sarees;

import java.util.List;

import com.adarsh.vijayalakshmisarees_Springboot.Images.entity.FileData;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sarees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
    @NotNull(message = "type sareetype")
    private String sareetype;
    @NotNull(message = "type sareename")
    private String sareename;
    @NotNull(message = "sareesmrp")
private int sareesmrp;
    @NotNull(message = "sareesprice")
private int sareesprice;
    @NotNull(message = "type sarees quantity")
private int sareesquantity;

@OneToMany( cascade = CascadeType.ALL)
    private List<FileData> fileData;

    private int discountid;

}
