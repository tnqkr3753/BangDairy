package com.kosmo.bangdairy.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.AdminService;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	/*
	 * 메소드 명 		: goAdminPage
	 * 기능			: 세션에서 유저타입이 0인 유저를 adminMain페이지로 이동시킨다
	 * 변수			: session
	 * 작성자			: 박윤태
	 */
	@RequestMapping(value = "/admin")
	public ModelAndView goAdminPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String type = (String) session.getAttribute("userType");
		if(type!=null) {
			if (type.equals("0")) {
				mv.setViewName("admin/adminMain");
			}else {
				mv.setViewName("redirect:/index.jsp");
			}
		}else {
			mv.setViewName("redirect:/index.jsp");
		}
		return mv;
	}
	/*
	 * 메소드 명 		: getMovieList
	 * 기능			: 영화리스트를 페이지 수에 맞게 띄워준다
	 * 						searchWord가 all이 아니면 들어온 값으로 시작하는 영화리스트를
	 * 						띄워준다.
	 * 변수			: searchWord, page
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/movie/{searchWord}/{page}")
	public ModelAndView getMovieList(@PathVariable(value = "searchWord")String searchWord,
			@PathVariable(value = "page")String page) {
		ModelAndView mv = new ModelAndView();
		HashMap hash = new HashMap();
		searchWord = searchWord.replace(" ", "");
		hash.put("page", Integer.parseInt(page)*10);
		if(!searchWord.equals("all")) {
			hash.put("searchWord", searchWord);
			mv.addObject("search",searchWord);
		}
		List<HashMap> list = adminService.getMovie(hash);
		mv.addObject("list", list);
		mv.setViewName("admin/adminMovie");
		return mv;
	}
	/*
	 * 메소드 명 		: getUserList
	 * 기능			: 유저리스트를 페이지 수에 맞게 띄워준다
	 * 						searchWord가 all이 아니면 들어온 값으로 시작하는 userId의
	 * 						유저리스트를 띄워준다.
	 * 변수			: searchWord, page
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/user/{searchWord}/{page}")
	public ModelAndView getUserList(@PathVariable(value = "searchWord")String searchWord,
			@PathVariable(value = "page")String page) {
		ModelAndView mv = new ModelAndView();
		HashMap hash = new HashMap();
		searchWord = searchWord.replace(" ", "");
		hash.put("page", Integer.parseInt(page)*10);
		if(!searchWord.equals("all")) {
			hash.put("searchWord", searchWord);
			mv.addObject("search",searchWord);
		}
		List<AccountFormVO> list = adminService.getUser(hash);
		mv.addObject("list", list);
		mv.setViewName("admin/adminUser");
		return mv;
	}	/*
	 * 메소드 명 		: getDiaryList
	 * 기능			: 다이어리리스트를 페이지 수에 맞게 띄워준다
	 * 						SearchWord가 all이 아니면 들어온 값으로 시작하는 userId의
	 * 					 영화리스트를 띄워준다.
	 * 변수			: movieTitle, page
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/diary/{searchWord}/{page}")
	public ModelAndView getDiaryList(@PathVariable(value = "searchWord")String searchWord,
			@PathVariable(value = "page")String page) {
		ModelAndView mv = new ModelAndView();
		HashMap hash = new HashMap();
		searchWord = searchWord.replace(" ", "");
		hash.put("page", Integer.parseInt(page)*10);
		if(!searchWord.equals("all")) {
			hash.put("searchWord", searchWord);
			mv.addObject("search",searchWord);
		}
		List<DairyVO> list = adminService.getDiary(hash);
		mv.addObject("list", list);
		mv.setViewName("admin/adminUser");
		return mv;
	}
}
