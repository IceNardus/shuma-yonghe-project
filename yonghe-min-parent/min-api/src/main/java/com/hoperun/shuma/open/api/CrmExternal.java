package com.hoperun.shuma.open.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hoperun.shuma.common.base.ApiMessage;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.common.utils.ConstantUtils;
import com.hoperun.shuma.common.utils.HttpUtil;
import com.hoperun.shuma.common.utils.SignUtils;
import com.hoperun.shuma.common.utils.StringUtil;
import com.hoperun.shuma.open.bean.response.ArrayResult;
import com.hoperun.shuma.open.bean.response.LoginResult;
import com.hoperun.shuma.open.bean.vo.CouponDetail;
import com.hoperun.shuma.open.bean.vo.CouponInfo;
import com.hoperun.shuma.open.bean.vo.CouponVo;
import com.hoperun.shuma.vo.par.MinMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * CRM外接接口
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 8/14/2018
 * Time: 11:16 AM
 */
@Slf4j
@Component
public class CrmExternal {

    /**
     * crm地址
     */
    @Value("${sys.crm.baseUrl:http://10.20.12.237:8080/}")
    private String BASE_URI;
    /**
     * 终端流水号
     */
    @Value("${sys.crm.clientOrderNo:123456789abcd}")
    private String CLIENTORDERNO;
    /**
     *
     */
    @Value("${sys.crm.deviceNo:123456789abcd}")
    private String DEVICENO;
    /**
     *
     */
    @Value("${sys.crm.storeNo:123456789abcd}")
    private String STORENO;
    /**
     *
     */
    @Value("${sys.crm.source:07}")
    private String SOURCE;
    /**
     *
     */
    @Value("${sys.crm.version:v1.0}")
    private String VERSION;
    /**
     *
     */
    @Value("${sys.crm.loginTransCode:A002}")
    private String LOGIN_TRANS_CODE;

    @Value("${sys.crm.regTransCode:A001}")
    private String REG_TRANS_CODE;

    @Value("${sys.crm.couponTransCode:B001}")
    private String COUPON_TRANS_CODE;

    @Value("${sys.crm.receiveCouponTransCode:B002}")
    private String RECEIVE_TRANS_CODE;

    @Value("${sys.crm.userTransCode:A101}")
    private String USER_TRANS_CODE;

    @Value("${sys.crm.rechargeTransCode:A101}")
    private String RECHARGE_TRANS_CODE;

    @Value("${sys.crm.activeTransCode:A101}")
    private String ACTIVE_TRANS_CODE;

    /**
     *CRM 标识
     */
    @Value("${sys.crm.crmBrand:crmBOSS}")
    private String CRMBRAND;


    /**
     *
     */
    @Value("${sys.crm.secret:OPHAReZTvK8h}")
    private String SECRET;

    @Value("${sys.crm.userType:02}")
    private String USER_TYPE;

    @Value("${sys.crm.payType:02}")
    private String PAY_TYPE;
    /**
     * 请求超时时间
     */
    @Value("${sys.crm.rTimeOut:5000}")
    private String stime;

    /**
     * 等待超时时间
     */
    @Value("${sys.crm.sTimeOut:5000}")
    private String ctime;

    @Value("${sys.crm.active:N20181130}")
    private String ACTIVEID;




    /**
     * 获取用户信息
     * @param minOpenId
     * @return
     */
    public MinMember getUserInfo(String minOpenId){
        String url=BASE_URI+"crm/open/api/member/info";
        Map map=new HashMap();
        map.put("wxMiniOpenid",minOpenId);
        map.put("transCode",LOGIN_TRANS_CODE);
        map=getSignAndParms(map);
        LoginResult loginResult=new LoginResult();
        MinMember minMember=new MinMember();
        try {
            String  result= HttpUtil.post(url,map);
            loginResult=JSON.parseObject(result,LoginResult.class);
            if (!loginResult.getSuccess()) {
                throw new ApiException(ApiResponseStatus.MEMBER_ALREADY_EXISTED);
            }
            JSONObject jsonObject=loginResult.getData();
            minMember.setCrmNo(jsonObject.getString("memberNo"));
            minMember.setUnionId(jsonObject.getString("wxUnionid"));
            minMember.setWxMinOpenId(jsonObject.getString("wxMiniOpenid"));

        } catch (UnsupportedEncodingException e) {
           log.error(e.getMessage(),e);
        }
        return minMember;
    }

