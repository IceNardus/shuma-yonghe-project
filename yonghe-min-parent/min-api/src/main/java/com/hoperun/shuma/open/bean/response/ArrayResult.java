package com.hoperun.shuma.open.bean.response;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 11/29/2018
 * Time: 02:25 PM
 */
@Data
public class ArrayResult {

    private Boolean success;

    private int result_code;

    private String result_message;

    private JSONArray data;
}
