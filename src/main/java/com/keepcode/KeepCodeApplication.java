package com.keepcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan({"com.keepcode"})
@EnableMongoRepositories(basePackages = "com.keepcode.repository")
public class KeepCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeepCodeApplication.class, args);
	}

}
