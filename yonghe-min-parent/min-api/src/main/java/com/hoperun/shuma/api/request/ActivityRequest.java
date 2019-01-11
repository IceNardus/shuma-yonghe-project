package com.hoperun.shuma.api.request;

import lombok.Data;

import java.util.List;

/**
 * 活动请求
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/20/2018
 * Time: 10:08 AM
 */
@Data
public class ActivityRequest {

    /**
     * 活动类型
     */
    private List<String> activityTypes;

    /**
     * 活动记录编号
     */
    private String activityNum;

    /**
     * 活动用户标识
     */
    private String activityUserNo;
}
