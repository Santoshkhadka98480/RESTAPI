package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BookingRentingSystemApplication {

	@PostConstruct
	public void postConstruct() {
		System.out.println("This is the part which runs before the application start");
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingRentingSystemApplication.class, args);
	}

}
