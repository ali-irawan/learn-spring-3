package com.devtalks.learnspring.session3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations= {"classpath:spring/spring-context.xml"})
public class Session3Application {

	public static void main(String[] args) {
		SpringApplication.run(Session3Application.class, args);
	}

}
