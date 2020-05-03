/**
 * 
 */
package com.dinesh.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.microservice.bean.BasicConfiguration;
import com.dinesh.microservice.bean.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author developer
 *
 */
@RestController
public class BasicConfigurationController {
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/basic")
	public BasicConfiguration retrieveBasicConfiguration() {
		return new BasicConfiguration(999, 9);
	}
	
	@GetMapping("/basic-properties")
	public Configuration retrieveBasicConfigurationFromProperties() {
		return new Configuration(configuration.getMaximum(), configuration.getMinimum());
	}
	
	@GetMapping("/fault-tplerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public Configuration retrieveConfiguration() {
		throw new RuntimeException("Not Available");
	}
	
	public BasicConfiguration fallbackRetrieveConfiguration() {
		return new BasicConfiguration(999, 9);
	}
}
