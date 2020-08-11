package com.kosmo.bangdairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosmo.bangdairy.dao.AccountFormDAOImpl;
import com.kosmo.bangdairy.dao.IndieDAO;
import com.kosmo.bangdairy.dao.IndieDAOImpl;
import com.kosmo.bangdairy.dao.SearchDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.MovieVO;


@Service("indieSevice")
public class IndieSeviceImpl implements IndieSevice {
	int totalCount ; // 물론 실제론 여긴 DBMS 에서 조회해서 들어가야 합니다.

	int countList = 10;
	int totalPage;
	int page = 5;

	
	@Autowired
	private IndieDAOImpl indieDAO;
	
	@Override
	public void indieInsert(IndieVO ivo) {
		indieDAO.indieInsert(ivo);	
	}
	@Override
	public List<IndieVO> indieGnareSelect() {
		return 	indieDAO.indieGnareSelect();
	}

	public IndieVO selectIndieDetail(IndieVO ivo){
		indieDAO.increaseHits(ivo);
		return indieDAO.selectIndieDetail(ivo);
	}
	
	@Override
	public List<IndieVO> selectIndieInfo() {
		return indieDAO.selectIndieInfo();
	}
	@Override
	public int selectTotalCount(String searchWord) {
		HashMap hash = new HashMap();
		hash.put("searchWord", searchWord);
		// TODO Auto-generated method stub
		totalCount=indieDAO.selectTotalCount(hash);
		 totalPage = totalCount / countList;
		if (totalCount % countList > 0) {
		    totalPage++;
		}
		if (totalPage < page) {
		    page = totalPage;
		}
		 return totalPage;
	}
	@Override
	public List<HashMap> selectIndiepaging(int pNum,String searchWord) {
		int firstRow = (pNum-1)*countList;
		int endRow = 10;
		return indieDAO.selectIndiepaging(firstRow,endRow,searchWord);
	}
	@Override
	public int goodInsert(int goodId1, String userId) {
		 return indieDAO.goodInsert( goodId1, userId);
		
	}
	@Override
	public int badInsert(int badid1, String userId) {
		 return indieDAO.badInsert( badid1, userId);
	}
	@Override
	public int selectEqulegood(int goodId1, String userId) {
		 return indieDAO.selectEqulegood( goodId1, userId);
	}
	@Override
	public int selectNull(int goodId1, String userId) {
		 return indieDAO.selectNull( goodId1, userId);
	}
}
	
