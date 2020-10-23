package com.salemnabeel.wikicoursesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@EnableJpaAuditing
@SpringBootApplication
public class WikiCoursesAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(WikiCoursesAppApplication.class, args);
	}

	@GetMapping("/test-api")
	public boolean testApi() {

		return true;
	}

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile[] files) {

		String fileDirectory = "C:\\Users\\SalemNabeel\\Pictures\\resources\\images\\products\\";

		try {
			uploadFiles(fileDirectory, files);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("files uploaded successfully", HttpStatus.OK);
	}

	public void uploadFiles(String fileDirectory, MultipartFile[] files) throws IOException {

		String path = fileDirectory;

		StringBuilder fileNames = new StringBuilder();

		for (MultipartFile file : files) {

			Path fileNameAndPath = Paths.get(path, file.getOriginalFilename());

			fileNames.append(file.getOriginalFilename());

			Files.write(fileNameAndPath, file.getBytes());

			// For Testing Only
			 System.out.println("File Name Is : " + file.getOriginalFilename());
		}
	}
}