package com.hoperun.shuma.api.response;

import com.hoperun.shuma.vo.response.ActivePrizeVo;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By IceSnow
 * Date: 12/21/2018
 * Time: 03:13 PM
 */
@Data
public class ActivityJoinResponse {

    List<ActivePrizeVo> prizeVo;

    String activityNum;

    Boolean finish;
}
