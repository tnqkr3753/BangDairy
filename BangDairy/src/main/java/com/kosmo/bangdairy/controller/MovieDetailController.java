package com.kosmo.bangdairy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.MovieDetailService;
import com.kosmo.bangdairy.vo.CommentVO;
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
	@ResponseBody
	@RequestMapping(value = "detail/{movieId}/commant/{pageNum}", method = RequestMethod.POST)
	public ModelAndView movieComment(@PathVariable(value = "movieId", required = true)String movieId,
			@PathVariable(value = "pageNum")String PageNum) {
		List<CommentVO> list = movieDetailService.selectComments(PageNum, movieId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("movieDetail/commentPart");
		return mv;
	}
	
}
