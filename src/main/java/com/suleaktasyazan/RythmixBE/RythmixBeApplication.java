package com.suleaktasyazan.RythmixBE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.suleaktasyazan"})
@ComponentScan(basePackages = {"com.suleaktasyazan"})
@EnableJpaRepositories(basePackages = {"com.suleaktasyazan"})
public class RythmixBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RythmixBeApplication.class, args);
	}

}
