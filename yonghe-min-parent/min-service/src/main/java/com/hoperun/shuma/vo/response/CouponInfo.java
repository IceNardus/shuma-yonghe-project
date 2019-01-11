package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/10/2018
 * Time: 5:15 PM
 */
@Data
public class CouponInfo {

    private String cName;

    private String cImg;

    private String cTime;

    private String cRule;

    private long cId;

    private String cCode;

    private Boolean shareFriend;

    private String cType;

    private String cIphone;

    private String cPrompt;

    public CouponInfo(){

    }

}
