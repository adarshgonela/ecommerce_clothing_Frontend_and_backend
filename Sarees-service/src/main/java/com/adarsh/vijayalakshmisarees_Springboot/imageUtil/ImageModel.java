package com.adarsh.vijayalakshmisarees_Springboot.imageUtil;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by IntelliJ IDEA.
 * Project : springboot-image-upload
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/10/20
 * Time: 17.18
 */
@Entity
@Table(name = "image_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Lob
    @Column(name = "picByte", length = 100000)
    private byte[] picByte;


    public ImageModel(String originalFilename, String contentType, byte[] bytes) {
    }
}
