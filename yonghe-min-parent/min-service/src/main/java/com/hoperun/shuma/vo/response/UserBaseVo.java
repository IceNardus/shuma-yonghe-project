package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/10/2018
 * Time: 10:44 AM
 */
@Data
public class UserBaseVo {

    /**
     * 余额
     */
    private int balance;

    /**
     * 积分
     */
    private int integral;

    /**
     * 卡劵数量
     */
    private int couponCount;

    /**
     * 付款码
     */
    private String paymentCode;

    /**
     * 等级
     */
    private int level;

    /**
     * 手机号码
     */
    private String iphone;
}
