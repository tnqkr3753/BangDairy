package com.kosmo.bangdairy.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		mv.addObject("title","평점 높은 영화");
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
	public ModelAndView getActorMovieWithWish(HttpSession session,
			HttpServletResponse response) {
		String userId = (String)session.getAttribute("userId");
		HashMap hash = new HashMap();
		hash.put("userId", userId);
		ActorVO avo = indexService.getActorMovieWithWish(hash);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index/moviebar");
		List<MovieVO> mvo = null;
		if(avo!=null) { //위시리스트에 영화가 없거나 배우가 없을 때
			mvo = indexService.getMovieWithActor(avo);
			for (int i = 0;mvo.size()<5&& i <= 5; i++) { //추천이 작으면 최대 5번 반복
				if(i==5) { //5번 반복을 해도 size가 5가 넘지 않을 때
					mvo = null;
				}
				avo = indexService.getActorMovieWithWish(hash);
				mvo =  indexService.getMovieWithActor(avo);
			}
			if(mvo.size()<5) { //사이즈가 작을 때
				mv.addObject("title","평점 높은 영화");
				mv.addObject("list", mvo);
			}else { //영화가 있을 때
				mv.addObject("title",avo.getActorName()+" 배우의 다른 작품들");
				mv.addObject("list", mvo);
			}
		}else { // 위시리스트에 영화가 없거나 배우가 없을 때
			mvo = indexService.getMovieAsScore();
			mv.addObject("title","평점 높은 영화");	
			mv.addObject("list", mvo);
		}
		return mv;
	}
	/*
	 * 메소드명 		: getMovieWithUserGenre
	 * 기능 			: 유저가 남긴 평점 줌 평균이 높은 장르의 영화 중 조회수가 높은 영화 중 내가 보지 않은 영화
	 * 변수 			: Session
	 * 작성자 			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "getm/scoregenre", method = RequestMethod.POST)
	public ModelAndView  getMovieWithUserGenre(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		AccountFormVO vo = new AccountFormVO();
		List<MovieVO> list = null;
		if(userId !=null) {
			vo.setUserId(userId);
			list =indexService.getMovieWithUserGenre(vo);
		}
		ModelAndView mv = new ModelAndView();
		if(list.size()<5) { //표본이 작을 땐 인기 장르를 끌어온다
			HashMap hash = new HashMap();
			GenreVO gvo = indexService.getHitsAsGenre().get(0);
			
			hash.put("genreId", gvo.getGenreId());
			list = indexService.getMovieWithGenre(hash);
			mv.addObject("title", indexService.getGenreTitle(hash).getGenreTitle());
		}else {
			mv.addObject("title", userId+"님이 보지 않으신 좋아하실만한 영화");
		}
		mv.addObject("list", list);
		mv.setViewName("index/moviebar");
		return mv;
	}
	/*
	 * 메소드명 : getRecommender
	 * 기능 : 사용자의 정보를 기반으로 다음으로 볼 추천 영화 리스트를 페이지에 반환한다.
	 * 변수 : session
	 * 작성자 : 이경호
	 */
	@RequestMapping(value = "getm/recommender",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getRecommender(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		ArrayList<MovieVO> list = null;
		ArrayList<MovieVO> recommend_list = null;
		if (userId != null) {
			//접속한 유저가 평점을 매긴 영화 리스트 가져온다.
			List<MovieVO> title_list =  indexService.getUserMovies(userId);
			
			System.out.println("리스트 갯수:"+title_list.size());
			//소켓 연결 및 소켓을 통해 영화 추천리스트 받아오기
			String HOST = "192.168.0.22";
			int PORT = 8765;
			Socket socket=null;
			BufferedOutputStream bos=null;
			BufferedReader in = null;
			try {
				//파이썬과 통신시 한번에 보낼 수 있는 최대 바이트 수 9999까지 수용 가능
				int max_title_length = 4;
				//파이썬과 통신시 한번에 보낼 수 최대 리스트 사이즈 9999까지 수용 가능
				int max_list_size = 4;
				socket = new Socket(HOST,PORT);
				System.out.println("클라이언트 접속");
				bos = new BufferedOutputStream(socket.getOutputStream());
				
				//쓰기, 파이썬 서버에 사용할 메소드 번호를 먼저 보낸다
				System.out.println("소켓 사전 준비 완료");
				bos.write("2".getBytes());
				bos.flush();
				System.out.println("메소드 선택 인자 전송 완료");
				
				bos.write(userId.getBytes());
				if (30-userId.getBytes().length!=0) {
					for(int i=0; i<30-userId.getBytes().length;i++) {
						bos.write(" ".getBytes());
					}
				}
				bos.flush();
				
				bos.write(Integer.toString(title_list.size()).getBytes());
				bos.flush();
				//리스트의 사이즈를 바이트로 변환 후 바이트의 길이
				int list_byte_size = Integer.toString(title_list.size()).getBytes().length;
				if (max_list_size - list_byte_size != 0) {
					//부족한 바이트 수만큼 공백을 보낸다.
					for (int i=0; i< max_list_size-list_byte_size;i++) {
						bos.write(" ".getBytes());
					}
				}
				System.out.println("리스트 크기 정상 전송");
				bos.flush();
				//리스트에서 하나씩 영화이름을 소켓으로 전송
				for (MovieVO vo : title_list) {
					//아이디 길이 = 6
					bos.write(vo.getMovieId().getBytes());
				}
				bos.flush();
//				읽기
				
				System.out.println("읽기 모드");
				in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
		
				list = new ArrayList<MovieVO>();
				String rev;
				while((rev=in.readLine())!=null) {
					
					System.out.println("받음:"+rev);
					MovieVO vo = new MovieVO();
					vo.setMovieId(rev);
					list.add(vo);
				}
				
				
				
			}catch (Exception e) {
				System.out.println("소켓 통신 오류:"+e.getMessage());
			}finally {
				try {
					in.close();
					bos.close();
					socket.close();
					System.out.println("소켓 정상 종료");
					
					recommend_list = (ArrayList<MovieVO>) indexService.getRecommendedMovieDetail(list);
					
				}catch (Exception e) {
					System.out.println("소켓 클로즈 오류:"+e.getMessage());
				}
			}
		}
		
		ModelAndView mv = new ModelAndView();
		if(recommend_list!=null) {
			mv.addObject("title", userId+"님 에게 추천하는 영화");
		}else {
			mv.addObject("title","영화에 대한 평점을 입력해주세요");
		}
		mv.addObject("list", recommend_list);
		mv.setViewName("index/moviebar");
		LoggerAspect.logger.info(recommend_list);
		return mv;
	}
	
}
