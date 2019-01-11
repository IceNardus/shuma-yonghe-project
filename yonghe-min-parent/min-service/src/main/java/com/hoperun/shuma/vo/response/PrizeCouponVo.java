package com.hoperun.shuma.vo.response;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/18/2018
 * Time: 04:45 PM
 */
@Data
public class PrizeCouponVo {

    private ActivePrizeVo prizeVo;

    private List<ActivityMsg> msgs;
}
