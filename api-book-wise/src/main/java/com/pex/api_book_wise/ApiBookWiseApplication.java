package com.pex.api_book_wise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class ApiBookWiseApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		System.setProperty("CLOUDINARY_URL", dotenv.get("CLOUDINARY_URL"));
		System.setProperty("SECRET_TOKEN", dotenv.get("SECRET_TOKEN"));
		System.setProperty("CORS_ALLOW", dotenv.get("CORS_ALLOW"));

		SpringApplication.run(ApiBookWiseApplication.class, args);
	}

}
