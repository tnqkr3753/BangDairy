package com.kosmo.bangdairy.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kosmo.bangdairy.aop.LoggerAspect;

public class TypeCheckInterceptor extends HandlerInterceptorAdapter {
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
		String type =(String)request.getSession().getAttribute("userType");
		LoggerAspect.logger.info("id : "+id+", type : " + type);
		if (id==null||!type.equals("0")) {
				//로그인 안했을 때
				LoggerAspect.logger.warn("관리자 체크 실패 " + request.getRemoteAddr() +" " + request.getRequestURI());
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter pw = response.getWriter();
				pw.println("<script type='text/javascript' charset='utf-8'>");
				pw.println("alert('관리자 기능입니다. 새로운 접속을 시도해주세요');");
				pw.println("history.back();");
				pw.println("</script>");
				pw.flush();
				return false;
		}
		return super.preHandle(request, response, handler);
	}

	
	
}
