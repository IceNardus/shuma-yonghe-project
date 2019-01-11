package com.hoperun.shuma.api.request;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/19/2018
 * Time: 05:59 PM
 */
@Data
public class MemberInfo {

    /**
     * 小程序openId
     */
    private String minOpenId;

    /**
     * 用户unionId
     */
    private String unionId;

    private String code;

    private String iv;

    private StringBuffer encryptedData;
}
