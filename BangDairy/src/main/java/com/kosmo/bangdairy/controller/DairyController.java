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
	      
	      HashMap hash = new HashMap();
	      hash.put("userId", userId);
	      
	      List<HashMap> mostlike = dairyService.mostlikeuser(vo);
	      mv.addObject("mostliked", mostlike);
	      
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
	
	//--------------------------��二�--------------------------

	/* 硫붿냼�뱶紐� : writeDairy
	 * 湲곕뒫 : 硫붿씤�럹�씠吏��쓽 �뿤�뜑�뿉�꽌 �궡 �떎�씠�뼱由щ�� �닃���쓣�븣 �떎�씠�뼱由� �옉�꽦 �럹�씠吏�濡� �꽆源�
	 * 蹂��닔 : �뾾�쓬
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "writediary")
	public ModelAndView writeDairy() {
		// System.out.println("***** writeDiary �솗�씤 *****");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("diary/writeDiary");	// writeDiary �럹�씠吏�濡� �꽆源�
		
		return mv;
	}
	
	/* 硫붿냼�뱶紐� : recommendTitle
	 * 湲곕뒫 : �쁺�솕 �젣紐⑹쓣 �엯�젰�븯硫� �엯�젰�븳 �궡�슜 �뼸�뼱���꽌 寃��깋
	 * 蹂��닔 : movieTitle
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "searchMovieTitle/{movieTitle}", method = RequestMethod.POST)
	public ModelAndView recommendTitle(@PathVariable(value = "movieTitle", required = false) String movieTitle) {
		// System.out.println("***** searchTitle �솗�씤 *****");
		// System.out.println("----- movieTitle -----" + movieTitle);
		MovieVO mvo = new MovieVO();
		mvo.setMovieTitle(movieTitle);
		
		List recommendList = dairyService.recommendTitle(mvo);	// 寃��깋�빐�꽌 諛쏆븘�삩 由ъ뒪�듃
		
		// System.out.println("=== 10媛� 寃��깋 紐⑸줉 ===" + recommendList);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("rList", recommendList);	// rList�뿉 寃��깋 紐⑸줉 �꽔�뼱以�
		mv.setViewName("diary/recommendSelectBox");
		
		return mv;
	}
	
	/* 硫붿냼�뱶紐� : insertdiary
	 * 湲곕뒫 : �떎�씠�뼱由� �궡�슜 �엯�젰�븯硫� DB�뿉 �꽔�뼱以�
	 * 蹂��닔 : DairyVO, session
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "insertdiary", method = RequestMethod.POST)
	public ModelAndView insertDairy(DairyVO dvo, HttpSession session) { 
		// System.out.println("***** insertDiary �솗�씤 *****");
		ModelAndView mv = new ModelAndView();

		String userId = (String)session.getAttribute("userId"); // �궗�슜�옄 �븘�씠�뵒
		// System.out.println("***** �궗�슜�옄 �븘�씠�뵒 異쒕젰 : " + userId);
		
		dvo.setUserId(userId);
		
		String movieId = dvo.getMovieId();
		
		// DB�뿉�뒗 movieId �꽔�뼱以섏빞�븯�땲源� �쁺�솕�젣紐⑹뿉�꽌 movieId留� �옒�씪以�
		String movieId2 = movieId.substring(movieId.length()-7, movieId.length()-1); // �쁺�솕 �븘�씠�뵒
		
		// �뤌 �븞�뿉 �엯�젰�븳 �궡�슜 dvo�뿉 吏��젙
		dvo.setDiaryTitle(dvo.getDiaryTitle());
		dvo.setMovieId(movieId2);
		dvo.setDiaryContent(dvo.getDiaryContent());
		dvo.setViewingTogether(dvo.getViewingTogether());
		dvo.setViewingDate(dvo.getViewingDate());
		dvo.setViewingLocation(dvo.getViewingLocation());
		int insertResult = dairyService.insertDiary(dvo);
		
		if (insertResult == 1) {	// �떎�씠�뼱由� �엯�젰�뿉 �꽦怨듯뻽�뒗吏� �솗�씤
			System.out.println("�떎�씠�뼱由� �엯�젰 �꽦怨�");
		}
		
		mv.setViewName("redirect:getdairy");	// index �럹�씠吏�濡� �꽆寃⑥쨲
        return mv;
     }
	
	/* 硫붿냼�뱶紐� : myDiary
	 * 湲곕뒫 : �뿤�뜑 硫붾돱�뿉�꽌 �굹�쓽 �떎�씠�뼱由щ�� �늻瑜대㈃ 留덉씠 �떎�씠�뼱由� �럹�씠吏�濡� �꽆�뼱媛�
	 * 蹂��닔 : session
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "getdairy")
	public ModelAndView myDiary(HttpSession session,
			@RequestParam(value = "userId",required = false)String diaryUserId,
			@RequestParam(value = "diaryId",required = false)String diaryId){ 
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("userId");	// 濡쒓렇�씤�븳 �쑀���븘�씠�뵒 媛��졇�삤湲�
		AccountFormVO avo = new AccountFormVO();
		if(userId!=null&&diaryId!=null&&diaryUserId!=null) { //MainDiary �뿉�꽌 �꽆�뼱�삱 �븣
			if(!userId.equals(diaryUserId)) {
				avo.setUserId(diaryUserId);
				mv.addObject("diaryId", diaryId);
			}else {
				avo.setUserId(userId);
			}
		}else {
			avo.setUserId(userId);
		}
		List<AccountFormVO> userInfo = dairyService.userInfo(avo);	// �쑀�� �젙蹂�

		mv.addObject("userInfo", userInfo);
        mv.setViewName("diary/myDiary");
        
        return mv;
     }
	
	/* 硫붿냼�뱶紐� : diaryList
	 * 湲곕뒫 : �떎�씠�뼱由� 由ъ뒪�듃�� �럹�씠吏� 援ы빐�꽌 ajax �넻�떊�쑝濡� 遺숈엫
	 * 蹂��닔 : session, pageNum
	 * �옉�꽦�옄 : 諛곗�二�
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
		
		// totalPage 援ы븯湲�
		int totalPage = dairyService.countDiaryByUser(avo); // user蹂� �벑濡앺븳 �떎�씠�뼱由� �닔��濡� �쟾泥� �럹�씠吏� �닔 援ы븿
		int pNum = Integer.parseInt(pageNum);

		mv.addObject("pNum", pNum);
		mv.addObject("totalPage", totalPage);
		
		List<HashMap> result = dairyService.getDairyList(avo, pNum);	// �쑀��媛� �옉�꽦�븳 �떎�씠�뼱由� 由ъ뒪�듃 (5媛쒖뵫)
		
        mv.addObject("myDiaryList", result);
		mv.setViewName("diary/diaryListAjax");
		
		return mv;
	}
	
	/* 硫붿냼�뱶紐� : showDetailList
	 * 湲곕뒫 : �떎�씠�뼱由� 由ъ뒪�듃�뿉�꽌 �떎�씠�뼱由� �겢由��븯硫� �떎�씠�뼱由� �궡�슜 ajax �넻�떊�쑝濡� 遺숈엫
	 * 蹂��닔 : diaryId
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "showDetailList/{diaryId}", method = RequestMethod.POST)
	public ModelAndView showDetailList(@PathVariable(value = "diaryId", required = true) int diaryId) {
		ModelAndView mv = new ModelAndView();

		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		// System.out.println("***** diaryId ***** " + diaryId);
		
		List<HashMap> result = dairyService.getDetailDiary(dvo);	// �떎�씠�뼱由� ID蹂꾨줈 媛��졇�삩 �긽�꽭�럹�씠吏� 由ъ뒪�듃
		mv.addObject("diaryDetailList", result);
		mv.setViewName("diary/diaryDetailAjax");
		
		return mv;
	}
	
	/* 硫붿냼�뱶紐� : deleteDiary
	 * 湲곕뒫 : �떎�씠�뼱由� �궘�젣
	 * 蹂��닔 : diaryId
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "diaryDelete")
	public ModelAndView deleteDiary(@RequestParam(value = "diaryId") int diaryId) {
		ModelAndView mv = new ModelAndView();
		
		// System.out.println("�궘�젣 而⑦듃濡ㅻ윭濡� �꽆�뼱�샂");
		// System.out.println("======= �꽆�뼱�삩 �떎�씠�뼱由� ID : " + diaryId);
		
		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		dairyService.deleteDiary(dvo);
		
		mv.setViewName("redirect:getdairy");
		return mv;
	}
	
	/* 硫붿냼�뱶紐� : diaryModify
	 * 湲곕뒫 : �떎�씠�뼱由� �닔�젙 �럹�씠吏�濡� �꽆寃⑥쨲
	 * 蹂��닔 : diaryId
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "diaryModify")
	public ModelAndView diaryModify(@RequestParam(value = "diaryId") int diaryId) {
		ModelAndView mv = new ModelAndView();
		
		// System.out.println("�닔�젙 而⑦듃濡ㅻ윭濡� �꽆�뼱�샂");
		// System.out.println("======= �꽆�뼱�삩 �떎�씠�뼱由� ID : " + diaryId);
		
		DairyVO dvo = new DairyVO();
		dvo.setDiaryId(diaryId);
		
		List<HashMap> result = dairyService.getDetailDiary(dvo); // �씠誘� �떎�씠�뼱由ъ뿉 �엯�젰�릺�뼱 �엳�뒗 �궡�슜
		
		// System.out.println("==========�솗�씤========" + result);
		
		mv.addObject("result", result);
		mv.setViewName("diary/modifyDiary");
		
		return mv;
	}
	
	/* 硫붿냼�뱶紐� : modifyDiary
	 * 湲곕뒫 : �떎�씠�뼱由� �닔�젙
	 * 蹂��닔 : diaryId, dvo
	 * �옉�꽦�옄 : 諛곗�二�
	 */
	@RequestMapping(value = "modifyDiary")
	public ModelAndView modifyDiary(DairyVO dvo, @RequestParam(value = "diaryId") int diaryId) {
		ModelAndView mv = new ModelAndView();

		dvo.setDiaryId(diaryId);
		
		String movieId = dvo.getMovieId();
		
		// DB�뿉�뒗 movieId �꽔�뼱以섏빞�븯�땲源� �쁺�솕�젣紐⑹뿉�꽌 movieId留� �옒�씪以�
		String movieId2 = movieId.substring(movieId.length()-7, movieId.length()-1); // �쁺�솕 �븘�씠�뵒
		
		// �뤌 �븞�뿉 �엯�젰�븳 �궡�슜 dvo�뿉 吏��젙
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