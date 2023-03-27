package com.thayren.pff7character;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Pff7CharacterApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pff7CharacterApplication.class, args);
	}

}