    /**
     * 获取活动详情
     * @param activeUrl
     * @return
     */
    public ApiMessage getCrmActive(String activeUrl){
        String url=BASE_URI+"crm/"+""+"/min/"+activeUrl;
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("transCode",USER_TRANS_CODE);
        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();
        try {
            String  result=HttpUtil.post(url,map);
            LoginResult loginResult=JSON.parseObject(result,LoginResult.class);
            message = checkStatus(loginResult, message);
            if (!message.isSucceed()) {
                return message;
            }
            return  new ApiMessage(loginResult.getData());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(),e);
        }
        return new ApiMessage();
    }

    /**
     * 参加活动
     * @param activeUrl
     * @return
     */
    public ApiMessage joinCrmActive(String activeUrl,Map parm){
        String url=BASE_URI+"crm/"+"/min/"+activeUrl;
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("transCode",USER_TRANS_CODE);
        Iterator entries = parm.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            map.put(key,value);
        }
        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();
        try {
            String  result=HttpUtil.post(url,map);
            LoginResult loginResult=JSON.parseObject(result,LoginResult.class);
            message = checkStatus(loginResult, message);
            if (!message.isSucceed()) {
                return message;
            }
            return  new ApiMessage(loginResult.getData());
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(),e);
        }
        return new ApiMessage();
    }


    /**
     * 注册会员
     * @param minOpenId
     * @return
     */
    public ApiMessage minRegistered(String minOpenId,String mobile,String uniodId){
        String url=BASE_URI+"crm/open/api/member/register";
        Map map=new HashMap();
        map.put("wxMiniOpenid",minOpenId);
        map.put("mobile",mobile);
        if(StringUtil.isNotEmpty(uniodId)){
            map.put("wxUnionid",uniodId);
        }
        map.put("userType",USER_TYPE);
        map.put("transCode",LOGIN_TRANS_CODE);

        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();
        try {
            String  result=HttpUtil.post(url,map);
            LoginResult loginResult=JSON.parseObject(result,LoginResult.class);


            message = checkStatus(loginResult, message);
            if (!message.isSucceed()) {
                return message;
            }
            JSONObject jsonObject=loginResult.getData();
            if(jsonObject!=null&&!jsonObject.isEmpty()&&jsonObject.containsKey("memberNo")){
                message.setData(jsonObject.getString("memberNo"));
                return message;
            }

        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(),e);
        }
        return new ApiMessage();
    }

    /**
     * 获取用户基本信息
     * @return
     */
    public ApiMessage getUserInfo(){
        String url=BASE_URI+"crm/open/api/member/memberAsset";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("transCode",USER_TRANS_CODE);
        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();
        try {
            String result = HttpUtil.post(url, map);
            LoginResult  loginResult=JSON.parseObject(result,LoginResult.class);
            message = checkStatus(loginResult, message);
            if (!message.isSucceed()) {
                return message;
            }

            message.setData(loginResult.getData());
            return message;

        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return new ApiMessage();
    }

    /**
     * 充值
     * @param amount
     * @param actAmount
     * @return
     */
    public ApiMessage addRecharge(int amount,int actAmount){
        String url=BASE_URI+"crm/open/api/member/recharge";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("totalAmount",amount);
        map.put("payType",PAY_TYPE);
        map.put("payAmount",actAmount);
        map.put("transCode",RECHARGE_TRANS_CODE);
        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();

        try {
            String result = HttpUtil.post(url, map);
            LoginResult loginResult = JSON.parseObject(result, LoginResult.class);
            //判断获取数据是否失败
            message = checkStatus(loginResult, message);
            if (!message.isSucceed()) {
                return message;
            }

        }catch (Exception e){
            log.error(e.getMessage(),e);

        }
        return message;
    }


    /**
     * 获取用户卡劵列表
     * @return
     */
    public ApiMessage getUseUserCoupon(int pages,int rows,int availableChannel){
        String url=BASE_URI+"crm/open/api/coupon/memberCardList";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("codeStatus","02");
        int withCardInfo=3;

        map.put("withCardInfo",withCardInfo);
        map.put("availableChannel","0"+availableChannel);
        map.put("pages",pages);
        map.put("rows",rows);
        map.put("transCode",COUPON_TRANS_CODE);

        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();
        try {
            String  result=HttpUtil.post(url,map);
            LoginResult  loginResult=JSON.parseObject(result,LoginResult.class);
            //判断获取数据是否失败
            message =checkStatus(loginResult,message);
            if(!message.isSucceed()){
                return message;
            }

            List<CouponInfo> infos=new ArrayList<>();
            //卡劵数据
            JSONArray array=loginResult.getData().getJSONArray("list");
            for (int i=0;i<array.size();i++){
                JSONObject coupon=array.getJSONObject(i);
                CouponInfo info=new CouponInfo();
                info.setCode(coupon.getString("couponCode"));

                JSONObject couponInfo=coupon.getJSONObject("couponInfo");
                info.setOriginalPrice(couponInfo.getString("originalPrice"));
                info.setCouponPrice(couponInfo.getString("couponValue"));
                info.setCouponType(couponInfo.getString("couponType"));
                info.setCouponTitle(couponInfo.getString("couponTitle"));
                info.setImg(couponInfo.getString("img"));
                info.setSubTitle(couponInfo.getString("subTitle"));

                JSONObject times=dealTime(couponInfo);

                info.setStartTime(times.getDate("start"));
                info.setEndTime(times.getDate("end"));
                infos.add(info);
            }
            CouponVo vo=new CouponVo();
            vo.setCount(loginResult.getData().getInteger("count"));
            vo.setInfo(infos);
            message.setData(vo);
            return message;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return new ApiMessage();
    }


    /**
     * 获取用户卡劵历史记录
     * @return
     */
    public ApiMessage getNOUserCoupon(int pages,int rows,int availableChannel,int status){
        String url=BASE_URI+"crm/open/api/coupon/memberCardList";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("statusList","0"+status);
        int withCardInfo=3;

        map.put("withCardInfo",withCardInfo);
        map.put("availableChannel","0"+availableChannel);
        map.put("pages",pages);
        map.put("rows",rows);
        map.put("transCode",COUPON_TRANS_CODE);

        map=getSignAndParms(map);
        ApiMessage message=new ApiMessage();
        try {
            String  result=HttpUtil.post(url,map);
            LoginResult  loginResult=JSON.parseObject(result,LoginResult.class);
            //判断获取数据是否失败
            message =checkStatus(loginResult,message);
            if(!message.isSucceed()){
                return message;
            }

            List<CouponInfo> infos=new ArrayList<>();
            //卡劵数据
            JSONArray array=loginResult.getData().getJSONArray("list");
            for (int i=0;i<array.size();i++){
                JSONObject coupon=array.getJSONObject(i);
                CouponInfo info=new CouponInfo();
                info.setCode(coupon.getString("couponCode"));

                JSONObject couponInfo=coupon.getJSONObject("couponInfo");
                info.setOriginalPrice(couponInfo.getString("originalPrice"));
                info.setCouponPrice(couponInfo.getString("couponValue"));
                info.setCouponType(couponInfo.getString("couponType"));
                info.setCouponTitle(couponInfo.getString("couponTitle"));
                info.setImg(couponInfo.getString("img"));
                info.setSubTitle(couponInfo.getString("subTitle"));

                JSONObject times=dealTime(couponInfo);

                info.setStartTime(times.getDate("start"));
                info.setEndTime(times.getDate("end"));
                infos.add(info);
            }
            CouponVo vo=new CouponVo();
            vo.setCount(loginResult.getData().getInteger("count"));
            vo.setInfo(infos);
            message.setData(vo);
            return message;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return new ApiMessage();
    }

    /**
     * 查询卡劵详情
     * @param cardId
     * @return
     */
    public ApiMessage getCouponDeatil(String cardId) {

        String url=BASE_URI+"crm/open/api/coupon/memberCardList";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("statusList","02");
        int withCardInfo=1;

        map.put("withCardInfo",withCardInfo);
        map.put("couponCode",cardId);

        map.put("transCode",COUPON_TRANS_CODE);

        map = getSignAndParms(map);
        ApiMessage message = new ApiMessage();
        try {
            String result = HttpUtil.post(url, map);
            LoginResult loginResult = JSON.parseObject(result, LoginResult.class);
            //判断获取数据是否失败
            message = checkStatus(loginResult, message);
            if (!message.isSucceed()) {
                return message;
            }
            CouponDetail detail=new CouponDetail();

            JSONObject coupon=loginResult.getData();

            detail.setCode(coupon.getString("couponCode"));

            JSONObject couponInfo=coupon.getJSONObject("couponInfo");
            if(couponInfo.containsKey("shopDetail")){
                detail.setApplicableStore(couponInfo.getString("shopDetail"));
            }
            if(couponInfo.containsKey("couponTitle")){
                detail.setCouponName(couponInfo.getString("couponTitle"));
            }
            if(couponInfo.containsKey("customerServicePhone")){
                detail.setConsumerHotline(couponInfo.getString("customerServicePhone"));
            }
            if(couponInfo.containsKey("img")){
                detail.setImg(couponInfo.getString("img"));
            }
            if(couponInfo.containsKey("ruleDescription")){
                detail.setOfferDescription(couponInfo.getString("ruleDescription"));
            }
            if(couponInfo.containsKey("usedDescription")){
                detail.setUsageNotice(couponInfo.getString("usedDescription"));
            }
            if(couponInfo.containsKey("shareFriend")){
                detail.setShareFriend(couponInfo.getBoolean("shareFriend"));
            }

            JSONObject times=dealTime(couponInfo);

            detail.setStartTime(times.getDate("start"));
            detail.setEndTime(times.getDate("end"));
            message.setData(detail);

        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return message;
    }

    /**
     * 获取新人领劵活动信息
     * @return
     */
    public ApiMessage getActivityInfo(){
        String url=BASE_URI+"crm/open/api/activity/info";
        Map map=new HashMap();
        map.put("activityId",ACTIVEID);
        map.put("memberNo","");
        map.put("transCode",ACTIVE_TRANS_CODE);
        map = getSignAndParms(map);
        ApiMessage message = new ApiMessage();
        try {
            String result = HttpUtil.post(url, map);
            LoginResult loginResult = JSON.parseObject(result, LoginResult.class);

            JSONObject data=loginResult.getData();
            JSONArray array=data.getJSONArray("activityPrize");
            JSONArray results=new JSONArray();
            for (int i=0;i<array.size();i++){
                JSONObject object=new JSONObject();

                JSONObject card=array.getJSONObject(i);

                JSONObject info=card.getJSONObject("cardInfo");
                JSONObject times=dealTime(info);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //获取String类型的时间
                Boolean receive=false;
                if(info.getInteger("hasCount")>0){
                    receive=true;
                }
                String endDate = sdf.format(times.getDate("end"));
                object.put("cname",info.getString("couponTitle"));
                object.put("cimg",info.getString("img"));
                object.put("ctime",endDate);
                object.put("receive",receive);

                object.put("cnum",card.getString("cardId"));
                results.add(object);
            }
            message.setData(results);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return message;
    }

    /**
     * 领取卡劵
     * @param cardId
     * @return
     */
    public ApiMessage receiveCoupon(String cardId){
        String url=BASE_URI+"crm/open/api/coupon/grant";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("cardIds",cardId);
        map.put("transCode",RECHARGE_TRANS_CODE);
        map = getSignAndParms(map);
        ApiMessage message = new ApiMessage();
        try {
            String result = HttpUtil.post(url, map);
            LoginResult loginResult = JSON.parseObject(result, LoginResult.class);

        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return message;
    }


    /**
     * 获取微信卡劵列表
     * @param cardIds
     * @return
     */
    public ApiMessage getWxCouponList(List<String> cardIds){
        String url=BASE_URI+"crm/open/api/wxcoupon/getAddCardList";
        Map map=new HashMap();
        map.put("memberNo","");
        map.put("cardIds",cardIds);
        map.put("transCode",RECHARGE_TRANS_CODE);
        map = getSignAndParms(map);
        ApiMessage message = new ApiMessage();
        log.info(JSONObject.toJSONString(map));
        Map heads=new HashMap();
        try {
//            String result=HttpUtil.post(url,map);
            String result = HttpUtil.doPost(url,JSONObject.parseObject(JSONObject.toJSONString(map)),2000,2000,heads);
            ArrayResult loginResult = JSON.parseObject(result, ArrayResult.class);
            message.setData(loginResult.getData());
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return message;
    }


/*****************************************************************PRIVATE*******************************************************************/
    /**
     * 加密参数
     * @param map
     * @return
     */
    private Map getSignAndParms(Map map){
        //放入公共参数
        map.put("clientOrderNo",CLIENTORDERNO);
        map.put("storeNo",STORENO);
        map.put("deviceNo",DEVICENO);
        map.put("source",SOURCE);
        map.put("version",VERSION);
        //加密
        log.info("signJSON:"+JSON.toJSONString(map));
        String sign= SignUtils.getCrmSign(map,SECRET);
        //放入其他值
        map.put("sign",sign);
        map.put("crmBrand",CRMBRAND);
        map.put("secret",SECRET);

        return map;
    }

    /**
     * 判断接口返回结果
     * @param loginResult
     * @param message
     * @return
     */
    private ApiMessage checkStatus(LoginResult  loginResult,ApiMessage message){
        if(!loginResult.getSuccess()||loginResult.getResult_code()==-103){
            log.error("GET CRM INFO ERROR ：{}"+loginResult);
            message.setCode(loginResult.getResult_code());
            message.setSucceed(false);
            message.setMessage(loginResult.getResult_message());
            return message;
        }
        return message;
    }




    /**
     * 处理卡劵时间
     * @param jsonObject
     * @return
     */
    private JSONObject dealTime(JSONObject jsonObject){
        JSONObject object=new JSONObject();

        String timeType=jsonObject.getString("validTimeType");
        Date startTime=new Date();
        Date endTime=new Date();
        //判断时间类型
        if(ConstantUtils.EnumsType.ValidTimeType.VALID_DAY.comments.equals(timeType)){
            int validStartDay=jsonObject.getInteger("validStartDay");
            int validDay=jsonObject.getInteger("validDay");

            Calendar oneTime = Calendar.getInstance();
            oneTime.setTime(new Date());
            oneTime.add(Calendar.DAY_OF_MONTH, validStartDay);

            Calendar twoTime = Calendar.getInstance();
            twoTime.setTime(new Date());
            twoTime.add(Calendar.DAY_OF_MONTH, validDay);

            startTime.setTime(oneTime.getTimeInMillis());
            endTime.setTime(twoTime.getTimeInMillis());
        }else {
            startTime=jsonObject.getDate("startTime");
            endTime=jsonObject.getDate("endTime");
        }
        object.put("start",startTime);
        object.put("end",endTime);

        return object;
    }

}
