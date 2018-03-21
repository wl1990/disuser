package com.demo.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	@Autowired
	private RestTemplate restTemplate;
	
	public String infoService(){
		return restTemplate.getForObject("http://sc-service-0/info", String.class);
	}
}
