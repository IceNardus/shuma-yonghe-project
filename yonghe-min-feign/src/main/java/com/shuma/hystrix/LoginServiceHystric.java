package com.shuma.hystrix;

import com.shuma.bean.ApiMessage;
import com.shuma.bean.MemberInfo;
import com.shuma.inter.LoginInterface;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/10/2019
 * Time: 02:44 PM
 */
@Component
public class LoginServiceHystric implements LoginInterface {
    @Override
    public ApiMessage getUserInfo(MemberInfo info) throws Exception {
        return new ApiMessage("请求错误！");
    }
}
