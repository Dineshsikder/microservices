package com.dinesh.exchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.dinesh.exchangeservice")
@EnableDiscoveryClient
public class ExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeServiceApplication.class, args);
	}
	
	@Bean
	  public Sampler defaultSampler(){
	    return Sampler.ALWAYS_SAMPLE;
	  }

}
