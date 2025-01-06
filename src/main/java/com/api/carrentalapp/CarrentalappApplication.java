package com.api.carrentalapp;

import com.api.carrentalapp.model.Vehicle;
import com.api.carrentalapp.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class CarrentalappApplication {

    public static void main(String[] args) {
		SpringApplication.run(CarrentalappApplication.class, args);
	}

	@Bean
	CommandLineRunner databasePopulator(VehicleRepository repository) {
		return args -> {
			repository.save(new Vehicle(1L, "Ford", "Mustang", "6R09K", 12000));
			repository.save(new Vehicle(2L, "BMW", "M-Power", "2P532R", 34500));
			repository.save(new Vehicle(3L, "Audi", "RS-6", "9W016W",50000));
		};
	}


}
