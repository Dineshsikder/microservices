package com.dinesh.microservice.basicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableHystrix
@ComponentScan(basePackages = {"com.dinesh.microservice"})
public class BasicServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicServiceApplication.class, args);
	}

}
