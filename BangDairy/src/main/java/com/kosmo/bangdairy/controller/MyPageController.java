package com.kosmo.bangdairy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.MyPageService;
import com.kosmo.bangdairy.vo.AccountFormVO;

@Controller
public class MyPageController {
	@Autowired
	MyPageService myPageService;
	/*
	 * 메소드 명  	:		myPage
	 * 기능 		:		마이페이지로 이동
	 * 변수		:		None
	 * 작성자		:		박윤태
	 */
	@RequestMapping(value = "myPage")
	public ModelAndView myPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myPage/myPage");
		return mv;
	}
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
		String userId = (String)session.getAttribute("userId");
		AccountFormVO vo = new AccountFormVO();
		vo.setUserId(userId);
		vo = myPageService.selectUserInfo(vo);
		mv.addObject("vo", vo);
		mv.setViewName("myPage/myPageMember");
		return mv;
	}
	/*
	 * 메소드 명  	:		updateForm
	 * 기능 		:		유저의 정보를 수정하는 창을 return
	 * 변수		:		Session
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info/updateForm",method = RequestMethod.POST)
	public ModelAndView updateForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");
		AccountFormVO vo = new AccountFormVO();
		vo.setUserId(userId);
		vo = myPageService.selectUserInfo(vo);
		mv.addObject("vo", vo);
		mv.setViewName("myPage/myPageMemberUpdateForm");
		return mv;
	}
	/*
	 * 메소드 명  	:		updateUser
	 * 기능 		:		유저의 정보를 수정하는 메소드
	 * 변수		:		Session, AccountFormVO, 
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info/updateUser",method = RequestMethod.POST)
	public ModelAndView updateUser(HttpSession session,AccountFormVO vo) {
		LoggerAspect.logger.info("=== updateUser ===");
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		int result = myPageService.updateUserInfo(vo);
		if (result ==1) {
			vo = myPageService.selectUserInfo(vo);
		}
		mv.addObject("vo", vo);
		mv.setViewName("myPage/myPageMember");
		return mv;
	}
	/*
	 * 메소드 명  	:		deleteUserForm
	 * 기능 		:		회원탈퇴를 위해 비밀번호 재확인 창으로 감
	 * 변수		:		none
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info/deleteUserForm",method = RequestMethod.POST)
	public ModelAndView deleteUserForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myPage/passCheck");
		return mv;
	}
	/*
	 * 메소드 명  	:		deleteUser
	 * 기능 		:		회원정보 삭제 //로그에 남김
	 * 변수		:		session, AccountFormVO
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/info/deleteUser",method = RequestMethod.POST)
	public int deleteUser(HttpSession session,AccountFormVO vo) {
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		AccountFormVO avo = myPageService.selectUserInfo(vo);
		int result = myPageService.deleteUserInfo(vo);
		if(result ==1) {
			session.removeAttribute("userId");
			LoggerAspect.logger.warn("DELETE USER INFO : " +avo);
		}
		return result;
	}
}
