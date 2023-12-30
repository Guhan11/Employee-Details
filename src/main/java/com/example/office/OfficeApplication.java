package com.example.office;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication

public class OfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}
	
}
