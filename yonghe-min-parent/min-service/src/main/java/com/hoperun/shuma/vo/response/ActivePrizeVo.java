package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/11/2018
 * Time: 10:54 AM
 */
@Data
public class ActivePrizeVo extends  PrizeBaseInfo{


    /**
     * 奖品
     */
    private String prizeCardId;

    /**
     * 活动编号
     */
    private String activityNum;

    /**
     * 活动类型
     */
    private String activityType;


}
