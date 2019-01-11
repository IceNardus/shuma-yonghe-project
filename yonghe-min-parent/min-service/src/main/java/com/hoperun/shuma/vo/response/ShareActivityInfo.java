package com.hoperun.shuma.vo.response;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/27/2018
 * Time: 02:32 PM
 */
@Data
public class ShareActivityInfo {

    /**
     * 是否达到参加次数
     */
    private boolean canJoin;

    /**
     * 奖品集合
     */
    private List<ActivePrizeVo> vos;

    /**
     * 宣传图片
     */
    private String activityImg;



    /**
     * 是否活动结束
     */
    private boolean finish;

    /**
     * 是否参加
     */
    private boolean join;

    /**
     * 是否已领取
     */
    private boolean isReceive=false;

    /**
     * 活动要求人数
     */
    private int activityClaimCount;

    /**
     * 活动规则
     */
    private String activityRule;

    /**
     * 用户活动标识
     */
    private String activityUserNo;

    /**
     * 记录编号
     */
    private String recordNo;

    /**
     * 是否是发起者
     */
    private boolean isInitiator=true;

    /**
     * 用户头像
     */
    private List<String> user;

}
