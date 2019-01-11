package com.hoperun.shuma.open.bean.response;

import lombok.Data;

/**
 */
@Data
public class DataObj  {
    //微信信息
    private String openid;            //用户的标识，对当前公众号唯一
    private String nickname;
    private Integer sex;            //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String province;
    private String city;
    private String country;
    private String headimgurl;
    private String language;
    //sns 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
    private String[] privilege;
    //多个公众号之间用户帐号互通UnionID机制
    //private String unionid;

    //CRM——member信息
    private String userId;
    private String mobile;
    private String unionid;
    //CRM——member——userInfo信息
    private String name;
    //小程序用户参数
    private String session_key;
    private String errcode;
    private String errMsg;
}
