package com.example.WebsocketService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WebsocketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketServiceApplication.class, args);
	}

}
