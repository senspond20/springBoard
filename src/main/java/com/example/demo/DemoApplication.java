package com.example.demo;

import com.example.demo.common.configuration.InitRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(){
		return new InitRunner();
	}
	// @Bean 
	// public PageableHandlerMethodArgumentResolverCustomizer customize() { 
	// 	return p -> { 
	// 		p.setOneIndexedParameters(true); 
	// 		// 1부터 시작 
	// 		p.setMaxPageSize(10); 
	// 		// size=10 
	// 	}; 
	// }



}
