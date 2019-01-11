package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/12/2018
 * Time: 05:22 PM
 */
@Data
public class TransRecordResponse {

    /**
     * 处理积分
     */
    private int score;

    /**
     * 消费详情
     */
    private String desc;

    /**
     * 消费时间
     */
    private String time;
}
