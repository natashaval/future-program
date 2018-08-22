package com.future.usertodo.futureusertodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//https://docs.spring.io/spring-data/jpa/docs/1.7.0.DATAJPA-580-SNAPSHOT/reference/html/auditing.html
//Spring Data provides sophisticated support to transparently keep track of who created or changed an entity and the point in time this happened.

@SpringBootApplication
@EnableJpaAuditing
public class FutureUsertodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FutureUsertodoApplication.class, args);
	}
}
