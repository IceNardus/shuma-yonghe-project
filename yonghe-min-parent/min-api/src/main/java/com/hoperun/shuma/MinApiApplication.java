package com.hoperun.shuma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@SpringBootApplication
@RefreshScope
public class MinApiApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MinApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MinApiApplication.class, args);
	}
}
