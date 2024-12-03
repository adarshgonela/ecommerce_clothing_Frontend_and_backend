package com.adarsh.vijayalakshmisarees_Springboot.Images.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adarsh.vijayalakshmisarees_Springboot.Images.service.FileDataService;


@RestController
@RequestMapping("/api")
public class FileDataRestController {
	

	
	@Autowired
	private FileDataService fileDataService;
	
	@PostMapping("/file-upload-to-directory")
	public ResponseEntity<?> uploadImageToFileDirectory(@RequestParam("file") MultipartFile file) throws IOException{
		String uploadFile = fileDataService.uploadFileToFileDirectory(file);
		
		return ResponseEntity.status(HttpStatus.OK).body(uploadFile);
		
		 
	}
	
	@GetMapping("/file-download-from-directory/{fileName}")
	public ResponseEntity<?> downloadImageFromFileDirectory(@PathVariable String fileName) throws IOException{
		byte[] downloadFile = fileDataService.downloadFileFromFileDirectory(fileName);
				
		
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(downloadFile);
	}



	  @GetMapping("/get-image/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename) throws IOException {
        // Get the file from the directory
        File file = fileDataService.getFileFromDirectory(filename);

        // Determine the MIME type of the file (image/jpeg, image/png, etc.)
        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null) {
            mimeType = "application/octet-stream"; // Fallback if MIME type is not found
        }

        // If MIME type is not recognized, return an error response
        if (!mimeType.startsWith("image")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Or return an error message indicating invalid image
        }

        // Create a Resource from the file (to return it as part of the response)
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        // Return the file with the appropriate content type based on the MIME type
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType)) // Use the dynamically detected mime type
                .body(resource);
    }



}
