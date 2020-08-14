package com.kosmo.bangdairy.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.service.DairyServicelmpl;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Controller
public class DairyController {

	@Autowired
	DairyServicelmpl dairyService;
	
	@RequestMapping(value = "mydairy")
	   public ModelAndView my_dairy() {
	      ModelAndView mv = new ModelAndView();
	      
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
	      
	      mv.setViewName("diary/write_dairy");
	      return mv;
	   }
	   
	   @RequestMapping(value = "maindairy")
	   public ModelAndView main_dairy() {
	      ModelAndView mv = new ModelAndView();
	      
	      mv.setViewName("diary/main_dairy");
	      return mv;
	   }
	   
	   @RequestMapping(value = "insertrecentdairy")
	   public ModelAndView recentDairy(HttpSession session) throws Exception { 
	      ModelAndView mv = new ModelAndView();
	      String userId = (String)session.getAttribute("userId");
	      AccountFormVO vo= new AccountFormVO();
	      vo.setUserId(userId);
	      vo = dairyService.getMyProfile(vo);
	      List<DairyVO> result = dairyService.recentDairy(vo);
	      mv.addObject("recentdairy", result);
	      mv.addObject("vo", vo);
	      List<DairyVO> result2 = dairyService.recommenDairy(vo);
	        mv.addObject("recommendairy", result2);
	        
	      List<HashMap> result3 = dairyService.topDairy();
	      mv.addObject("topdairy", result3);
	      mv.setViewName("diary/main_dairy");
	      return mv;
	     }

	   @RequestMapping(value = "dairySearch", method = RequestMethod.POST)
	   public ModelAndView go_search_diary(@RequestParam(value="searchWord") String searchWord,
	         @RequestParam(value = "searchType",required = true)String searchType) {
	      
	      ModelAndView mv = new ModelAndView();
	      HashMap hash = new HashMap();
	      searchWord = searchWord.replace(" ","");
	      hash.put("searchType", searchType);
	      hash.put("searchWord", searchWord);
	      List<HashMap> list = dairyService.searchDdairy(hash);
	      mv.addObject("list", list);
//	      int totalpage = list.size();
//	      int pagenum = totalpage/10 +1;
	      mv.addObject("search", hash);
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
	 * 변수 : DairyVO, session
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "insertdiary", method = RequestMethod.POST)
	public ModelAndView insertDairy(DairyVO dvo, HttpSession session) { 
		// System.out.println("***** insertDiary 확인 *****");
		ModelAndView mv = new ModelAndView();

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
		
		mv.setViewName("redirect:getdairy");	// index 페이지로 넘겨줌
        return mv;
     }
	
	/* 메소드명 : myDiary
	 * 기능 : 헤더 메뉴에서 나의 다이어리를 누르면 마이 다이어리 페이지로 넘어감
	 * 변수 : session
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "getdairy")
	public ModelAndView myDiary(HttpSession session,
			@RequestParam(value = "userId",required = false)String diaryUserId,
			@RequestParam(value = "diaryId",required = false)String diaryId){ 
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");	// 로그인한 유저아이디 가져오기
		AccountFormVO avo = new AccountFormVO();
		if(userId!=null&&diaryId!=null&&diaryUserId!=null) { //MainDiary 에서 넘어올 때
			if(!userId.equals(diaryUserId)) {
				avo.setUserId(diaryUserId);
				mv.addObject("diaryId", diaryId);
			}else {
				avo.setUserId(userId);
			}
		}else {
			avo.setUserId(userId);
		}
		List<AccountFormVO> userInfo = dairyService.userInfo(avo);	// 유저 정보

		mv.addObject("userInfo", userInfo);
        mv.setViewName("diary/myDiary");
        
        return mv;
     }
	
	/* 메소드명 : diaryList
	 * 기능 : 다이어리 리스트와 페이지 구해서 ajax 통신으로 붙임
	 * 변수 : session, pageNum
	 * 작성자 : 배은주
	 */
	@ResponseBody
	@RequestMapping(value = "showDiaryList/{pNum}", method = RequestMethod.POST)
	public ModelAndView diaryList(HttpSession session,
			@PathVariable(value = "pNum", required = true) String pageNum,
			@RequestParam(value = "userId",required = false)String requestId) {
		ModelAndView mv = new ModelAndView();
		
		String userId = (String)session.getAttribute("userId");
		AccountFormVO avo = new AccountFormVO();
		if(requestId!=null) {
			avo.setUserId(requestId);
		}else {
			avo.setUserId(userId);
		}
		
		// totalPage 구하기
		int totalPage = dairyService.countDiaryByUser(avo); // user별 등록한 다이어리 수대로 전체 페이지 수 구함
		int pNum = Integer.parseInt(pageNum);

		mv.addObject("pNum", pNum);
		mv.addObject("totalPage", totalPage);
		
		List<HashMap> result = dairyService.getDairyList(avo, pNum);	// 유저가 작성한 다이어리 리스트 (5개씩)
		
        mv.addObject("myDiaryList", result);
		mv.setViewName("diary/diaryListAjax");
		
		return mv;
	}
	
