package com.hoperun.shuma.api.session;

import com.alibaba.fastjson.JSONObject;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.common.utils.ConstantUtils;
import com.hoperun.shuma.vo.par.MinMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class SessionManager {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${sys.session.expireTime:1800}")
    private int expireTime;

    public Object getRedisValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 添加缓存
     * @param session
     */
    public void setOrUpdateSession(ApiSession session) {
         //String  memberInfo= JSONObject.toJSON(session.getMember()).toString();
         redisTemplate.opsForValue().set(session.getSessionId(),session.getMember(), expireTime, TimeUnit.SECONDS);
    }

    /**
     * 刷新缓存
     * @param sessionId
     */
    public void flushSession(String sessionId) {
        if (expireTime > 0) {
            //设置过期时间
            redisTemplate.expire(sessionId, expireTime, TimeUnit.SECONDS);
        }
    }

    /**
     * 获取缓存用户
     * @param sessionId
     * @return
     */
    public MinMember getSession(String sessionId){
        MinMember memberInfo=(MinMember)this.getRedisValue(sessionId);
        if(memberInfo==null){
            log.error("User_Token Invalid!");
            throw new ApiException(ApiResponseStatus.NOT_DATE_TIME);
        }
       /* JSONObject object=JSONObject.parseObject(memberInfo);
        MinMember member=new MinMember();
        member.setWxMinOpenId(object.getString("wxMiniOpenid"));
        member.setUnionId(object.getString("unionId"));
        member.setCrmNo(object.getString("memberNo"));*/
        return  memberInfo;
    }

    /**
     * 设置返回值
     * @param member
     * @param response
     */
    public void resultResponse(MinMember member, HttpServletResponse response) {
        ApiSession session = new ApiSession(member);
        //刷新或设置SESSION缓存
        this.setOrUpdateSession(session);
        response.setHeader(ConstantUtils.USER_TOKEN, session.getSessionId());
    }
}
