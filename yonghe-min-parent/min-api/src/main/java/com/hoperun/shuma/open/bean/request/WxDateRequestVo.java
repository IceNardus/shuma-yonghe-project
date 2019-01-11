package com.hoperun.shuma.open.bean.request;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/5/2018
 * Time: 11:03 AM
 */
@Data
public class WxDateRequestVo {

    /**
     * 小程序标识
     */
    private String openid;
    /**
     * unionId
     */
    private String unionid;
    /**
     * 用户手机号
     */
    private String iphone;

}
