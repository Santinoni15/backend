package com.example.atv6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Atv6Application {

	public static void main(String[] args) {
		SpringApplication.run(Atv6Application.class, args);
	}

}
