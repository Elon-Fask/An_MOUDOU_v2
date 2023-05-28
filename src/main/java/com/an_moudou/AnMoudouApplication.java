package com.an_moudou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })

public class AnMoudouApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnMoudouApplication.class, args);
	}

}
