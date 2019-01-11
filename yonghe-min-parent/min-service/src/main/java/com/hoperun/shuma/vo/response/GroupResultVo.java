package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/11/2018
 * Time: 1:45 PM
 */
@Data
public class GroupResultVo {

    /**
     * 拼团编号
     */
    private String activityNum;

    /**
     * 奖品
     */
    private PrizeCouponVo vo;

    /**
     * 是否拼团结束
     */
    private Boolean finish;
}
