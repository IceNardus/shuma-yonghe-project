package com.shuma.inter;

import com.shuma.bean.ApiMessage;
import com.shuma.hystrix.LoginServiceHystric;
import com.shuma.bean.MemberInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/10/2019
 * Time: 02:42 PM
 */
@FeignClient(name = "yonghe-min-frist",fallback = LoginServiceHystric.class)
public interface LoginInterface {

    @RequestMapping(value="/min/login/info", method= RequestMethod.POST)
    ApiMessage getUserInfo(@RequestBody MemberInfo info)  throws Exception;
}
