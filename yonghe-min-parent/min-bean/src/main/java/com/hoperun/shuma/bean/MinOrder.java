package com.hoperun.shuma.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hoperun.shuma.common.utils.ConstantUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 1/8/2019
 * Time: 11:11 AM
 */
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "min_order")
public class MinOrder implements Serializable{

    private static final long serialVersionUID = -3984935562151735308L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date createTime = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date updateTime;

    private String deleteStatus = ConstantUtils.EnumsType.Status.VALID.getcomments();

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 微信订单号
     */
    private String wxOrderNo;

    /**
     * 订单图片
     */
    private String img;

    /**
     * 订单金额（单位为:分）
     */
    private Integer amount;

    /**
     * 微信小程序openId
     */
    private String wxMinOpenId;

    /**
     * 活动编号
     */
    private String activityNum;
}
