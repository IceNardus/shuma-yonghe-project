package com.shuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrix
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class YongheMinFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongheMinFeignApplication.class, args);
	}

}

