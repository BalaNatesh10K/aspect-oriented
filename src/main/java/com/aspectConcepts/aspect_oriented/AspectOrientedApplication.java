package com.aspectConcepts.aspect_oriented;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.aspectConcepts.aspect-oriented")
@PropertySource("classpath:application.properties")
public class AspectOrientedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedApplication.class, args);
	}

}
