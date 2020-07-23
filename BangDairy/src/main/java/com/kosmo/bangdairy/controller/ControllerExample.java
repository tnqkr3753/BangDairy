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
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.ApiConnectionService;

@Controller
public class ControllerExample {
	@Autowired
	ApiConnectionService apiConnectionService;
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerExample.class);
	
	@RequestMapping("apiConn/{aDate}.do")
	public ModelAndView apiConn(@PathVariable(value = "aDate") String aDate) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = df.parse(aDate);
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
			//총 834달 반복 20881201까지 
			for (int i = 0; i < 834; i++) {
				try{
					cal.add(Calendar.MONTH, 1);
					logger.info("년도 == " + cal.getTime());
				apiConnectionService.runService(cal);
				}catch (Exception e) {
					logger.error("년도 총 에러 [" + "i값 : " /*+ i*/+"errorMsg : " + e.getMessage());
				}
			}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
}
