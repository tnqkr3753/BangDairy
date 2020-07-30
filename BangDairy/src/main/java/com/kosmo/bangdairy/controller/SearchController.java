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
	
	String searchWord; // �˻���
	List<HashMap> list; // ��ȭ ���� ���� ����Ʈ
	
	/* �޼ҵ�� : searchMovie
	 * ��� : ������ ����� �˻�â�� �˻��� �Է��ϸ� ��ȭ ����Ʈ �������� �Ѱ���
	 * ���� : searchWord
	 * �ۼ��� : ������
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView searchMovie(@RequestParam(value="movieSearch") String searchWord) {
		MovieVO vo = new MovieVO();
		
		this.searchWord = searchWord; // �˻���

		LoggerAspect.logger.info("searchController title : " + searchWord);
		
		ModelAndView mv = new ModelAndView();

		MovieVO mvo = new MovieVO();
		
		LoggerAspect.logger.info(list);
		
		mv.setViewName("movieList/movieList"); // movieList �������� �ѱ�
		
		return mv;
	}
	
	
	/* �޼ҵ�� : searchBy
	 * ��� : ��ȭ ����Ʈ ���������� ���� ��ư Ŭ���ϸ� �ش� ����(+�˻���)�� �´� ��ȭ ����Ʈ ������, ����¡
	 * ���� : tabName, pageNum
	 * �ۼ��� : ������
	 */
	@ResponseBody
	@RequestMapping(value = "searchBy/{tabName}/{pNum}", method = RequestMethod.POST)
	public ModelAndView searchBy(@PathVariable(value = "tabName", required = true) String tabName,
			@PathVariable(value = "pNum", required = true) String pageNum) {
		
		ModelAndView mv = new ModelAndView(); 
		
		int pNum = Integer.parseInt(pageNum); // ���� ������ ������ ��ȣ �޾ƿͼ� �� ��ȯ
		
		System.out.println("***** ���� ���� ������ ������ ��ȣ ***** : " + pNum);
				
		MovieVO mvo = new MovieVO();
		DirectorVO dvo = new DirectorVO();
		ActorVO avo = new ActorVO();
		
		mv.setViewName("movieList/searchTab");
		
		int totalPage;	// ��ü ������ ��
		
		if (tabName.contains("Title")) {						 // "Title" ���� ��ư�� Ŭ������ ��			
			mvo.setMovieTitle(searchWord);
			
			totalPage = searchService.searchCountTitle(mvo);	// ��ü ������ �� ���ϱ�
			
			System.out.println("***** ��ü �������� Ȯ�� ***** : " + totalPage);

			mv.addObject("pNum", pNum);
			mv.addObject("totalPage", totalPage);
			mv.addObject("mList", searchService.searchMovie(mvo, pNum));
		} else if (tabName.contains("Director")) { 				// "Director" ���� ��ư�� Ŭ������ ��	
			System.out.println(tabName+"-----"+pNum+"-----Ȯ��1");
			dvo.setDirectorName(searchWord);	
			System.out.println(tabName+"-----"+pNum+"-----Ȯ��2");

			totalPage = searchService.searchCountDirector(dvo);

			mv.addObject("pNum", pNum);
			mv.addObject("totlaPage", totalPage);
			mv.addObject("mList", searchService.searchDirector(dvo, pNum));
		}  else if (tabName.contains("Actor")) { 				// "Actor" ���� ��ư�� Ŭ������ ��	
			avo.setActorName(searchWord);
			
			totalPage = searchService.searchCountActor(avo);
			
			mv.addObject("pNum", pNum);
			mv.addObject("totalPage", totalPage);
			mv.addObject("mList", searchService.searchActor(avo, pNum));
		}  else if (tabName.contains("Keywords")) {		 		// "Keywords" ���� ��ư�� Ŭ������ ��
			mvo.setKeyword(searchWord);
			
			totalPage = searchService.searchCountKeywords(mvo);
			
			mv.addObject("pNum", pNum);
			mv.addObject("totalPage", totalPage);
			mv.addObject("mList", searchService.searchKeywords(mvo, pNum));
		}

		return mv;
	}
}