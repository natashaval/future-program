package com.future.usertodo.futureusertodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FutureUsertodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutureUsertodoApplication.class, args);
	}
}
