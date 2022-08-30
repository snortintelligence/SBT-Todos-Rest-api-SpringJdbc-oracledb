package com.snort.intelli.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosRestApiApplication {

	private static Logger log = LoggerFactory.getLogger(TodosRestApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodosRestApiApplication.class, args);
		log.info("Todos-rest-api running fine...");
	}

}
