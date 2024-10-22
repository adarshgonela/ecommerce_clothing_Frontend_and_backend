package com.adarsh.vijayalakshmisarees_Springboot.sarees;

import com.adarsh.vijayalakshmisarees_Springboot.imageUtil.ImageModel;
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

//    private String imagePath;

    @OneToOne(cascade = CascadeType.ALL)
    private ImageModel imageModel;
}
