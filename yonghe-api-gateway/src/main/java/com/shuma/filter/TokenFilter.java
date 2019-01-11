package com.shuma.filter;

import com.shuma.redismanager.SessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * TOKEN验证
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/11/2019
 * Time: 10:26 AM
 */
@Slf4j
public class TokenFilter implements GlobalFilter,Ordered {

    @Autowired
    SessionManager manager;

    @Value("${sys..expireTime:1800}")
    private int expireTime;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI uri = exchange.getRequest().getURI();
        if(uri.getPath().indexOf("/login")<0){
            //获取token
            String token = exchange.getRequest().getQueryParams().getFirst("User-Token");
            if (token == null || token.isEmpty()) {
                log.info("User-Token is null, Request Url = {}", exchange.getRequest().getURI());
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }else {
                Object result=manager.getRedisValue(token);
                if(result==null){
                    log.info("User-Token is Expired, Request Url = {}", exchange.getRequest().getURI());
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
