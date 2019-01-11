package com.shuma.member;

import com.shuma.bean.ApiMessage;
import com.shuma.bean.MemberInfo;
import com.shuma.inter.LoginInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/min/login")
public class LoginController {


    @Autowired
    LoginInterface loginInterface;





    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value="/info", method= RequestMethod.POST)
    public ApiMessage getUserInfo(@RequestBody MemberInfo info) throws Exception{
        return loginInterface.getUserInfo(info);
    }






}