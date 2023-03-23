package com.example.pff7user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Pff7UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pff7UserApplication.class, args);
	}

}
