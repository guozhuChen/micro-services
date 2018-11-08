package com.upin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceMessageApplication.class, args);
	}
}
