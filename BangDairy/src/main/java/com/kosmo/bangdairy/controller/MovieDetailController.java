package com.kosmo.bangdairy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.MovieDetailService;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

@Controller
public class MovieDetailController {
	
	@Autowired
	MovieDetailService movieDetailService;
	/*
	 * 메소드명	: movieDetail
	 * 기능		: 클릭한 영화의 정보를 보여줌
	 * 변수 		: movieId
	 * 작성자		: 박윤태
	 */
	@RequestMapping(value ="detail" , method = RequestMethod.GET)
	public ModelAndView movieDetail(@RequestParam(value = "movieId",required = true)String movieId) {
		ModelAndView mv = new ModelAndView();
		MovieVO vo = new MovieVO();
		vo.setMovieId(movieId);
		vo = movieDetailService.selectOneMovie(vo);
		LoggerAspect.logger.info("movieDetail 결과 vo : "+vo);
		List<StillVO> stillList = null;
		if(vo!=null) {
			mv.addObject("vo",vo);
			stillList = movieDetailService.selectStill(vo);
		}
		if(stillList !=null) {
			mv.addObject("sList",stillList);
		}
		LoggerAspect.logger.info("stillImg 결과 list : "+stillList);
		mv.setViewName("movieDetail/movieDetail");
		return mv;
	}
	/*
	 * 메소드명	: movieComment
	 * 기능		: 영화의 코멘트들을 Ajax으로 가져옴 ResponseBody
	 * 변수 		: movieId, pageNum
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "detail/{movieId}/commant/{pageNum}", method = RequestMethod.POST,
	produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public ModelAndView movieComment(@PathVariable(value = "movieId", required = true)String movieId,
			@PathVariable(value = "pageNum")String PageNum) {
		List<CommentVO> list = movieDetailService.selectComments(PageNum, movieId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("movieDetail/commentPart");
		return mv;
	}
	/*
	 * 메소드명	: insertComment
	 * 기능		: 영화의 코멘트 추가
	 * 변수 		: CommentVO , session, file
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "comment/insert",method = RequestMethod.POST)
	public int insertComment(CommentVO vo,HttpSession session,
			@RequestParam("file") MultipartFile file) {
		LoggerAspect.logger.info(file);
		if(file==null&&file.isEmpty()) {
			vo.setReceipt(0);
		}else {
			//TODO 파일 입력시 google vision api 로 넘겨서 영화 이름이 있는지 확인해야 함
			if(file.getSize()==0) {
				vo.setReceipt(0);
			}
			else vo.setReceipt(1);
		}
		vo.setUserId((String)session.getAttribute("userId"));
		int result =movieDetailService.insertComment(vo);
		LoggerAspect.logger.info(vo);
		return result;
	}
	/*
	 * 메소드명	: commentCount
	 * 기능		: 영화의 코멘트 세기
	 * 변수 		: movieId
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "comment/count/{movieId}",method = RequestMethod.POST,
	produces = "application/x-www-form-urlencoded;charset=UTF-8")
	public String commentCount(@PathVariable(value = "movieId",required = true)String movieId) {
		return movieDetailService.commentCount(movieId)+" Comments";
	}
	/*
	 * 메소드명	: addWish
	 * 기능		: 영화를 wish리스트에 추가
	 * 변수 		: movieId
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "detail/addWish",method = RequestMethod.POST)
	public int addWish(@RequestParam(value = "movieId",required = true)String movieId,HttpSession session) {
		WishMovieVO vo = new WishMovieVO();
		String userId = (String)session.getAttribute("userId");
		vo.setUserId(userId);
		vo.setMovieId(movieId);
		return movieDetailService.insertWishMovie(vo);
	}
}
