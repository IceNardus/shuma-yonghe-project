package com.hoperun.shuma.open.api;

import com.alibaba.fastjson.JSONObject;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.common.utils.DateUtils;
import com.hoperun.shuma.common.utils.HttpUtil;
import com.hoperun.shuma.common.utils.StringUtil;
import com.hoperun.shuma.open.bean.response.DataObj;
import com.hoperun.shuma.open.util.WeChatUtil;
import com.hoperun.shuma.vo.response.ActivityMsg;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/18/2018
 * Time: 11:18 AM
 */
@Slf4j
@Component
public class WxExternal {

    @Value("${sys.wx.min.template.getCoupon:l6Iibs1ioRB8sD1zI0mIgBVmdfh_yCbelzZ-IYUxnCc}")
    private String WX_MIN_GET_COUPON_MSG;

    @Value("${sys.wx.min.template.groupFinish:JzL500ubr-38HYycOlOF3lcckai0CKDLuVOJF3a3RQw}")
    private String WX_MIN_GROUP_FINISH_MSG;

    @Value("${sys.wx.min.template.shareFinish:JzL500ubr-38HYycOlOF3lcckai0CKDLuVOJF3a3RQw}")
    private String WX_MIN_SHARE_FINISH_MSG;


    @Value("${sys.wx.baseUrl:https://api.weixin.qq.com/}")
    private String WX_BASE_URL;

    @Value("${sys.wx.min.authorization.url:http://open.yoodex.net/auth/getWXInfo/getWxMiniToken}")
    private String WX_AUTHORIZE_URL;

    @Value("${sys.wx.min.authorization.identification:YQXD616E1FT0634}")
    private String WX_AUTHORIZE_IDENTIFICA;


    @Value("${sys.wx.min.appid:wx08d6315080d9c601}")
    private String MIN_APP_ID;
    @Value("${sys.wx.min.secret:f1416ad3dc626a4159ddf399643dae0f}")
    private String MIN_SECRET;

    @Autowired
    private WeChatUtil wechatUtils;


    /**
     * 获取小程序用户信息
     * @param code
     * @return
     */
    public DataObj getMinUserInfo(String code) throws Exception{

        String url=WX_BASE_URL+"sns/jscode2session";
        Map map=new HashMap();
        map.put("appid", MIN_APP_ID);
        map.put("secret", MIN_SECRET);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");

        List<BasicNameValuePair> params = new ArrayList<>();


        String result=HttpUtil.get(url,map);
        DataObj obj =JSONObject.parseObject(result,DataObj.class);
        if(StringUtil.isEmpty(obj.getOpenid())){
            throw new ApiException(ApiResponseStatus.FAIL_WECHAT_USER);
        }
        String key=obj.getSession_key();
        JSONObject object=new JSONObject();

        return obj;
    }



    /**
     * 获取小程序用户信息
     * @param code
     * @return
     */
    public DataObj getMinUserInfo(String code,String iv,StringBuffer encrypted) throws Exception{

        String url=WX_BASE_URL+"sns/jscode2session";
        Map map=new HashMap();
        map.put("appid", MIN_APP_ID);
        map.put("secret", MIN_SECRET);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");

        List<BasicNameValuePair> params = new ArrayList<>();


        String result=HttpUtil.get(url,map);
        DataObj obj =JSONObject.parseObject(result,DataObj.class);
        String key=obj.getSession_key();
        JSONObject object=new JSONObject();
        if(StringUtil.isNotEmpty(obj.getSession_key())&&StringUtil.isEmpty(obj.getUnionid())){
            object=JSONObject.parseObject(wechatUtils.wxDecrypt(encrypted.toString(),key,iv));
        }

        log.info("用户信息为:"+object);


        return obj;
    }


