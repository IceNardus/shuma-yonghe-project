package com.hoperun.shuma.api.interceptor;

import com.hoperun.shuma.api.session.SessionManager;
import com.hoperun.shuma.common.utils.StringUtil;
import com.hoperun.shuma.common.exception.ApiException;
import com.hoperun.shuma.common.exception.ApiResponseStatus;
import com.hoperun.shuma.vo.ThreadMember;
import com.hoperun.shuma.vo.par.MinMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	private SessionManager manager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		//判断是否登录
		if (request.getMethod().equals("OPTIONS") ||request.getMethod().equals("PUT")) {
			return true;
		}
		String requestURI = request.getRequestURI();
		String userToken = request.getHeader("User-Token");
		if (requestURI.indexOf("/login")<0){
			if (StringUtil.isNotEmpty(userToken)) {
				MinMember member = manager.getSession(userToken);
				if(member!=null){
					ThreadMember.set(member);
				}else{
					log.info("User-Token is null, Request Url = {}", request.getRequestURL());
					throw new ApiException(ApiResponseStatus.NO_USER_LOGIN);
				}
			} else {
				log.info("User-Token is null, Request Url = {}", request.getRequestURL());
				throw new ApiException(ApiResponseStatus.NO_USER_LOGIN);
			}
		}





		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 删除ThreadLocal
		ThreadMember.remove();
		//TODO 判断请求不为OPTIONS请求 请求完更新User-Token时间
		if (!request.getMethod().equals("OPTIONS") ) {
			String userToken = request.getHeader("User-Token");
			if(StringUtil.isNotEmpty(userToken)) {
				manager.flushSession(userToken);
			}
		}
	}
}
