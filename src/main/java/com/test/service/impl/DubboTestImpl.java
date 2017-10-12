package com.test.service.impl;

import org.springframework.stereotype.Service;

import com.test.service.DubboTest;

@Service("dubboTest")
public class DubboTestImpl implements DubboTest{

	@Override
	public String dubbotest() {
		return "---dubbo test-----";
	}
	
}
