package com.hoperun.shuma.open.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/3/2018
 * Time: 10:54 AM
 */
@Data
public class CouponInfo {

    /**
     * 图片地址
     */
    private String img;

    /**
     * 原价
     */
    private String originalPrice;

    /**
     * 现价
     */
    private String couponPrice;


    /**
     * 卡劵类型
     */
    private String couponType;

    /**
     * 卡劵标题
     */
    private String couponTitle;


    /**
     * 卡劵有效期 开始时间
     */
    private Date startTime;

    /**
     * 卡劵有效期 结束时间
     */
    private Date endTime;

    /**
     * code
     */
    private String code;

    /**
     * 副标题
     */
    private String subTitle;
}
