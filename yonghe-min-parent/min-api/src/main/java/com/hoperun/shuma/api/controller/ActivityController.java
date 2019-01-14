package com.hoperun.shuma.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.hoperun.shuma.api.request.ActiveDateRequest;
import com.hoperun.shuma.api.request.ActivityRequest;
import com.hoperun.shuma.api.response.ActivityJoinResponse;
import com.hoperun.shuma.common.base.ApiMessage;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.common.utils.ConstantUtils;
import com.hoperun.shuma.common.utils.StringUtil;
import com.hoperun.shuma.open.api.WxExternal;
import com.hoperun.shuma.service.IMinGroupActivityService;
import com.hoperun.shuma.vo.ThreadMember;
import com.hoperun.shuma.vo.response.ActivityMsg;
import com.hoperun.shuma.vo.response.GroupResultVo;
import com.hoperun.shuma.vo.response.ShareResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/20/2018
 * Time: 09:12 AM
 */
@Slf4j
@RestController
@RequestMapping(value = "/min/activity")
public class ActivityController {

    @Autowired
    private IMinGroupActivityService service;

    @Autowired
    WxExternal wx;


    /**
     * 获取活动详情
     * @return
     */
    @PostMapping(value = "/info")
    @ResponseBody
    public ApiMessage getInfo(@RequestBody ActivityRequest request){
        if(request.getActivityTypes().size()==0){
            throw new ApiException(ApiResponseStatus.NO_PARAMETER);
        }

        String nums="";
        if(!"1".equals(request.getActivityNum())){
            nums=request.getActivityNum();
        }

        return new ApiMessage();


    }


    /**
     * 参与活动
     * @param request
     * @return
     */
    @PostMapping(value = "/join")
    @ResponseBody
    public ApiMessage addRecord(@RequestBody ActiveDateRequest request){
        if(StringUtil.isEmpty(request.getActivityType())){
            throw new ApiException(ApiResponseStatus.NO_PARAMETER);
        }

        return new ApiMessage();
    }

    /**
     * 领取活动奖品
     * @param request
     * @return
     */
    @PostMapping(value = "/receive")
    @ResponseBody
    public ApiMessage receiveActivityPrize(@RequestBody ActiveDateRequest request){
        if(StringUtil.isEmpty(request.getActivityType())){
            throw new ApiException(ApiResponseStatus.NO_PARAMETER);
        }


        return new ApiMessage();
    }

    /**
     * 获取当前活动
     * @return
     */
    @PostMapping(value = "/page")
    @ResponseBody
    public ApiMessage getPage(){
        return new ApiMessage();
    }


}