	/* 메소드명 : showDetailList
	 * 기능 : 다이어리 리스트에서 다이어리 클릭하면 다이어리 내용 ajax 통신으로 붙임
	 * 변수 : diaryId
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "showDetailList/{diaryId}", method = RequestMethod.POST)
	public ModelAndView showDetailList(@PathVariable(value = "diaryId", required = true) int diaryId) {
		ModelAndView mv = new ModelAndView();

		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		// System.out.println("***** diaryId ***** " + diaryId);
		
		List<HashMap> result = dairyService.getDetailDiary(dvo);	// 다이어리 ID별로 가져온 상세페이지 리스트
		mv.addObject("diaryDetailList", result);
		mv.setViewName("diary/diaryDetailAjax");
		
		return mv;
	}
	
	/* 메소드명 : deleteDiary
	 * 기능 : 다이어리 삭제
	 * 변수 : diaryId
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "diaryDelete")
	public ModelAndView deleteDiary(@RequestParam(value = "diaryId") int diaryId) {
		ModelAndView mv = new ModelAndView();
		
		// System.out.println("삭제 컨트롤러로 넘어옴");
		// System.out.println("======= 넘어온 다이어리 ID : " + diaryId);
		
		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		dairyService.deleteDiary(dvo);
		
		mv.setViewName("redirect:getdairy");
		return mv;
	}
	
	/* 메소드명 : diaryModify
	 * 기능 : 다이어리 수정 페이지로 넘겨줌
	 * 변수 : diaryId
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "diaryModify")
	public ModelAndView diaryModify(@RequestParam(value = "diaryId") int diaryId) {
		ModelAndView mv = new ModelAndView();
		
		// System.out.println("수정 컨트롤러로 넘어옴");
		// System.out.println("======= 넘어온 다이어리 ID : " + diaryId);
		
		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		List<HashMap> result = dairyService.getDetailDiary(dvo); // 이미 다이어리에 입력되어 있는 내용
		
		// System.out.println("==========확인========" + result);
		
		mv.addObject("result", result);
		mv.setViewName("diary/modifyDiary");
		
		return mv;
	}
	
	/* 메소드명 : modifyDiary
	 * 기능 : 다이어리 수정
	 * 변수 : diaryId, dvo
	 * 작성자 : 배은주
	 */
	@RequestMapping(value = "modifyDiary")
	public ModelAndView modifyDiary(DairyVO dvo, @RequestParam(value = "diaryId") int diaryId) {
		ModelAndView mv = new ModelAndView();

		dvo.setDiaryId(diaryId);
		
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
		
		dairyService.updateDiary(dvo);
		
		mv.setViewName("redirect:getdairy");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value="/getdairy/likehate",method = RequestMethod.POST)
	public int clickLikeHate(@RequestParam(value="diaryId",required = true)String diaryId,
			@RequestParam(value = "type",required = true)String type,HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		DairyUserVO vo = new DairyUserVO();
		vo.setDiaryId(Integer.parseInt(diaryId));
		vo.setUserId(userId);
		if(type.equals("like")) {
			vo.setDiaryLike("1");
			vo.setDiaryHate("0");
		}else {
			vo.setDiaryLike("0");
			vo.setDiaryHate("1");
		}
		int result = dairyService.clickLikeHate(vo);
		return result;
		
	}
}