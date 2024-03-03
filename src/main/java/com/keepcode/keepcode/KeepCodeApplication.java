package com.keepcode.keepcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.keepcode", "com.keepcode.config.swaggers"})
public class KeepCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeepCodeApplication.class, args);
	}

}
