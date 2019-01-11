package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/18/2018
 * Time: 04:29 PM
 */
@Data
public class ActivityMsg {

    /**
     * fromId,卡劵名,用户openId
     */
    private String fromId,couponName,openId,activityName,createTime,activityType;


}
