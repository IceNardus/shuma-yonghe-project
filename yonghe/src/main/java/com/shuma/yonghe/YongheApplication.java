package com.shuma.yonghe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class YongheApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongheApplication.class, args);
	}

}

