package com.kosmo.bangdairy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.MovieDetailService;
import com.kosmo.bangdairy.vo.MovieVO;

@Controller
public class MovieDetailController {
	
	@Autowired
	MovieDetailService movieDetailService;
	@RequestMapping(value ="detail" , method = RequestMethod.GET)
	public ModelAndView movieDetail(@RequestParam(value = "movieId",required = true)String movieId) {
		ModelAndView mv = new ModelAndView();
		MovieVO vo = new MovieVO();
		vo.setMovieId(movieId);
		vo = movieDetailService.selectOneMovie(vo);
		LoggerAspect.logger.info("movieDetail 결과 vo : "+vo);
		if(vo!=null) {
			mv.addObject("vo",vo);
		}
		mv.setViewName("movieDetail/movieDetail");
		return mv;
	}
}
