package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/12/2018
 * Time: 9:15 AM
 */
@Data
public class DailyPrizeBase {

    /**
     * 卡劵名
     */
    private String cName;

    /**
     * 卡劵图片
     */
    private String cImg;

    /**
     * 卡劵时间
     */
    private String cTime;

    /**
     * 卡劵规则
     */
    private String cRule;

    /**
     * 卡劵编号
     */
    private String cNum;

    /**
     * 数量
     */
    private int count=1;

    /**
     * 是否领取
     */
    private Boolean receive=false;
}
