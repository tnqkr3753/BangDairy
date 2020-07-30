package com.kosmo.bangdairy.controller;

import java.util.HashMap;
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
import com.kosmo.bangdairy.service.SearchService;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Controller
public class SearchController {
	@Autowired
	SearchService searchService;
	
	String searchWord; // 검색어
	List<HashMap> list; // 영화 정보 담을 리스트
	
	/* 메소드명 : searchMovie
	 * 기능 : 오른쪽 상단의 검색창에 검색어 입력하면 영화 리스트 페이지로 넘겨줌
	 * 변수 : searchWord
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView searchMovie(@RequestParam(value="movieSearch") String searchWord) {
		MovieVO vo = new MovieVO();
		
		this.searchWord = searchWord; // 검색어

		LoggerAspect.logger.info("searchController title : " + searchWord);
		
		ModelAndView mv = new ModelAndView();

		MovieVO mvo = new MovieVO();
		
		LoggerAspect.logger.info(list);
		
		mv.setViewName("movieList/movieList"); // movieList 페이지로 넘김
		
		return mv;
	}
	
	
	/* 메소드명 : searchBy
	 * 기능 : 영화 리스트 페이지에서 라디오 버튼 클릭하면 해당 기준(+검색어)에 맞는 영화 리스트 보여줌, 페이징
	 * 변수 : tabName, pageNum
	 * 작성자 : 배은주
	 */
	@ResponseBody
	@RequestMapping(value = "searchBy/{tabName}/{pNum}", method = RequestMethod.POST)
	public ModelAndView searchBy(@PathVariable(value = "tabName", required = true) String tabName,
			@PathVariable(value = "pNum", required = true) String pageNum) {
		
		ModelAndView mv = new ModelAndView(); 
		
		int pNum = Integer.parseInt(pageNum); // 현재 선택한 페이지 번호 받아와서 형 변환
		
		System.out.println("***** 현재 내가 선택한 페이지 번호 ***** : " + pNum);
				
		MovieVO mvo = new MovieVO();
		DirectorVO dvo = new DirectorVO();
		ActorVO avo = new ActorVO();
		
		mv.setViewName("movieList/searchTab");
		
		int totalPage;	// 전체 페이지 수
		
		if (tabName.contains("Title")) {						 // "Title" 라디오 버튼을 클릭했을 때			
			mvo.setMovieTitle(searchWord);
			
			totalPage = searchService.searchCountTitle(mvo);	// 전체 페이지 수 구하기
			
			System.out.println("***** 전체 페이지수 확인 ***** : " + totalPage);

			mv.addObject("pNum", pNum);
			mv.addObject("totalPage", totalPage);
			mv.addObject("mList", searchService.searchMovie(mvo, pNum));
		} else if (tabName.contains("Director")) { 				// "Director" 라디오 버튼을 클릭했을 때	
			System.out.println(tabName+"-----"+pNum+"-----확인1");
			dvo.setDirectorName(searchWord);	
			System.out.println(tabName+"-----"+pNum+"-----확인2");

			totalPage = searchService.searchCountDirector(dvo);

			mv.addObject("pNum", pNum);
			mv.addObject("totlaPage", totalPage);
			mv.addObject("mList", searchService.searchDirector(dvo, pNum));
		}  else if (tabName.contains("Actor")) { 				// "Actor" 라디오 버튼을 클릭했을 때	
			avo.setActorName(searchWord);
			
			totalPage = searchService.searchCountActor(avo);
			
			mv.addObject("pNum", pNum);
			mv.addObject("totalPage", totalPage);
			mv.addObject("mList", searchService.searchActor(avo, pNum));
		}  else if (tabName.contains("Keywords")) {		 		// "Keywords" 라디오 버튼을 클릭했을 때
			mvo.setKeyword(searchWord);
			
			totalPage = searchService.searchCountKeywords(mvo);
			
			mv.addObject("pNum", pNum);
			mv.addObject("totalPage", totalPage);
			mv.addObject("mList", searchService.searchKeywords(mvo, pNum));
		}

		return mv;
	}
}