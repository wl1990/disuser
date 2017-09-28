package com.test.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(scanBasePackages={ "com.test.controller"})
@EnableSwagger2
public class AppMain {
	
	
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
	
	
}
