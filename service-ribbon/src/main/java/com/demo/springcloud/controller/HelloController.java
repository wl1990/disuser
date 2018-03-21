package com.demo.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springcloud.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	@RequestMapping(value="/hi")
	public String hi(){
		return helloService.infoService();
	}
}
