package com.hoperun.shuma.api.config;

import com.hoperun.shuma.api.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 添加拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    SessionInterceptor localInterceptor() {
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//添加配置拦截器
        registry.addInterceptor(localInterceptor()).addPathPatterns("/**")
                /*.excludePathPatterns("/{business}/login")*/;
        super.addInterceptors(registry);
    }

}
