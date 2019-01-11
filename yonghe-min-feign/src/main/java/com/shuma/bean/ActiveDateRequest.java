package com.shuma.bean;

import lombok.Data;

/**
 * 活动参加提交数据
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/11/2018
 * Time: 11:47 AM
 */
@Data
public class ActiveDateRequest {


    /**
     * 记录编号
     */
    private String activityNum;

    /**
     * 用户头像
     */
    private String img;

    /**
     * 用户fromId
     */
    private String fromId;

    /**
     * 活动类型
     */
    private String activityType;

    /**
     * 活动Id
     */
    private int activityId;

    /**
     * 活动奖品ID
     */
    private int activityPrizeId;

    /**
     * 活动用户标识
     */
    private String activityUserNo;

    /**
     * 卡劵名
     */
    String couponName;

}
