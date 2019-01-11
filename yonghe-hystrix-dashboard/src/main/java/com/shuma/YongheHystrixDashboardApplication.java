package com.shuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class YongheHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(YongheHystrixDashboardApplication.class, args);
	}

}

