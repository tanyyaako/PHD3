package com.example.demo;

import com.example.demo.config.JacksonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JacksonConfig.class)
public class PhdLab3Application {

	public static void main(String[] args) {
		SpringApplication.run(PhdLab3Application.class, args);
	}

}
