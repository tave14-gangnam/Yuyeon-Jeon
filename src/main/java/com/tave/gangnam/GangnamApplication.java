package com.tave.gangnam;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.tave.gangnam.week2.assignment.domain")
public class GangnamApplication {

	public static void main(String[] args) {
		SpringApplication.run(GangnamApplication.class, args);
	}

}
