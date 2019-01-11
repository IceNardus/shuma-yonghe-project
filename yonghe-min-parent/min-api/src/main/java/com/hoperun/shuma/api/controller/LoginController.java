package com.hoperun.shuma.api.controller;

import com.hoperun.shuma.api.request.MemberInfo;
import com.hoperun.shuma.api.session.SessionManager;
import com.hoperun.shuma.common.base.ApiMessage;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.open.api.CrmExternal;
import com.hoperun.shuma.open.api.WxExternal;
import com.hoperun.shuma.open.bean.response.DataObj;
import com.hoperun.shuma.service.IMinOrderService;
import com.hoperun.shuma.vo.par.MinMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
@RequestMapping(value = "/min/login")
public class LoginController  {

    @Autowired
    HttpServletResponse response;

    @Autowired
    IMinOrderService service;

    @Autowired
    SessionManager sessionManager;

    @Autowired
    WxExternal wx;

    @Autowired
    CrmExternal crm;





    /**
     * 获取用户信息
     * @return
     */
    @RequestMapping(value="/info", method= RequestMethod.POST)
    public ApiMessage getUserInfo(@RequestBody MemberInfo info)  throws Exception{

        DataObj obj=wx.getMinUserInfo(info.getCode());

        String openId=obj.getOpenid();

        MinMember minMember= crm.getUserInfo(openId);

        sessionManager.resultResponse(minMember,response);

        return new ApiMessage();
    }






}