package com.demo.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="infoError")
	public String infoService(){
		return restTemplate.getForObject("http://sc-service-0/info", String.class);
	}
	
	public String infoError(){
		return "hi,sorry,error!";
	}
}
