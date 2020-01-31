package com.lti.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloService {
	
	@GET
	public String hello(){
		return "Hello from JAX-RS and Jersey";
		
	}
}
