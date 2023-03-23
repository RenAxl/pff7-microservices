package com.thayren.pff7eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Pff7EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pff7EurekaServerApplication.class, args);
	}

}
