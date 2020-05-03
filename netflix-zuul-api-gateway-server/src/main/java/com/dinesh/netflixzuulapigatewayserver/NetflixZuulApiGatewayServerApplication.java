package com.dinesh.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import brave.sampler.Sampler;

@EnableZuulProxy

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.dinesh.netflixzuulapigatewayserver")
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	@Bean
	  public Sampler defaultSampler(){
	    return Sampler.ALWAYS_SAMPLE;
	  }

}
