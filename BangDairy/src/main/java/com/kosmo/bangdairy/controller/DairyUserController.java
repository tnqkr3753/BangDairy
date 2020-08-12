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

import com.kosmo.bangdairy.service.DairyUserService;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

@Controller
public class DairyUserController {

	@Autowired
	DairyUserService dairyUserService;

	int diaryId;

	
	 @RequestMapping(value = "gootherdairy") 
	 public ModelAndView gother_diary() {
	 
		 DairyUserVO vo = new DairyUserVO(); 
		 ModelAndView mv = new ModelAndView();
		 System.out.println(diaryId);

		 mv.setViewName("diary/otherDiary");
	 
	 return mv; 
	 }
	 

	@RequestMapping(value = "createDiaryLike", method = RequestMethod.POST)
	public ModelAndView createUserInfo(@RequestParam(value = "diaryId") int diaryId) throws Exception {

		ModelAndView mv = new ModelAndView();

		DairyVO vo = new DairyVO();

		this.diaryId = diaryId;
		vo.setDiaryId(diaryId);
	

		// 클릭 시 조회수 증가
		List<DairyVO> hitsupdate = dairyUserService.updatehits(vo);
		mv.addObject("hitsupdate", hitsupdate);

		// 다이어리 유저 정보 전송
		List<HashMap> otherdddlist = dairyUserService.userInfo(vo);
		mv.addObject("otherdddlist", otherdddlist);

		// 왼쪽에 뜨는 다이어리 유저 정보
		List<AccountFormVO> leftUserInfo = dairyUserService.leftUserInfo(vo);
		mv.addObject("leftuserinfo", leftUserInfo);

		// 아래뜨는 다이어리 리스트
		List<DairyVO> result = dairyUserService.getOtherDairyList(vo);
		mv.addObject("myDiaryList", result);
		
		//그 사람의 영화 위시리스트
		List<WishMovieVO> wishresult = dairyUserService.selectWishMovie(vo);
		mv.addObject("myDwishList", wishresult);

		mv.setViewName("diary/otherDiary");
		// 내 user_id == session : mydairy로 이동
		return mv;
		
		
	}

	@RequestMapping(value = "updatelike/{diaryId}", method = RequestMethod.POST)
	public ModelAndView updateOneLik(DairyUserVO vo, @PathVariable(value = "diaryId", required = true) int diaryId, HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		this.diaryId = diaryId;
		vo.setDiaryId(diaryId);
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);
		
		// null인지 검사
		int havelike = dairyUserService.countLikes(vo);
		int havehate = dairyUserService.countHates(vo);

		// 좋아요 싫어요 수 계산
		int checklike = dairyUserService.checkLikes(vo);
		int checkhate = dairyUserService.checkHates(vo);

		// 둘다 null이면 => 컬럼이 없으면
		if (havehate == 0 & havelike == 0) {
			dairyUserService.upLike(vo);
		}
		// 좋아요는 1일때
		else if (checklike == 1) {
			dairyUserService.makeZero(vo);
		} else {
			dairyUserService.insertZeroHate(vo);
			dairyUserService.updatelikes(vo);
		}
		
		
		mv.addObject(diaryId);
		
		mv.setViewName("diary/otherDiaryAjax");
		return mv;
		
	}

	@RequestMapping(value = "updatehate/{diaryId}", method = RequestMethod.POST)
	public ModelAndView updateOneHate(DairyUserVO vo, @PathVariable(value = "diaryId", required = true) int diaryId, HttpSession session)
			throws Exception {

		ModelAndView mv = new ModelAndView();

		this.diaryId = diaryId;
		vo.setDiaryId(diaryId);
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);

		// null인지 검사
		int havelike = dairyUserService.countLikes(vo);
		int havehate = dairyUserService.countHates(vo);

		// 좋아요 싫어요 수 계산
		int checklike = dairyUserService.checkLikes(vo);
		int checkhate = dairyUserService.checkHates(vo);

		// 둘다 null이면 => 컬럼이 없으면
		if (havehate == 0 & havelike == 0) {
			dairyUserService.upHate(vo);
		}
		// 좋아요는 1일때
		else if (checkhate == 1) {
			dairyUserService.makeZero(vo);
		} else {
			dairyUserService.insertZeroLike(vo);
			dairyUserService.updatehates(vo);
		}
		mv.setViewName("diary/otherDiaryAjax");
		return mv;
	}

	@RequestMapping(value = "showODiaryList/{pNum}", method = RequestMethod.POST)
	public ModelAndView showDetailList(
		@PathVariable(value = "pNum", required = true) int pNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("드디어 연결");

		DairyVO vo = new DairyVO();
		vo.setDiaryId(diaryId);
		int totalPage = dairyUserService.ocountoDiaryByUser(vo);
		
		mv.addObject("pNum", pNum);
		mv.addObject("totalPage", totalPage);
		
		System.out.println(pNum);
		System.out.println(totalPage);
		List<HashMap> result = dairyUserService.odairyList(vo,pNum);
		
		System.out.println(result);
		mv.addObject("odiaryDetailList", result);
		mv.setViewName("diary/otherdiaryListAjax");
		
		return mv;
	}

	
}
