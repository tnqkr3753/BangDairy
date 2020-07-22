package com.kosmo.bangdairy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		apiConnectionService.runService(cal);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
}
