package com.hoperun.shuma.vo.response;

import lombok.Data;

import java.util.List;

/**
 * 分享结果
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/28/2018
 * Time: 02:50 PM
 */
@Data
public class ShareResultVo {

    private List<ActivePrizeVo> vos;

    private Boolean finish;

    private String activityNum;

    private ActivityMsg msgs;
}