    /**
     * 发送领取卡劵模板
     * @param openId
     * @param formId
     * @param couponName
     * @param activityName
     */
    @Async
    public void getCouponMsg(String openId,String formId,String couponName,String activityName){
        String token=getAToken(WX_AUTHORIZE_IDENTIFICA);
        String wxUrl=WX_BASE_URL+"cgi-bin/message/wxopen/template/send?access_token="+token;
        JSONObject map=new JSONObject();
        map.put("touser",openId);
        map.put("template_id",WX_MIN_GET_COUPON_MSG);
        map.put("page","");
        map.put("form_id",formId);

        JSONObject data=new JSONObject();
        JSONObject word1=new JSONObject();
        word1.put("value",activityName);
        word1.put("color","#173177");
        data.put("keyword1",word1);
        JSONObject word2=new JSONObject();
        word2.put("value",couponName);
        word2.put("color","#173177");
        data.put("keyword2",word2);

        JSONObject word3=new JSONObject();

        word3.put("value", DateUtils.getTimeFormat(new Date()));
        word3.put("color","#173177");
        data.put("keyword3",word3);
        JSONObject word4=new JSONObject();
        word4.put("value","微信小程序");
        word4.put("color","#173177");
        data.put("keyword4",word4);

        JSONObject word5=new JSONObject();
        word5.put("value","领取成功，可在微信卡包中查看");
        word5.put("color","#173177");
        data.put("keyword5",word5);



        map.put("data", data);
        Map heads=new HashMap();
        String result="";
        try {
            result= HttpUtil.doPost(wxUrl,map,2000,2000,heads);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 发送拼团模板信息
     * @param msg
     * @param activityNum
     */
    @Async
    public void finishGroupActive(ActivityMsg msg, String activityNum){
        String token=getAToken(WX_AUTHORIZE_IDENTIFICA);
        String wxUrl=WX_BASE_URL+"cgi-bin/message/wxopen/template/send?access_token="+token;
        JSONObject map=new JSONObject();
        map.put("touser",msg.getOpenId());
        map.put("template_id",WX_MIN_GROUP_FINISH_MSG);
        map.put("page","pages/activity/activity?groupNum="+activityNum);
        map.put("form_id",msg.getFromId());

        JSONObject data=new JSONObject();
        JSONObject word1=new JSONObject();
        word1.put("value",msg.getActivityName());
        word1.put("color","#173177");
        data.put("keyword1",word1);
        JSONObject word2=new JSONObject();
        word2.put("value",msg.getCreateTime());
        word2.put("color","#173177");
        data.put("keyword2",word2);

        JSONObject word3=new JSONObject();
        word3.put("value",msg.getCouponName());
        word3.put("color","#173177");
        data.put("keyword3",word3);
        JSONObject word4=new JSONObject();
        word4.put("value","点击获取更多内容");
        word4.put("color","#173177");
        data.put("keyword4",word4);
        map.put("data", data);
        map.put("emphasis_keyword","keyword1.DATA");
        String result="";
        Map heads=new HashMap();
        try {
            result= HttpUtil.doPost(wxUrl,map,2000,2000,heads);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 发送分享模板信息
     * @param msg
     * @param activityNum
     */
    @Async
    public void finishShareActive(ActivityMsg msg, String activityNum){
        String token=getAToken(WX_AUTHORIZE_IDENTIFICA);
        String wxUrl=WX_BASE_URL+"cgi-bin/message/wxopen/template/send?access_token="+token;
        JSONObject map=new JSONObject();
        map.put("touser",msg.getOpenId());
        map.put("template_id",WX_MIN_SHARE_FINISH_MSG);
        map.put("page","pages/activity/activity?groupNum="+activityNum);
        map.put("form_id",msg.getFromId());

        JSONObject data=new JSONObject();
        JSONObject word1=new JSONObject();
        word1.put("value",msg.getActivityName());
        word1.put("color","#173177");
        data.put("keyword1",word1);
        JSONObject word2=new JSONObject();
        word2.put("value",msg.getCreateTime());
        word2.put("color","#173177");
        data.put("keyword2",word2);

        JSONObject word3=new JSONObject();
        word3.put("value",msg.getCouponName());
        word3.put("color","#173177");
        data.put("keyword3",word3);
        JSONObject word4=new JSONObject();
        word4.put("value","点击获取更多内容");
        word4.put("color","#173177");
        data.put("keyword4",word4);
        map.put("data", data);
        map.put("emphasis_keyword","keyword1.DATA");
        String result="";
        Map heads=new HashMap();
        try {
            result= HttpUtil.doPost(wxUrl,map,2000,2000,heads);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }





    /**
     * 获取access_token
     * @param Identification
     * @return
     */
    private String getAToken(String Identification){
        String token="";
        String url=WX_AUTHORIZE_URL+"?identifyKey="+WX_AUTHORIZE_IDENTIFICA;
        try{
            token= HttpUtil.post(url);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        JSONObject object= JSONObject.parseObject(token);
        if(0==object.getInteger("status")){
            token=object.getJSONObject("data").getString("access_token");
        }
        return token;
    }


}
