package com.kosmo.bangdairy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
	public static final Logger logger = LogManager.getLogger("Interceptor");

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info(request.getRemoteAddr()+"\t"+request.getSession().getAttribute("userId")+"\t"+request.getServletPath()+"\t"+request.getHeader("referer")+"\t"+response.getLocale());
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
