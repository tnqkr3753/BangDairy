package com.kosmo.bangdairy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.DairyServicelmpl;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Controller
public class DairyController {

	@Autowired
	DairyServicelmpl dairyService;
	

	@RequestMapping(value = "mydairy")
	public ModelAndView my_dairy() {
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView");
		mv.setViewName("diary/my_dairy");
		return mv;
	}
	
	@RequestMapping(value = "listdairy")
	public ModelAndView showList(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");
		AccountFormVO vo= new AccountFormVO();
		vo.setUserId(userId);
		List<DairyVO> list = dairyService.showList(vo);

		
		mv.addObject("listdairy", list);
		mv.setViewName("diary/my_dairy");
		return mv;
	}
	
	@RequestMapping(value = "writedairy")
	public ModelAndView write_dairy() {
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView");
		mv.setViewName("diary/write_dairy");
		return mv;
	}
	
	@RequestMapping(value = "maindairy")
	public ModelAndView main_dairy() {
		ModelAndView mv = new ModelAndView();
		System.out.println("ModelAndView");
		mv.setViewName("diary/main_dairy");
		return mv;
	}
	
	@RequestMapping(value ="insertrecentdairy")
	public ModelAndView recentDairy(HttpSession session) throws Exception { 
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");
		AccountFormVO vo= new AccountFormVO();
		vo.setUserId(userId);
		List<DairyVO> result = dairyService.recentDairy(vo);
		mv.addObject("recentdairy", result);
		
		List<DairyVO> result2 = dairyService.recommenDairy(vo);
        mv.addObject("recommendairy", result2);
        
		List<DairyVO> result3 = dairyService.topDairy();
		mv.addObject("topdairy", result3);
		mv.setViewName("diary/main_dairy");
		return mv;
     }

	@RequestMapping(value = "dairySearch", method = RequestMethod.POST)
	public ModelAndView go_search_diary(@RequestParam(value="searchWord") String searchWord) {
		
		ModelAndView mv = new ModelAndView();
		HashMap hash = new HashMap();
		hash.put("searchWord", searchWord);
		List<DairyVO> list = dairyService.searchDdairy(hash);
		mv.addObject("list", list);
		
		int totalpage = list.size();
		int pagenum = totalpage/10 +1;
		
		mv.addObject("totalpage", totalpage);
		mv.addObject("pagenum",pagenum);
		
		mv.setViewName("diary/diaryList");

		return mv;
	}
	//--------------------------은주--------------------------

