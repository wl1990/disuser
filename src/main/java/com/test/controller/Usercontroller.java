package com.test.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class Usercontroller {
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public JSONObject addUser(){
		 JSONObject j=new JSONObject();
    	 j.put("test","test");
    	 j.put("result", "success");
    	 return j;
	}
}
