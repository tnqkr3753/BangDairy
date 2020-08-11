package com.kosmo.bangdairy.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.mapping.ParameterMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.AccountFormServiceImpl;
import com.kosmo.bangdairy.service.KakaoAPI;
import com.kosmo.bangdairy.service.MovieDetailServiceImpl;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Controller
public class AccountForm {
	private static final Logger logger = (Logger) LogManager.getLogger("warning");
	private static final Logger logger2 = (Logger) LogManager.getLogger("");
	
	@Autowired
	private KakaoAPI kakao;
	//서비스 연결
	@Autowired
	private AccountFormServiceImpl accountFormService;
	
	/*
	 * 메소드명 : accountForm_idCheck
	 * 기능 : DB에 넘겨받은 인자(Id)를 검색해 해당 인자의 존재여부를 리턴한다
	 * 변수 : result = DB의 검색 결과
	 * 		 user_id : ajax를 통해 넘겨받는 인자(id)
	 * 작성자 : 이경호
	 */
	@RequestMapping(value = "/AccountForm_idCheck")
	@ResponseBody
	public int accountForm_idCheck(HttpServletRequest request) {
		String user_id = request.getParameter("id");
		int result = accountFormService.idCheck(user_id);	
		return result;
	}
	/*
	 * 메소드명 : accountForm_emailCheck
	 * 기능 : DB에 넘겨받은 인자(email)를 검색해 해당 인자의 존재여부를 리턴한다
	 * 변수 : result = DB의 검색 결과
	 * 		 user_email : ajax를 통해 넘겨받는 인자(email)
	 * 작성자 : 이경호
	 */
	@RequestMapping(value="/AccountForm_emailCheck",method = RequestMethod.POST)
	@ResponseBody
	public int accountForm_emailCheck(String email) {
		
		int result = accountFormService.emailCheck(email);	
		System.out.println(result);
		return result;
	}
	
	/*
	 * 메소드명 : accountUser
	 * 기능 : 유저의 회원가입 정보를 넘겨받아 DB에 유저 정보를 저장 시킨다
	 * 변수 : result = DB sql(insert)문 실행 결과
	 * 작성자: 이경호
	 */
	@RequestMapping(value="/AccountUser", method = RequestMethod.POST)
	@ResponseBody
	public int accountUser(AccountFormVO vo) {
		int result = accountFormService.insertUser(vo);
		return result;
	}
	/*
	 * 메소드명 : signInUser
	 * 기능 : 유저 정보를 DB에 검색하여 존재 여부를 리턴하고,
	 * 		 해당 유저정보가 존재할 경우 세션에 유저ID를 저장한다.
	 * 변수 : result = DB에 유저정보 검색 결과
	 * 		sess = 세션
	 * 작성자 : 이경호
	 */
	@RequestMapping(value="/SignInUser", method = RequestMethod.POST)
	@ResponseBody
	public int signInUser( AccountFormVO vo,HttpSession sess,HttpServletRequest request) {
		AccountFormVO avo = accountFormService.signInUser(vo);
		int result = 0;
		if (avo!=null) {
			result=1;
			sess.setAttribute("userId", avo.getUserId());
			sess.setAttribute("userType", avo.getUserType());
			System.out.println(avo);
			if(avo.getUserType().equals("0")) {
				result = 2; //admin
			}
		}
		return result;
	}
	@RequestMapping(value="/userLogout")
	@ResponseBody
	public int userLogout(HttpSession sess) {
		sess.removeAttribute("userId");
		sess.removeAttribute("userType");
		if(sess.getAttribute("userId")==null) {
			return 1;
		}
		return 0;
	}
	/*
	 * 메소드명 : kakaoLogin
	 * 기능 : kakao api를 사용해 로그인기능을 수행
	 * 변수 : 
	 * 작성자 : 박윤태
	 */
	@RequestMapping(value = "login/kakao")
	@ResponseBody
	public ModelAndView kakaoLogin(@RequestParam(value = "code") String code,HttpSession session) {
		String accessToken = kakao.getAccessToken(code);
		logger.info(accessToken);
		HashMap<String, Object> userInfo = kakao.getUserInfo(accessToken);
		AccountFormVO vo = new AccountFormVO();
		vo.setUserId((String)userInfo.get("email"));
		vo.setAbsoluteFilePath((String)userInfo.get("profile"));
		vo.setUserEmail((String)userInfo.get("email"));
		vo.setUserType("2");
		ModelAndView mv = new ModelAndView();
		AccountFormVO avo = accountFormService.checkForKakao(vo);
		if (avo != null) {
			//이미 카카오 계정으로 가입이 되어있는 사람
			session.setAttribute("userId", avo.getUserId());
			session.setAttribute("userType", avo.getUserType());
			if(avo.getUserType().equals("0")) {
				mv.setViewName("admin/adminMain");
			}
			else mv.setViewName("redirect:/index.jsp");
		}else {
			accountFormService.joinKakao(vo);
			session.setAttribute("userId", vo.getUserId());
			session.setAttribute("userType", vo.getUserType());
			mv.setViewName("redirect:/index.jsp");
		}
		return mv;
	}
}
