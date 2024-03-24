package com.Athang.Athang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Athang.Athang")
public class AthangApplication {

	public static void main(String[] args) {
		SpringApplication.run(AthangApplication.class, args);
	}

}
