package com.kosmo.bangdairy.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	@RequestMapping(value="/Independent" ,method=RequestMethod.GET)
	public ModelAndView movieAppImsert(){ 
		ModelAndView mv = new ModelAndView();
		List<IndieVO> result=indieSevice.indieGnareSelect();
//		result 에 넣어진 을 addObject로 키값을"result" value값은 result 로 만들어준다.
		mv.addObject("result", result);
		mv.setViewName("indie/Independent");
		return mv;
		}

	/*
	 * 메소드명	: indieList
	 * 기능		: header에서 인디리트트페이지로 넘어감, 인디리스트에 뿌려줄 값을 DB에서 얻어온다.
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@RequestMapping(value = {"/indieList"})
	public ModelAndView indieList() {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("indie/listIndie");
	return mv;
	}
	
	/*
	 * 메소드명	: listIndie2
	 * 기능		: 페이지를 넘김
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@ResponseBody
	@RequestMapping(value = "listIndie2/{pNum}/{searchWord}", method = RequestMethod.GET)
	public ModelAndView indieListPaging(@PathVariable(value = "pNum", required = true) String pageNum,
			@PathVariable(value = "searchWord",required = true)String searchWord) {
		ModelAndView mv = new ModelAndView(); 
		int pNum = Integer.parseInt(pageNum); // 현재 선택한 페이지 번호 받아와서 형 변환
		mv.addObject("result",indieSevice.selectIndiepaging(pNum,searchWord));
		mv.addObject("totalPage",indieSevice.selectTotalCount(searchWord)); 
		mv.addObject("pNum", pNum);
		mv.addObject("searchWord",searchWord);
		mv.setViewName("indie/listIndie2");
		
		return mv;
	}
	
	
	
	
	/*
	 * 메소드명	: goodId
	 * 기능		: 좋아요를 1 증가시킴 
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@ResponseBody
	@RequestMapping(value = "goodId/{goodId}", method = RequestMethod.GET)
	public ModelAndView goodId( HttpSession session,@PathVariable(value = "goodId", required = true) String goodId) {
		System.out.println("-------------------------------------------------------------)))))))))))))))");
	ModelAndView mv = new ModelAndView(); 
		String userId =(String)session.getAttribute("userId");
		System.out.println(userId);
		System.out.println(goodId);
		int indieId = Integer.parseInt(goodId);                 // 현재 선택한 페이지 번호 받아와서 형 변환
		
		int hateNum=indieSevice.selectHateNum(indieId,userId);        
		int like= indieSevice.selectEqulegood(indieId,userId);  //인서트 해온게 1이면 값이 있고  hate가 1인거임  그러면 값을 업데이트해줌

	
		System.out.println(hateNum);
		System.out.println(like);
		
		if (hateNum==0) {                                          //인서트해온게 널이면  값을 인서트해줌
			indieSevice.goodInsert(indieId,userId);
		}
		else if (hateNum==1 && like==1) {
			 indieSevice.updateLike(indieId,userId); 
		System.out.println("넘겨야할4 인디 아이디" + indieId);
		System.out.println("like가 0이고 hate가 1 그러므로 값을 update해야함"+like);
		 }

		mv.addObject("indieId", indieId);
		
		 mv.setViewName("indie/indieDetail");
		 return mv;
		/*
		 * mv.addObject("result"); mv.setViewName("indie/listIndie2");
		 */
			// 전체 페이지 수 구하기

//		return mv;
	}


	/*
	 * 메소드명	: goodId
	 * 기능		: 싫어요를 1 증가시킴 
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@ResponseBody
	@RequestMapping(value = "badId/{badId}", method = RequestMethod.GET)
	public ModelAndView badId( IndieVO ivo,HttpSession session,@PathVariable(value = "badId", required = true) String badId) {
		System.out.println("-------------------------------------------------------------)))))))))))))))");
		ModelAndView mv = new ModelAndView(); 
		String userId =(String)session.getAttribute("userId");
		
		System.out.println(userId);
		System.out.println(badId);
		int indieId = Integer.parseInt(badId);                 // 현재 선택한 페이지 번호 받아와서 형 변환
		int likeNum=indieSevice.selectLikeNum(indieId,userId); 

		
	
		int hate= indieSevice.selectEqulebad(indieId,userId);  //인서트 해온게 1이면 값이 있고  hate가 1인거임  그러면 값을 업데이트해줌
		System.out.println(likeNum);
		System.out.println(hate);
		
		if (likeNum==0) {                                          //인서트해온게 널이면  값을 인서트해줌
			indieSevice.badInsert(indieId,userId);
		}
		else if (likeNum==1 && hate==1) {
			 indieSevice.updateHate(indieId,userId); 
		System.out.println("넘겨야할4 인디 아이디" + indieId);
		System.out.println("like가1이고 hate가 0 그러므로 값을 update해야함"+hate);
		 }
//		 mv.addObject("result2",result);

		mv.addObject("indieId", indieId);
		 mv.setViewName("indie/indieDetail");
		 return mv;
	}
	/*
	 * 메소드명	: indieDetail
	 * 기능		: indielist 에서 인디디테일로 넘어감
	 * 변수 		:
	 * 작성자		: 신진섭
	 */
	@RequestMapping(value = "indieDet" )
	public ModelAndView indieDetail(HttpSession session, IndieVO ivo ,@RequestParam(required = true,value = "indieid")int indieId ) {
		ModelAndView mv = new ModelAndView();	
		String userId =(String)session.getAttribute("userId");
		ivo.setIndieId(indieId);
		
		IndieVO result22 = indieSevice.selectIndieDetail(ivo);
		int likeCount=indieSevice.selectLikeCount(indieId);
		int hateCount=indieSevice.selectHateCount(indieId);
		System.out.println("________________________________________________________________________________________________________________");
		System.out.println(likeCount);
		mv.addObject("userId",userId);
		mv.addObject("result",result22);
		mv.addObject("likeCount", likeCount);
		mv.addObject("hateCount", hateCount);
		mv.setViewName("indie/indieDetail");
		return mv;
		}
	/*
	 * 메소드명	: movieAppImsert
	 * 기능		: 인디영화 신청을 insert함
	 * 변수 		: 
	 * 작성자		: 신진섭
	 */
		@RequestMapping(value = "indieinsert", method=RequestMethod.POST )
	public ModelAndView indieInsert(HttpSession session,IndieVO ivo){	
		String id = (String) session.getAttribute("userId");
		ivo.setApplicant(id);
		indieSevice.indieInsert(ivo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/indieList");
		return mv;
	   }
}
	
