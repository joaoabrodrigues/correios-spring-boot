package com.joaoabrodrigues.correios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@EnableAutoConfiguration
@PropertySource("classpath:/application.properties")
@SpringBootApplication(scanBasePackages = { "com.joaoabrodrigues.correios.controller", "com.joaoabrodrigues.correios.service"})
public class CorreiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorreiosApplication.class, args);
	}
}
