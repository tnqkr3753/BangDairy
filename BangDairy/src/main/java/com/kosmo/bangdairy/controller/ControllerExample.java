package com.kosmo.bangdairy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.ApiConnectionService;

@Controller
public class ControllerExample {
	@Autowired
	ApiConnectionService apiConnectionService;
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerExample.class);
	/*
	 * 메소드명	: apiConn
	 * 기능		: 영화 정보 가져오는 메소드 (마지막 업데이트부터 지금까지)
	 * 변수 		: session
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "api/conn/movie",method = RequestMethod.POST)
	public void apiConn(HttpSession session) {
		String type = (String)session.getAttribute("userType");
		if(type.equals("0")) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date date = apiConnectionService.getLastUpdate();
			cal.setTime(date);
					try{
						logger.info("년도 == " + cal.getTime());
						apiConnectionService.runService(cal);
					}catch (Exception e) {
						logger.error("년도 총 에러 [" + "i값 : " /*+ i*/+"errorMsg : " + e.getMessage());
					}
			LoggerAspect.logger.info("종료 날짜 : "+ cal.getTime());
		}
	}
}
