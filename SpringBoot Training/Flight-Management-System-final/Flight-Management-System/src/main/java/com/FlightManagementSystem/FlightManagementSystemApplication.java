package com.FlightManagementSystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.FlightManagementSystem")
@OpenAPIDefinition(info = @Info(title="Flight Management System API",version = "2.0",description = "Flight Manage"))
public class FlightManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(FlightManagementSystemApplication.class, args);
	}

}