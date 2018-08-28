package com.spring.cloud.es.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//import com.ylifegroup.protobuf.Phonebook.PhoneType;

@RestController
public class HelloController {
	
	@Autowired
	private DiscoveryClient client;
	
//	@Autowired
//    private GrpcClientService grpcClientService;

	@RequestMapping("/hello")
	public String hello(){
//	      List<ServiceInstance> instances = client.getInstances("hello-service");
//	        for (int i = 0; i < instances.size(); i++) {
//	            System.out.println("/hello,host:" + instances.get(i).getHost() +",port:"+ instances.get(i).getPort()+ ",service_id:" + instances.get(i).getServiceId());
//	        }
		ServiceInstance instance=client.getLocalServiceInstance();
		System.out.println(instance.getPort());
		System.out.println(instance.getServiceId()+"=="+instance.getUri().toString());
		return "hello";
	}
//	
//	@RequestMapping("/grpcTest")
//	public String grpcTest(){
//		grpcClientService.addPhoneToUser(1, PhoneType.WORK, "1388888888");
//		return null;
//	}
}
