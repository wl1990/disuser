package com.test.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ImportResource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ImportResource("classpath:dubbo/spring-provider-dubbo.xml")
@SpringBootApplication
@EnableSwagger2
@EnableEurekaServer
public class AppMain {
	private static Logger log=LoggerFactory.getLogger(AppMain.class);
	public static void main(String[] args) {
		try{
			log.info("-------start disuser------");
		    SpringApplication.run(AppMain.class, args);
		}catch(Exception e){
			log.error("--disuser-"+e);
		}
	}
}
