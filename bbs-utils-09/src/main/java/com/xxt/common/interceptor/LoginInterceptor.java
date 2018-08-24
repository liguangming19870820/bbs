package com.xxt.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xxt.common.utils.CookieUtils;
import com.xxt.common.utils.HttpClientUtils;
import com.xxt.common.utils.JsonUtils;
import com.xxt.common.utils.ResultVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String userkey = CookieUtils.getCookie(request, "userkey");
		
		System.out.println(request.getRequestURL());
		if (StringUtils.isNotBlank(userkey)) {
			String url = "http://sso.taotao.com:8889/user/token/"+userkey;
			String json = HttpClientUtils.doGet(url);
			ResultVO resultVO = JsonUtils.jsonToPojo(json, ResultVO.class);
			if (resultVO.getStatus().equals(200)) {
				return true;
			} 
		}
		
		String url = "";
		if (request.getQueryString() == null) {
			url = request.getRequestURL().toString();
		} else {
			url = request.getRequestURL().toString()+"?"+request.getQueryString();
		}
		response.sendRedirect(request.getContextPath()+"/user/toLogin?url="+url);
		return false;
	}
}
