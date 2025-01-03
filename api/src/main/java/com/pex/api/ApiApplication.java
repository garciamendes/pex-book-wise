package com.pex.api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		//	System.setProperty("CLOUDINARY_URL", dotenv.get("CLOUDINARY_URL"));
		System.setProperty("SECRET_TOKEN", dotenv.get("SECRET_TOKEN"));
		System.setProperty("CORS_ALLOW", dotenv.get("CORS_ALLOW"));

		SpringApplication.run(ApiApplication.class, args);
	}

}
