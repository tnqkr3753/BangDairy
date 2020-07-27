package com.kosmo.bangdairy.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.AccountFormServiceImpl;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.ReviewVO;

@Controller
public class IndependentController {
	

	@RequestMapping("Independent")
	public String movieAppImsert(DirectorVO Dvo, GenreVO gvo, MovieVO mvo,ReviewVO rvo,HttpServletRequest request, HttpSession session ) {	
		System.out.println("===================================================================================================");
		return "indie/Independent";
		
	}
	
	@RequestMapping("mainIndependent")
	public String movie() {	
		
		return "indie/mainIndependent";
		
	}
	@RequestMapping("indieDetail")
	public String indieDetail() {	
		
		return "indie/indieDetail";
}
}
