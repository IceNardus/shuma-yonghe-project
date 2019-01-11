package com.hoperun.shuma.open.bean.request;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/17/2018
 * Time: 10:18 AM
 */
@Data
public class WxCoupon {

    /**
     * 获取
     */
    List<String> cardIds;

    /**
     * 加密信息
     */
    String encryptCode;
}
