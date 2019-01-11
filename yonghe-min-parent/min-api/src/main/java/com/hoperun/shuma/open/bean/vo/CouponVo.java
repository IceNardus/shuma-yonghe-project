package com.hoperun.shuma.open.bean.vo;


import java.util.List;

import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/3/2018
 * Time: 11:31 AM
 */
@Data
public class CouponVo {

    /**
     * 具体数量
     */
    private int count;

    /**
     * 卡劵集合
     */
    private List<CouponInfo> info;
}
