package com.hoperun.shuma.vo.response;

import lombok.Data;

/**
 * 广告位返回值
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 9/10/2018
 * Time: 9:36 AM
 */
@Data
public class AdSpaceVo {

    /**
     * 活动名
     */
    private String activeName;

    /**
     * 展示图片
     */
    private String img;

    /**
     * 活动地址
     */
    private String activeUrl;
}
