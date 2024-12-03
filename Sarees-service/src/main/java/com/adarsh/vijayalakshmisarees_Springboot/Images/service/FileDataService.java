package com.adarsh.vijayalakshmisarees_Springboot.Images.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileDataService {

	String uploadFileToFileDirectory(MultipartFile file) throws IOException;

	byte[] downloadFileFromFileDirectory(String fileName) throws IOException;

    File getFileFromDirectory(String filename);


}
