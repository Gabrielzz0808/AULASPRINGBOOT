package com.facinpro.aulaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.facinpro.aulaspringboot.modelo")
@SpringBootApplication
public class AulaspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaspringbootApplication.class, args);
	}

	@Override
	public String toString() {
		return "AulaspringbootApplication []";
	}

}
