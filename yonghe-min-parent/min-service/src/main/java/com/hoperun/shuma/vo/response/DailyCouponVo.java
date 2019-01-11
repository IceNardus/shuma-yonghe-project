package com.hoperun.shuma.vo.response;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/11/2018
 * Time: 6:18 PM
 */
@Data
public class DailyCouponVo {
    /**
     * 卡劵基本信息
     */
     private List<DailyPrizeBase> base;
    /**
     * 活动名
     */
    private String aName;
    /**
     * 活动图片
     */
    private String aImg;

    /**
     * 活动时间
     */
    private String aTime;

    /**
     * 活动时间
     */
    private String aRule;
}
