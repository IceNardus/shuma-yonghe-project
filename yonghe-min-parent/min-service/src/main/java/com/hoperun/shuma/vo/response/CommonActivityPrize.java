package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/24/2018
 * Time: 10:58 AM
 */
@Data
public class CommonActivityPrize extends PrizeBaseInfo {

    /**
     * 优惠劵原价
     */
    private int prizePrice;

    /**
     * 优惠后价格
     */
    private int preferentialPrice;

    /**
     * 奖品CardId
     */
    private String prizeCardId;

    /**
     * 活动ID
     */
    private int activityId;

    /**
     * 活动奖品ID
     */
    private int activityPrizeId;

    /**
     * 活动时间
     */
    private String activityTime;

    /**
     * 卡劵类型
     */
    private String prizeCardType;

    /**
     * 卡劵要求
     */
    private String prizeCardRule;

}
