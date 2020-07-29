package com.kosmo.bangdairy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.vo.AccountFormVO;

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
	/*
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info/updateForm",method = RequestMethod.POST)
	public ModelAndView updateForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myPage/myPageMemberUpdateForm");
		return mv;
	}
	/*
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info/updateUser",method = RequestMethod.POST)
	public ModelAndView updateUser(HttpSession session,AccountFormVO vo,RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView();
		//mv.addObject("", attributeValue)
		LoggerAspect.logger.info(vo);
		ra.addFlashAttribute("session", session);
		mv.setViewName("myPage/myPageMember");
		return mv;
	}
}
