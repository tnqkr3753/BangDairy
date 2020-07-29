package com.kosmo.bangdairy.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kosmo.bangdairy.aop.LoggerAspect;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	/*
	 * 메소드명		: preHandler (@Override)
	 * 기능			: 페이지를 거치거나 서버에 요청을 보낼 때 마다 request Session에 있는 아이디 정보 확인
	 * 변수			: request, response, handler, modelAndView
	 * 작성자			: 박윤태
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String id =(String)request.getSession().getAttribute("userId");
		LoggerAspect.logger.info("id : "+id);
		if (id==null) {
			//로그인 안했을 때
			LoggerAspect.logger.warn("세션 만료 " + request.getRemoteAddr() +" " + request.getRequestURI());
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script type='text/javascript'>");
			pw.println("alert('로그인이 필요한 기능입니다. 로그인을 해주세요');");
			pw.println("history.back();");
			pw.println("</script>");
			pw.flush();
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	
	
}
