package com.kosmo.bangdairy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosmo.bangdairy.service.AccountFormServiceImpl;

@Controller
public class AccountForm {
	
	
	//서비스 연결
	@Autowired
	private AccountFormServiceImpl accountFormService;
	
	@RequestMapping(value = "/AccountForm_idCheck")
	@ResponseBody
	public int AccountForm_idCheck(HttpServletRequest request) {
		String user_id = request.getParameter("user_id");
		int result = accountFormService.idCheck(user_id);
		return result;
	}
}
