package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserMapper;
import com.test.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	public int insertUser(User user){
		return userMapper.insert(user);
	}
}
