package com.hoperun.shuma.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hoperun.shuma.api.request.WxMpCouponRequest;
import com.hoperun.shuma.api.response.WxCardInfo;
import com.hoperun.shuma.common.base.ApiMessage;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.common.utils.CodeUtils;
import com.hoperun.shuma.common.utils.HttpUtil;
import com.hoperun.shuma.common.utils.SignUtils;
import com.hoperun.shuma.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/20/2018
 * Time: 09:11 AM
 */
@Slf4j
@RestController
@RequestMapping(value = "/min/coupon")
public class CouponController {


}
