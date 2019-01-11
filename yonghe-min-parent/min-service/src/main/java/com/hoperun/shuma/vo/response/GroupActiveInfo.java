package com.hoperun.shuma.vo.response;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/11/2018
 * Time: 10:57 AM
 */
@Data
public class GroupActiveInfo {
    /**
     * 宣传图
     */
    private String img;

    /**
     * 活动名
     */
    private String aName;

    /**
     * 活动规则
     */
    private String aRule;

    /**
     * 用户头像
     */
    private List<String> user;

    /**
     * 是否已经参加
     */
    private Boolean join;

    /**
     * 活动编号
     */
    private String aNum;

    /**
     * 奖品集合
     */
    private List<PrizeBaseInfo> vos;

    /**
     * 开始时间
     */
    private String startTime;


    /**
     * 结束时间
     */
    private String entTime;

    /**
     * 记录编号
     */
    private String recordNo;

    /**
     * 是否是新活动
     */
    private Boolean isNew;

    /**
     * 是否已结束
     */
    private Boolean finish;

    /**
     * 是否已领取
     */
    private Boolean isRecord=false;

    /**
     * 奖品卡劵
     */
    private ActivePrizeVo prize;
}
