package com.kosmo.bangdairy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.AdminService;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.QnaVO;

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
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
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
	 * 메소드 명 		: getList
	 * 기능			: 어드민 페이지에 리스트를 페이지 수에 맞게 띄워준다
	 * 						searchWord가 all이 아니면 들어온 값으로 시작하는 검색조건으로 시작하는
	 * 						리스트를 띄워준다
	 * 						type = movie,user,diary,comment,qna
	 * 변수			: type,searchWord, page
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/{type}/{searchWord}/{page}",method = RequestMethod.POST)
	public ModelAndView getList(@PathVariable(value = "type")String type,
			@PathVariable(value = "searchWord")String searchWord,
			@PathVariable(value = "page")String page) {
		ModelAndView mv = new ModelAndView();
		HashMap hash = new HashMap();
		searchWord = searchWord.replace(" ", "");
		hash.put("page", Integer.parseInt(page)*10);
		if(!searchWord.equals("all")) {
			hash.put("searchWord", searchWord);
			mv.addObject("search",searchWord);
		}
		List list = null;
		switch (type) {
			case "movie":
				list = adminService.getMovie(hash);
				mv.setViewName("admin/adminMovie");
				break;
			case "user":
				list = adminService.getUser(hash);
				mv.setViewName("admin/adminUser");
				break;
			case "diary":
				list = adminService.getDiary(hash);
				mv.setViewName("admin/adminDiary");
				break;
			case "comment":
				list = adminService.getComment(hash);
				mv.setViewName("admin/adminComment");
				break;
			case "qna":
				 list = adminService.getQna(hash);
				mv.setViewName("admin/adminQna");
				break;
			case "indie":
				 list = adminService.getIndieList(hash);
				 LoggerAspect.logger.info("IndieList : "+list);
				mv.setViewName("admin/adminIndie");
				break;
			default:
				break;
		}
		mv.addObject("list", list);
		return mv;
	}
	/*
	 * 메소드명		: updateQnaAnswer
	 * 기능			: 입력한 답변을 db에 update
	 * 변수			: QnaVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/qna/answer",method = RequestMethod.POST)
	public int updateQnaAnswer(QnaVO vo) {
		vo.setQnaStatus(1);
		int result =adminService.updateQnaAnswer(vo);
		return result;
	}
	/*
	 * 메소드명		: getQnaAnswer
	 * 기능			: 입력된 답변을 리턴
	 * 변수			: QnaVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/qna/answer/get",method = RequestMethod.POST,
			produces = "application/text; charset=utf8")

	public String getQnaAnswer(QnaVO vo) {
		QnaVO qvo =adminService.getQnaAnswer(vo);
		System.out.println(qvo);
		return qvo.getQnaAnswer();
	}
	/*
	 * 메소드명		: getIndieOne
	 * 기능			: 저장된 인디영화의 정보를 html로 띄워줌
	 * 변수			: IndieVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/indie/show",method = RequestMethod.POST)
	public ModelAndView getIndieOne(IndieVO vo) {
		IndieVO ivo = adminService.getIndieOne(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", ivo);
		mv.setViewName("admin/indieInfo");
		return mv;
	}
	/*
	 * 메소드명		: updateIndieConfirm
	 * 기능			: 인디 영화의 허가 여부를 바꾼다
	 * 변수			: IndieVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/indie/confirm",method = RequestMethod.POST)
	public int updateIndieConfirm(IndieVO vo) {
		int result = adminService.updateIndieConfirm(vo);
		return result;
	}
	
}
