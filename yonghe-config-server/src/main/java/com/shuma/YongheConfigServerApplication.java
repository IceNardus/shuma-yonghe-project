package com.shuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class YongheConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongheConfigServerApplication.class, args);
	}

}

