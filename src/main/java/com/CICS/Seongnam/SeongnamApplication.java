package com.CICS.Seongnam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.CICS"})
@SpringBootApplication
public class SeongnamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeongnamApplication.class, args);
	}

}
