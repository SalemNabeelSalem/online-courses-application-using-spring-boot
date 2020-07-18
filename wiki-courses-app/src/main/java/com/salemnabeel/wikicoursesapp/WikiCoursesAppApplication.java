package com.salemnabeel.wikicoursesapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableJpaAuditing
public class WikiCoursesAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(WikiCoursesAppApplication.class, args);
	}

	@GetMapping("/test-api")
	public boolean testApi() {
		return true;
	}
}