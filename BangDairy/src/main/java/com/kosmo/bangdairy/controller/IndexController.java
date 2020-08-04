package com.kosmo.bangdairy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.mapping.ParameterMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.AccountFormServiceImpl;
import com.kosmo.bangdairy.service.IndexService;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Controller
public class IndexController {
	@Autowired
	IndexService indexService;
	
	/*
	 * 메소드명 		: getMovieWithScore
	 * 기능 			: 평점 높은 순으로 정렬해서 영화들을 index에 띄워줌
	 * 변수 			: 
	 * 작성자 			: 박윤태
	 */
	@RequestMapping(value = "/getm/score", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMovieWithScore() {
		List<MovieVO> list = indexService.getMovieAsScore();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index/moviebar");
		mv.addObject("title","평점 높은 순");
		mv.addObject("list", list);
		return mv;
	}
	/*
	 * 메소드명 		: getHitsWithGenre
	 * 기능 			: 조회수가 많은장르들을 json으로 보냄
	 * 변수 			: Null
	 * 작성자 			: 박윤태
	 */
	@RequestMapping(value = "/getm/hits",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getHitsWithGenre() {
		List<GenreVO> gList = indexService.getHitsAsGenre();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i  < gList.size() ; i++) {
			map.put(String.valueOf(i), gList.get(i).getGenreId());
		}
		LoggerAspect.logger.info("map : "+map);
		return map;
	}
	/*
	 * 메소드명 		: getMovieWithGenre
	 * 기능 			: 장르별 상위 10개의 영화를 가져와 html로 만듬
	 * 변수 			: GenreId
	 * 작성자 			: 박윤태
	 */
	@RequestMapping(value = "/getm/genre/{genreId}",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getMovieWithGenre(@PathVariable(value = "genreId") String genreId) {
		HashMap hash = new HashMap();
		hash.put("genreId", genreId);
		List<MovieVO> mList = indexService.getMovieWithGenre(hash);
		GenreVO vo = indexService.getGenreTitle(hash);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index/moviebar");
		mv.addObject("title",vo.getGenreTitle());
		mv.addObject("list", mList);
		return mv;
	}
	/*
	 * 메소드명 		: getSessionId
	 * 기능 			: 유저 세션을 확인해 true , false를 리턴
	 * 변수 			: Session
	 * 작성자 			: 박윤태
	 */
	@RequestMapping(value = "/check/session",method = RequestMethod.POST)
	@ResponseBody
	public boolean getSessionId(HttpSession session) {
		String id = (String)session.getAttribute("userId");
		if(id == null) return false;
		else return true;
	}
	/*
	 * 메소드명 		: getActorMovieWithWish
	 * 기능 			: 위시리스트에 최근에 넣은 3개의 영화에 출연한 배우 중 랜덤 한명이 출연한 작품들의 목록을 띄워줌
	 * 변수 			: Session
	 * 작성자 			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "getm/wish", method = RequestMethod.POST)
	public ModelAndView getActorMovieWithWish(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		HashMap hash = new HashMap();
		hash.put("userId", userId);
		ActorVO avo = indexService.getActorMovieWithWish(hash);
		List<MovieVO> mvo = indexService.getMovieWithActor(avo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index/moviebar");
		mv.addObject("title",avo.getActorName()+" 배우의 다른 작품들");
		mv.addObject("list", mvo);
		return mv;
	}
	/*
	 * 메소드명 		: getActorMovieWithWish
	 * 기능 			: 위시리스트에 최근에 넣은 3개의 영화에 출연한 배우 중 랜덤 한명이 출연한 작품들의 목록을 띄워줌
	 * 변수 			: Session
	 * 작성자 			: 박윤태
	 */
//	@ResponseBody
//	@RequestMapping(value = "getm/wish", method = RequestMethod.POST)
//	public 
	
}
