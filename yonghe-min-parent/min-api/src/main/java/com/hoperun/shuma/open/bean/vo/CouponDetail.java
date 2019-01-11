package com.hoperun.shuma.open.bean.vo;

import lombok.Data;

import java.util.Date;

/**
 * 卡劵详情
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/3/2018
 * Time: 03:43 PM
 */
@Data
public class CouponDetail {

    /**
     * 卡劵名
     */
    private String couponName;

    /**
     * 卡劵图片
     */
    private String img;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 卡劵code
     */
    private String code;

    /**
     * 优惠说明
     */
    private String offerDescription;

    /**
     * 客服电话
     */
    private String  consumerHotline;

    /**
     *使用须知
     */
    private String usageNotice;
    /**
     * 适用门店描述
     */
    private String applicableStore;

    /**
     * 是否可分享好友
     */
    private Boolean shareFriend;
}
