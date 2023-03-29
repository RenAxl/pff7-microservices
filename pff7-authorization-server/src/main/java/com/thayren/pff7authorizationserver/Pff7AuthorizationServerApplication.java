package com.thayren.pff7authorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Pff7AuthorizationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pff7AuthorizationServerApplication.class, args);
	}

}
