package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WeddingAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeddingAdminApplication.class, args);
	}

}