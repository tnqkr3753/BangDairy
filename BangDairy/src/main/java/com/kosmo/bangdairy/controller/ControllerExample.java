package com.kosmo.bangdairy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.bangdairy.service.ApiConnectionService;

@Controller
public class ControllerExample {
	@Autowired
	ApiConnectionService apiConnectionService;
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerExample.class);
	/*
	 * 메소드명	: apiConn
	 * 기능		: 영화 정보 가져오는 메소드 (1달 단위)
	 * 변수 		: aData(yyyyMMdd)
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping("apiConn/{aDate}.do")
	public void apiConn(@PathVariable(value = "aDate") String aDate) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = df.parse(aDate);
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				try{
					logger.info("년도 == " + cal.getTime());
					apiConnectionService.runService(cal);
				}catch (Exception e) {
					logger.error("년도 총 에러 [" + "i값 : " /*+ i*/+"errorMsg : " + e.getMessage());
				}
	}
}
