package com.demo.springcloud.service_zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.demo.springcloud.filter.MyFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {
	private static Logger log = LoggerFactory.getLogger(ServiceZuulApplication.class);
	public static void main(String[] args) {
		log.info("-----------start-------");
		SpringApplication.run(ServiceZuulApplication.class,args);
	}
	
	@Bean
	public MyFilter myFilter(){
		return new MyFilter();
	}
	
}
