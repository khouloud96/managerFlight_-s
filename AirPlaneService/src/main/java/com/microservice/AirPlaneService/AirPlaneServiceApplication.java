package com.microservice.AirPlaneService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AirPlaneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirPlaneServiceApplication.class, args);
	}

}
