package com.thayren.pff7configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Pff7ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pff7ConfigServerApplication.class, args);
	}

}
