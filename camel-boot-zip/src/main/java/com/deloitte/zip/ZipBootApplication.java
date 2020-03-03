package com.deloitte.zip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ZipBootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ZipBootApplication.class, args);
	}
}
