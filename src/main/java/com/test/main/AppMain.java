package com.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ImportResource("classpath:spring-mybatis.xml")
@SpringBootApplication(scanBasePackages={ "com.test.controller","com.test.service"})
@EnableSwagger2
public class AppMain {
	@Bean
	public String test(){
		return "1";
	}
	
	@Bean
	public HttpMessageConverters restFileDownloadSupport(){
		ByteArrayHttpMessageConverter arrayHttpMessageConverter=new ByteArrayHttpMessageConverter();
		return new HttpMessageConverters(arrayHttpMessageConverter);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
	
	
}
