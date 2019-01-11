package com.hoperun.shuma.api.session;

import com.hoperun.shuma.vo.par.MinMember;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by ZC on 2017/11/21.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApiSession implements Serializable {
    private static final long serialVersionUID = 2148322682320064096L;

    private String sessionId;
    /**
     *     用户信息
     */
    private MinMember member;

    public ApiSession(MinMember curMember){
        this.member=curMember;
        this.sessionId= UUID.randomUUID().toString();
    }
}
