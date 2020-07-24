package com.kosmo.bangdairy.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.bangdairy.service.AccountFormServiceImpl;
import com.kosmo.bangdairy.vo.AccountFormVO;

@Controller
public class AccountForm {
	private static final Logger logger = (Logger) LogManager.getLogger("warning");
	private static final Logger logger2 = (Logger) LogManager.getLogger("");
	
	
	//서비스 연결
	@Autowired
	private AccountFormServiceImpl accountFormService;
	
	@RequestMapping(value = "/AccountForm_idCheck")
	@ResponseBody
	public int AccountForm_idCheck(HttpServletRequest request) {
		logger2.info("INFO Message");
		logger.warn("WARN Message");
		logger.error("Error Message");
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		int result = accountFormService.idCheck(user_id);
		return result;
	}
	@RequestMapping(value="/AccountUser")
	public void AccountUser(AccountFormVO vo) {
		System.out.println(vo.getUserId());
		System.out.println("옴");

	}
}
