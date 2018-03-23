package com.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class AppMain {
	public static void main(String[] args) {
		try{
			System.out.println("----------");
		    SpringApplication.run(AppMain.class, args);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
