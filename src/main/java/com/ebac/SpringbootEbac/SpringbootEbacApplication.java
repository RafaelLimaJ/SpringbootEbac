package com.ebac.SpringbootEbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ebac"})
@EntityScan(basePackages = {"com.ebac.entities"})
@EnableJpaRepositories(basePackages = {"com.ebac.repositories"})
public class SpringbootEbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEbacApplication.class, args);
	}

}
