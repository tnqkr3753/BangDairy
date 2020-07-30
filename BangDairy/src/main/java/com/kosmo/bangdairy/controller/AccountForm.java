package com.kosmo.bangdairy.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.mapping.ParameterMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.python.jline.internal.InputStreamReader;
import org.python.util.PythonInterpreter;
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
	
	// 자바에서 파이썬 파일 실행 함수
	private static PythonInterpreter interpreter;
	
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
		int result = accountFormService.signInUser(vo);
		if (result==1) {
			sess.setAttribute("userId", vo.getUserId());
			//sess.setMaxInactiveInterval(300);

			try {
				String HOST = "192.168.0.22";
				int PORT = 8765;
				Socket socket = new Socket(HOST,PORT);
				System.out.println("클라이언트 접속");

				//쓰기
				PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
				out.println(vo.getUserId());
				
				//읽기
				BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				String rev;
				
				while((rev=in.readLine())!=null) {
					System.out.println("받음:"+rev);
				}
				in.close();
				socket.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		return result;
	}
	@RequestMapping(value="/userLogout")
	@ResponseBody
	public int userLogout(HttpSession sess) {
		sess.removeAttribute("userId");
		if(sess.getAttribute("userId")==null) {
			return 1;
		}
		return 0;
	}
}
