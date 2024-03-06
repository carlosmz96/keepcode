package com.keepcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.keepcode.repository")
public class KeepCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeepCodeApplication.class, args);
	}

}
