package com.demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientConfigController {
	@Value("${fwl}")
	private String fwl;
	
	@RequestMapping("/hi")
	public String hi(){
		return fwl;
	}
	
}
