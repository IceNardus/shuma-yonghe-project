package com.shuma.yonghe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableEurekaServer
@SpringBootApplication
public class YongheApplication   {

	public static void main(String[] args) {

		SpringApplication.run(YongheApplication.class, args);
	}

	@Configuration
	public static class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {


		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//默认配置(所有认证请求都需要授权，要求用户在进入你的应用的任何URL之前都进行验证)
       /* http.authorizeRequests().anyRequest().authenticated().and()
                .formLogin().and()
                .httpBasic();*/

			//所有请求都不需要授权
			http.authorizeRequests().anyRequest().permitAll()//
					.and().csrf().disable();

		}



	}
}

