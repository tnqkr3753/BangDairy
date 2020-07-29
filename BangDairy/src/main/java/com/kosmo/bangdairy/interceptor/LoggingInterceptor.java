package com.kosmo.bangdairy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
	public static final Logger logger = LogManager.getLogger("Interceptor");
	/*
	 * 메소드명		: preHandler (@Override)
	 * 기능			: 페이지를 거치거나 서버에 요청을 보낼 때 마다 logger에 기록해 파일로 남김
	 * 변수			: request, response, handler, modelAndView
	 * 작성자			: 박윤태
	 */

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info(request.getRemoteAddr()+"\t"+request.getRequestURL()+"\t"+request.getSession().getAttribute("userId")+"\t"+request.getServletPath()+"\t"+request.getHeader("referer")+"\t"+response.getLocale());
		return super.preHandle(request, response, handler);
	}
		
}
