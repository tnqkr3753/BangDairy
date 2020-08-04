package com.kosmo.bangdairy.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.util.ArrayList;
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
	BufferedOutputStream sender;
	Socket soc;
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
			LoggerAspect.logger.info("else 진입");
//			if(file.getSize()!=0) {
				MovieVO mvo = new MovieVO();
				mvo.setMovieId(vo.getMovieId());
				mvo = movieDetailService.selectOneMovie(mvo); //movie 이름을 가져오기 위해 db에 갔다옴
				byte[] fileByte = null; //파일의 byte를 담을 배열
				try {
					fileByte = file.getBytes(); // file을 배열로 바꿔 fileByte에 저장
				} catch (IllegalStateException | IOException e) {
					LoggerAspect.logger.error("파일 transfer 오류 :" + e.getMessage());
					vo.setReceipt(0);
				}
				String host = "192.168.0.22"; //서버의 주소
				int port =  8765; 					//소켓의 포트
				LoggerAspect.logger.info(fileByte.length);
				try {
					//TODO
					soc = new Socket(host,port);
					sender = new BufferedOutputStream(soc.getOutputStream());
					InputStream receiver = soc.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(receiver));
					
							// 타입 보내기
//							ByteBuffer b = ByteBuffer.allocate(4);
//							b.order(ByteOrder.LITTLE_ENDIAN);
//							b.putInt(1);
					PrintWriter pw = new PrintWriter(soc.getOutputStream());
					pw.write(1);
					pw.write(mvo.getMovieTitle());
					pw.write(fileByte.length);
					pw.close();
//					sender.write("1".getBytes());
//					sender.flush();
//					sender.write(((Integer.toString(mvo.getMovieTitle().getBytes().length)).getBytes()));
//					sender.flush();
//					sender.write(b);
//							b.order(ByteOrder.LITTLE_ENDIAN);
//							b.putInt(mvo.getMovieId().getBytes().length);

//					OutputStreamWriter osw = new OutputStreamWriter(sender, "UTF-8");
//					osw.write(mvo.getMovieTitle());
//					osw.flush();
					//
					BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
//					sender.write((mvo.getMovieTitle()).getBytes());
//					sender.flush();
//							b.clear();
//							b.order(ByteOrder.LITTLE_ENDIAN);
//							b.putInt(fileByte.length);
//							sender.write(Integer.toString(fileByte.length).getBytes());
//							sender.flush();
							sender.write(fileByte); //배열 말고 ByteBuffer에 넣어서 ㄱㄱㄱ
							sender.flush();
					close();
				}catch (Exception er) {
					LoggerAspect.logger.error("파일 송신 오류 :" + er.getMessage());
					vo.setReceipt(0);
				}
//			}
//			else vo.setReceipt(0);
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
	@RequestMapping(value = "comment/count/{movieId}",method = RequestMethod.POST)
	public int commentCount(@PathVariable(value = "movieId",required = true)String movieId) {
		return movieDetailService.commentCount(movieId);
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
	public void close() {
		try {
		sender.close();
		soc.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
