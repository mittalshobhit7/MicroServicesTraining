package com.consumers.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerControllerClient {
	
	//private DiscoveryClient discoveryClient;
	//private LoadBalancerClient loadBalancer; //Ribbon
	@Autowired
	private DiscoveryClient discoveryClient;
public void getEmployee() throws RestClientException, IOException {
		
	//List<ServiceInstance> instances = discoveryClient.getInstances("employee-producer");
	
	//ServiceInstance serviceInstance = instances.get(0);
	//ServiceInstance serviceInstance = loadBalancer.choose("employee-producer");
	//String baseUrl = serviceInstance.getUri().toString();
	//baseUrl = baseUrl+"/employee";
	List<ServiceInstance> instances = discoveryClient.getInstances("employee-zuul-service");
	
		ServiceInstance serviceInstance = instances.get(0);
		String baseUrl = serviceInstance.getUri().toString();  //zuuls first url (service)
		
		baseUrl = baseUrl+"/producer/employee";
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> response = null;
		try {
			ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			System.out.println(response.getBody());
		} catch(Exception e) {
			System.out.println(e);
		}
	}  
	private static HttpEntity<?> getHeaders() throws IOException{
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
