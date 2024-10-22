//package com.adarsh.vijayalakshmisarees_Springboot.imageUtil;
//
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//import java.util.zip.DataFormatException;
//import java.util.zip.Deflater;
//import java.util.zip.Inflater;
//
//
//@Log4j2
//@RestController
//@CrossOrigin
//@RequestMapping("/image")
//public class ImageUploadController {
//
//    @Autowired
//    private ImageRepository imageRepository;
//
//    @PostMapping("/upload")
//    public ResponseEntity.BodyBuilder uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
//
//        log.info("Original Image Byte Size - " + file.getBytes().length);
//        ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
//                compressBytes(file.getBytes()));
//        imageRepository.save(img);
//        return ResponseEntity.status(HttpStatus.OK);
//    }
//@GetMapping("/all")
//    public List<ImageModel> getAllimages(){
//        return imageRepository.findAll();
//    }
//
//    @GetMapping(path = {"/get/{imageName}"})
//    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
//
//        final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
//        ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
//                decompressBytes(retrievedImage.get().getPicByte()));
//        return img;
//    }
//
////    @GetMapping("/{imageid}")
////    public ResponseEntity<ImageModel> getImageById(@PathVariable Long imageid) {
////        // Attempt to find the image by ID
////        Optional<ImageModel> retrievedImage = imageRepository.findById(imageid);
////
////        // Check if the image exists
////        if (retrievedImage.isPresent()) {
////            // Create a new ImageModel with the retrieved data
////            ImageModel img = new ImageModel(
////                    retrievedImage.get().getId(),
////                    retrievedImage.get().getName()
////                    ,retrievedImage.get().getType(),
////                    decompressBytes(retrievedImage.get().getPicByte())
////            );
////            // Return the image model with a 200 OK status
////            return ResponseEntity.ok(img);
////        } else {
////            // If not found, return a 404 Not Found response
////            return ResponseEntity.status(HttpStatus.NOT_FOUND)
////                    .body(null); // or you can return an error message
////        }
////    }
//
//
//
////    @GetMapping("/{id}")
////    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
////        Optional<ImageModel> imageModel = imageRepository.findById(id);
////        return imageModel.map(model -> ResponseEntity.ok()
////                        .contentType(MediaType.valueOf(model.getType()))
////                        .body(model.getPicByte()))
////                .orElse(ResponseEntity.notFound().build());
////    }
//
//
//
//    // compress the image bytes before storing it in the database
//    public static byte[] compressBytes(byte[] data) {
//        Deflater deflater = new Deflater();
//        deflater.setInput(data);
//        deflater.finish();
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//        byte[] buffer = new byte[1024];
//        while (!deflater.finished()) {
//            int count = deflater.deflate(buffer);
//            outputStream.write(buffer, 0, count);
//        }
//        try {
//            outputStream.close();
//        } catch (IOException e) {
//        }
//        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
//
//        return outputStream.toByteArray();
//    }
//
//    // uncompress the image bytes before returning it to the angular application
//    public static byte[] decompressBytes(byte[] data) {
//        if (data == null || data.length == 0) {
//            return new byte[0]; // Return an empty array if input is null or empty
//        }
//
//        Inflater inflater = new Inflater();
//        inflater.setInput(data);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        try {
//            byte[] buffer = new byte[1024];
//            while (!inflater.finished()) {
//                int count = inflater.inflate(buffer);
//                outputStream.write(buffer, 0, count);
//            }
//        } catch (DataFormatException e) {
//            e.printStackTrace(); // Consider logging this error properly
//            return null; // You might want to throw a custom exception instead
//        } finally {
//            inflater.end(); // Clean up the inflater
//            try {
//                outputStream.close(); // Ensure output stream is closed
//            } catch (IOException e) {
//                e.printStackTrace(); // Log the error if closing fails
//            }
//        }
//
//        return outputStream.toByteArray(); // Return the decompressed bytes
//    }
//
//}


package com.adarsh.vijayalakshmisarees_Springboot.imageUtil;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Log4j2
@RestController
@CrossOrigin
@RequestMapping("/image")
@Transactional
public class ImageUploadController {

    @Autowired
    private ImageRepository imageRepository;

    @Async
    @PostMapping("/upload")
    public ResponseEntity<ImageModel> uploadImage(@RequestParam("imageFile") MultipartFile file) {
        try {
            log.info("Original Image Byte Size - {}", file.getBytes().length);
            ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
                    compressBytes(file.getBytes()));
            imageRepository.save(img);
            log.info("Image saved with ID: {}", img.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(img);
        } catch (IOException e) {
            log.error("Error uploading image: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Async
    @GetMapping("/all")
    public ResponseEntity<List<ImageModel>> getAllImages() {
        List<ImageModel> images = imageRepository.findAll();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/get/{imageName}")
    public ResponseEntity<Optional<ImageModel>> getImage(@PathVariable("imageName") String imageName) {
        Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
       return ResponseEntity.ok(retrievedImage);
       
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ImageModel>> getImageById(@PathVariable("id") Long id) {
        Optional<ImageModel> o=imageRepository.findById(id);
        byte[] picByte = o.get().getPicByte();
        return ResponseEntity.ok(imageRepository.findById(id));
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        log.info("Compressed Image Byte Size - {}", outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        if (data == null || data.length == 0) {
            return new byte[0]; // Return an empty array if input is null or empty
        }

        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            byte[] buffer = new byte[1024];
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
        } catch (DataFormatException e) {
            log.error("Data format exception while decompressing: {}", e.getMessage());
            return null;
        } finally {
            inflater.end();
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error("Error closing output stream: {}", e.getMessage());
            }
        }

        return outputStream.toByteArray();
    }
}

