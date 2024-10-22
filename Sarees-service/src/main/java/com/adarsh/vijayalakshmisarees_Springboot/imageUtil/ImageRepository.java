package com.adarsh.vijayalakshmisarees_Springboot.imageUtil;

import com.adarsh.vijayalakshmisarees_Springboot.imageUtil.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : Upload-Images-Spring-Boot-Angular8-MySQL
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 08/10/20
 * Time: 19.51
 */
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}
