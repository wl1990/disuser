package com.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.test.model.User;
import com.test.service.UserService;

@RestController
public class Usercontroller {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public JSONObject addUser(@RequestParam String username){
		 User user=new User();
		 user.setBirthday(new Date());
		 user.setName(username);
		 int f=userService.insertUser(user);
		 JSONObject j=new JSONObject();
    	 j.put("username", username);
    	 j.put("result", f);
    	 return j;
	}
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public JSONObject addUser(@RequestBody User user){
		 int f=userService.insertUser(user);
		 JSONObject j=new JSONObject();
    	 j.put("username", user.getName());
    	 j.put("result", f);
    	 return j;
	}
	
	
	@RequestMapping(value="/user/{username}",method=RequestMethod.GET)
	public JSONObject getUser(@PathVariable("username") String username){
		 JSONObject j=new JSONObject();
    	 j.put("username", username);
    	 return j;
	}
	
}
