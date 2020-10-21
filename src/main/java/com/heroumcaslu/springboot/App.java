package com.heroumcaslu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
/*@EnableAutoConfiguration
@ComponentScan//(basePackages = "com.heroumcaslu.springboot.endpoint")
@Configuration*/
//Substitui as tres anotações
@SpringBootApplication
public class App {
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}
}
