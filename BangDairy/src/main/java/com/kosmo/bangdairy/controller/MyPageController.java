package com.kosmo.bangdairy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyPageController {
	
	/*
	 * 메소드 명  	:		getInfo
	 * 기능 		:		유저의 정보를 가져옴
	 * 변수		:		Session
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info",method = RequestMethod.POST)
	public ModelAndView getInfo(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		//mv.addObject("", attributeValue)
		mv.setViewName("myPage/myPageMember");
		return mv;
	}
}
