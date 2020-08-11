package com.kosmo.bangdairy.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.kosmo.bangdairy.service.MovieDetailService;
import com.kosmo.bangdairy.service.WordCloudService;
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
	@Autowired
	WordCloudService wordCloudService;
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
		
		float detailStarScore = movieDetailService.selectDetailStarScore(vo);	// 영화 평점 얻어오기
		
		LoggerAspect.logger.info("movieDetail 결과 vo : "+vo);
		List<StillVO> stillList = null;
		if(vo!=null) {
			mv.addObject("vo",vo);
			wordCloudService.getWordCloud(vo);
			stillList = movieDetailService.selectStill(vo);
		}
		
		if(detailStarScore != 0) {
			mv.addObject("starScore", detailStarScore);
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
				try {
					byte []fileByte = file.getBytes(); // file을 배열로 바꿔 fileByte에 저장
					
					File file_with_driver = new File(file.getOriginalFilename());
					file_with_driver.createNewFile();
					FileOutputStream fos = new FileOutputStream(file_with_driver);
					fos.write(file.getBytes());
					fos.close();
				} catch (IllegalStateException | IOException e) {
					LoggerAspect.logger.error("파일 transfer 오류 :" + e.getMessage());
					vo.setReceipt(0);
				}
				String host = "192.168.0.22"; //서버의 주소
				int port =  8765; 					//소켓의 포트
				Socket soc=null;
				BufferedReader br=null;
				BufferedOutputStream bos=null;
				FileInputStream fin=null;
				try {
					//TODO
					soc = new Socket(host,port);
					br = new BufferedReader(new InputStreamReader(soc.getInputStream()));

					bos = new BufferedOutputStream(soc.getOutputStream());
					fin = new FileInputStream(file.getOriginalFilename());
					
					int max_title_length = 4;
					bos.write("1".getBytes());
		            int title_length = mvo.getMovieTitle().getBytes().length;
		            bos.write(Integer.toString(title_length).getBytes());
		            
		            if (max_title_length - Integer.toString(title_length).getBytes().length !=0 ) {
		            	for(int i=0; i< max_title_length-Integer.toString(title_length).getBytes().length; i++) {
		            		System.out.println(i);
		            		bos.write(" ".getBytes());
		            	}
		            }
		            bos.write(mvo.getMovieTitle().getBytes());
		            //이미지 시작
		            int max_img_length = 128;
		            long img_length = file.getBytes().length;
		            bos.write(Long.toString(img_length).getBytes());
		            if (max_img_length - Long.toString(img_length).getBytes().length !=0 ) {
		            	for(int i=0; i< max_img_length-Long.toString(img_length).getBytes().length; i++) {
		            		bos.write(" ".getBytes());
		            	}
		            }
		            
					byte[] buf = new byte[10240];
		            int read = 0;
	                while((read=fin.read(buf, 0, buf.length))!=-1){
	                    bos.write(buf,0,read);
	                    bos.flush();
	                }
	                
	                
	                //결과값 받기
	                String rev;
					rev = br.readLine();
					vo.setReceipt(Integer.parseInt(rev));
					
					
				}catch (Exception er) {
					LoggerAspect.logger.error("파일 송신 오류 :" + er.getMessage());
					vo.setReceipt(0);
				}finally {
					try {
						fin.close();
						bos.close();
						br.close();
						soc.close();
					}catch (Exception e) {
						LoggerAspect.logger.error("Client Close Error :" + e.getMessage());
					}
				}

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
	 * 메소드명	: getWordCloud
	 * 기능		: 워드클라우드에 필요한 데이터 리턴
	 * 변수 		: movieId
	 * 작성자		: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "detail/wordcloud/{movieId}",method = RequestMethod.POST)
	public List<Map<String, Object>> getWordCloud(@PathVariable(value = "movieId",required = true)String movieId) {
		MovieVO vo = new MovieVO();
		vo.setMovieId(movieId);
		return wordCloudService.getWordCloud(vo);
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