	/* 메소드명 : writeDairy
	 * 기능 : 메인페이지의 헤더에서 내 다이어리를 눌렀을때 다이어리 작성 페이지로 넘김
	 * 변수 : 없음
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "writediary")
	public ModelAndView writeDairy() {
		// System.out.println("***** writeDiary 확인 *****");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("diary/writeDiary");	// writeDiary 페이지로 넘김
		
		return mv;
	}
	
	/* 메소드명 : recommendTitle
	 * 기능 : 영화 제목을 입력하면 입력한 내용 얻어와서 검색
	 * 변수 : movieTitle
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "searchMovieTitle/{movieTitle}", method = RequestMethod.POST)
	public ModelAndView recommendTitle(@PathVariable(value = "movieTitle", required = false) String movieTitle) {
		// System.out.println("***** searchTitle 확인 *****");
		// System.out.println("----- movieTitle -----" + movieTitle);
		MovieVO mvo = new MovieVO();
		mvo.setMovieTitle(movieTitle);
		
		List recommendList = dairyService.recommendTitle(mvo);	// 검색해서 받아온 리스트
		
		// System.out.println("=== 10개 검색 목록 ===" + recommendList);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("rList", recommendList);	// rList에 검색 목록 넣어줌
		mv.setViewName("diary/recommendSelectBox");
		
		return mv;
	}
	
	/* 메소드명 : insertdiary
	 * 기능 : 다이어리 내용 입력하면 DB에 넣어줌
	 * 변수 : DairyVO
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "insertdiary", method = RequestMethod.POST)
	public ModelAndView insertDairy(DairyVO dvo, HttpSession session) { 
		// System.out.println("***** insertDiary 확인 *****");
		
		String userId = (String)session.getAttribute("userId"); // 사용자 아이디
		// System.out.println("***** 사용자 아이디 출력 : " + userId);
		
		dvo.setUserId(userId);
		
		String movieId = dvo.getMovieId();
		
		// DB에는 movieId 넣어줘야하니까 영화제목에서 movieId만 잘라줌
		String movieId2 = movieId.substring(movieId.length()-7, movieId.length()-1); // 영화 아이디
		
		// 폼 안에 입력한 내용 dvo에 지정
		dvo.setDiaryTitle(dvo.getDiaryTitle());
		dvo.setMovieId(movieId2);
		dvo.setDiaryContent(dvo.getDiaryContent());
		dvo.setViewingTogether(dvo.getViewingTogether());
		dvo.setViewingDate(dvo.getViewingDate());
		dvo.setViewingLocation(dvo.getViewingLocation());
		int insertResult = dairyService.insertDiary(dvo);
		
		if (insertResult == 1) {	// 다이어리 입력에 성공했는지 확인
			System.out.println("다이어리 입력 성공");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:index.jsp");	// index 페이지로 넘겨줌
        return mv;
     }
	
	/* 메소드명 : myDiary
	 * 기능 : 헤더 메뉴에서 나의 다이어리를 누르면 마이 다이어리 페이지로 넘어감
	 * 변수 : ****************************************************
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "getdairy")
	public ModelAndView myDiary(HttpSession session){ 
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");
		AccountFormVO avo = new AccountFormVO();
		avo.setUserId(userId);
//		
		// user 정보를 가져올거야...
		List<AccountFormVO> userInfo = dairyService.userInfo(avo);
		System.out.println("user 정보 확인 : " + userInfo);
		mv.addObject("userInfo", userInfo);
		
//		List<HashMap> result = dairyService.getDairyList(avo);
//		
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%^^" + result);
//        mv.addObject("myDiaryList", result);
        mv.setViewName("diary/myDiary");
        return mv;
     }
	
	@ResponseBody
	@RequestMapping(value = "showDiaryList/{pNum}", method = RequestMethod.POST)
	public ModelAndView diaryList(HttpSession session,
			@PathVariable(value = "pNum", required = true) String pageNum) {
		ModelAndView mv = new ModelAndView();

		String userId = (String)session.getAttribute("userId");
		AccountFormVO avo = new AccountFormVO();
		avo.setUserId(userId);
		
		// user 정보를 가져올거야...
		List<AccountFormVO> userInfo = dairyService.userInfo(avo);
		System.out.println("user 정보 확인 : " + userInfo);
		mv.addObject("userInfo", userInfo);
		
		
		// totalPage 구하기
		int totalPage = dairyService.countDiaryByUser(avo);
		// System.out.println("*************** total Page : " + totalPage);
		
		int pNum = Integer.parseInt(pageNum);
		System.out.println("현재 내가 선택한 페이지 번호는 ? " + pNum);

		mv.addObject("pNum", pNum);
		mv.addObject("totalPage", totalPage);
		List<HashMap> result = dairyService.getDairyList(avo, pNum);
		
		
		System.out.println("여기에--------------------------" + result);
		
        mv.addObject("myDiaryList", result);
		
		
		mv.setViewName("diary/diaryListAjax");
		return mv;
	}
	
	@RequestMapping(value = "showDetailList/{diaryId}", method = RequestMethod.POST)
	public ModelAndView showDetailList(@PathVariable(value = "diaryId", required = true) int diaryId) {
		ModelAndView mv = new ModelAndView();

		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		System.out.println("***** diaryId ***** " + diaryId);
		
		List<HashMap> result = dairyService.getDetailDiary(dvo);

		mv.addObject("diaryDetailList", result);
		mv.setViewName("diary/diaryDetailAjax");
		return mv;
	}
}