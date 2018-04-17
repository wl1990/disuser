package com.demo.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SsController {
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String info(){
		ServiceInstance instance=client.getLocalServiceInstance();
		String info="host:"+instance.getHost()+" service_id:"+instance.getServiceId()+" port:"+instance.getPort();
		return info;
	}
}
