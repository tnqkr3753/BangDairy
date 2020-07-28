package com.kosmo.bangdairy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.AccountFormServiceImpl;
import com.kosmo.bangdairy.vo.AccountFormVO;

@Controller
public class AccountForm {
	private static final Logger logger = (Logger) LogManager.getLogger("warning");
	private static final Logger logger2 = (Logger) LogManager.getLogger("");
	
	
	//서비스 연결
	@Autowired
	private AccountFormServiceImpl accountFormService;
	
	
	//비동기 아이디 체크
	@RequestMapping(value = "/AccountForm_idCheck")
	@ResponseBody
	public int accountForm_idCheck(HttpServletRequest request) {
		logger2.info("INFO Message");
		logger.warn("WARN Message");
		logger.error("Error Message");
		//request를 통해 아이디 변경시마다 아이디 값아서 db에 해당 아이디가 존재하는지 질의한다.
		String user_id = request.getParameter("user_id");
		int result = accountFormService.idCheck(user_id);
		return result;
	}
	
	//회원가입시 고객 회원
	@RequestMapping(value="/AccountUser")
	public void accountUser(AccountFormVO vo) {
		int result = accountFormService.insertUser(vo);

	}
	//유저 로그인
	@RequestMapping(value="/SignInUser", method = RequestMethod.POST)
	@ResponseBody
	public int signInUser( AccountFormVO vo,HttpSession sess) {
		int result = accountFormService.signInUser(vo);
		if (result==1) {
			sess.setAttribute("userId", vo.getUserId());
			//sess.setMaxInactiveInterval(300);
		}
		return result;
	}
}
