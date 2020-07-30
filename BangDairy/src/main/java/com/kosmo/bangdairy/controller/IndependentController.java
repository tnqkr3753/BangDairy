package com.kosmo.bangdairy.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.AccountFormServiceImpl;
import com.kosmo.bangdairy.service.IndieSevice;
import com.kosmo.bangdairy.service.IndieSeviceImpl;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.ReviewVO;

@Controller
public class IndependentController {
	
	@Autowired
	private IndieSeviceImpl indieSevice;
	/*
	 * 메소드명	: movieAppImsert
	 * 기능		: header에서 신청페이지로 넘어가고 장르에 값을 넣어줌
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@RequestMapping(value="/Independent", method=RequestMethod.GET)
	public ModelAndView movieAppImsert(HttpServletRequest request ){ 
		ModelAndView mv = new ModelAndView();
		
		List<IndieVO> result=indieSevice.indieGnareSelect();
		System.out.println("=====================================================================================================");
		System.out.println(result);
//		result 에 넣어진 을 addObject로 키값을"result" value값은 result 로 만들어준다.
		mv.addObject("result", result);
		mv.setViewName("indie/Independent");
		return mv;}
	
	
	/*
	 * 메소드명	: indieList
	 * 기능		: header에서 인디리트트페이지로 넘어감
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@RequestMapping(value="/indieList", method=RequestMethod.GET)
	public ModelAndView indieList() {	ModelAndView mv = new ModelAndView();mv.setViewName("indie/listIndie");return mv;}
	
	/*
	 * 메소드명	: indieDetail
	 * 기능		: header에서 인디디테일로 넘어감
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@RequestMapping(value="/indieDetail", method=RequestMethod.GET)
	public ModelAndView indieDetail() {	ModelAndView mv = new ModelAndView();	mv.setViewName("indie/indieDetail");return mv;}
	
	/*
	 * 메소드명	: movieAppImsert
	 * 기능		: 인디영화 신청을 insert함
	 * 변수 		: 
	 * 작성자		: 신진섭
	 */
	@RequestMapping(value="indieinsert", method=RequestMethod.GET)
	public ModelAndView indieInsert(IndieVO ivo ) {	
		indieSevice.indieInsert(ivo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("indie/listIndie");
		return mv;
	}

	
}
	
	
	/*
	 * @RequestMapping(value="indieinsert", method=RequestMethod.GET) public
	 * ModelAndView indieGnareSelect(IndieVO ivo, HttpServletRequest request ) {
	 * 
	 * indieSevice.indieInsert(ivo);
	 * 
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * mv.setViewName("indie/listIndie");
	 * 
	 * return mv; }
	 * 
	 * 
	 * }
	 */
