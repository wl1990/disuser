package com.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.test.model.User;
import com.test.service.UserService;
import com.test.utils.NebulaException;

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
	
	/**
	 * 
	 * @param username
	 * @return
	 * @throws NebulaException
	 */
	@RequestMapping(value="/user/{username}",method=RequestMethod.GET)
	public JSONObject getUser(@PathVariable("username") String username) throws NebulaException{
		 JSONObject j=new JSONObject();
    	 j.put("username", username);
    	 return j;
	}
	/**
	 * @controllerAdvice+@ExceptionHandler 实现exception的统一处理
	 * 缺点 只能处理controller未处理的异常，对interceptor层的异常，spring框架层的异常，tomcat容器servlet 的异常无法处理
	 * @throws NebulaException
	 */
	@RequestMapping(value="/testException",method=RequestMethod.GET)
	public void testException() throws NebulaException{
    	throw new NebulaException(500,"exception test");
	}
	
	@RequestMapping(value="/testExceptionNoFilter",method=RequestMethod.GET)
	public void testExceptionNoFilter() throws NebulaException{
    	throw new NebulaException(500,"exception test");
	}
}
