package com.ibm.fah.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ibm.fah.rest" })
@EntityScan("com.ibm.fah.mongodb.models")
@EnableMongoRepositories("com.ibm.fah.mongodb.repositories")
public class FirstAidHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAidHelperApplication.class, args);
	}

}
