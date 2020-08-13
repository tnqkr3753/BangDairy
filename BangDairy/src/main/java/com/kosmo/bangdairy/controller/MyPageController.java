package com.kosmo.bangdairy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.MyPageService;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.QnaVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

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
	public boolean updateUser(HttpSession session,AccountFormVO vo,
			@RequestParam(value = "currPassword")String currPassword) throws IOException {

		AccountFormVO currVO = new AccountFormVO();
		currVO.setUserPassword(currPassword);
		String userId = (String)session.getAttribute("userId");
		currVO.setUserId(userId);
		currVO = myPageService.checkUser(currVO);
		if(currVO!=null) {
			vo.setUserId(userId);
			if(vo.getUserPassword().equals("")||vo.getUserPassword()==null) {
				vo.setUserPassword(currPassword);
			}
			int result = myPageService.updateUserInfo(vo);
			if (result ==1) {
				vo = myPageService.selectUserInfo(vo);
			}
		}else {
			return false;
		}
		return true;
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
	/*
	 * 메소드 명  	:		getWishList
	 * 기능 		:		찜목록을 보여주는 페이지를 return
	 * 변수		:		session
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/wishList",method = RequestMethod.POST)
	public ModelAndView getWishList(HttpSession session) {
		WishMovieVO vo = new WishMovieVO();
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		List<WishMovieVO> list = myPageService.selectWishMovie(vo);
		ModelAndView mv = new ModelAndView();
		LoggerAspect.logger.info("list : "+list);
		mv.addObject("list",list);
		mv.setViewName("myPage/myPageWish");
		return mv;
	}
	/*
	 * 메소드 명  	:		deleteWishMovie
	 * 기능 		:		찜목록을 삭제하고 결과값을 return
	 * 변수		:		session, WishMovieVO
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/wishList/delete",method = RequestMethod.POST)
	public int deleteWishMovie(HttpSession session,WishMovieVO vo) {
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		return myPageService.deleteWishMovie(vo);
	}
	/*
	 * 메소드 명  	:		getQnaList
	 * 기능 		:		사용자의 Q&A 를 보여주고 쓸 수 있는 폼 보여줌
	 * 변수		:		session
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/Qna",method = RequestMethod.POST)
	public ModelAndView getQnaList(HttpSession session) {
		QnaVO vo = new QnaVO();
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		List<QnaVO> list = myPageService.selectQnaList(vo);
		ModelAndView mv = new ModelAndView();
		LoggerAspect.logger.info("list : "+list);
		mv.addObject("list",list);
		mv.setViewName("myPage/myPageQA");
		return mv;
	}
	
	/*
	 * 메소드 명  	:		insertQnaForm
	 * 기능 		:		Q&A를 입력할 수 있는 폼 띄우기
	 * 변수		:		session
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/Qna/insertForm",method = RequestMethod.POST)
	public ModelAndView insertQnaForm(HttpSession session) {
		QnaVO vo = new QnaVO();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myPage/myPageQAInsertForm");
		return mv;
	}
	
	/*
	 * 메소드 명  	:		insertQna
	 * 기능 		:		입력한 Q&A db 입력
	 * 변수		:		session, QnaVO
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/Qna/insertForm/insert",method = RequestMethod.POST)
	public int insertQna(HttpSession session,QnaVO vo) {
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		return myPageService.insertQna(vo);
	}
	
	/*
	 * 메소드 명  	:		selectQna
	 * 기능 		:		선택한 Q&A 정보 보여주기
	 * 변수		:		session, QnaVO
	 * 작성자		:		박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "myPage/Qna/select",method = RequestMethod.POST)
	public ModelAndView selectQna(HttpSession session,QnaVO vo) {
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		QnaVO rvo = myPageService.selectQna(vo);
		ModelAndView mv = new ModelAndView();
		if (rvo !=null) {
			mv.addObject("vo",rvo);
		}
		mv.setViewName("myPage/myPageQAView");
		return mv;
	}
	
}
