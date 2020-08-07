package com.kosmo.bangdairy.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.DairyDAOlmpl;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Service("dairyService")
public class DairyServicelmpl implements DairyService {
	
	@Autowired
	DairyDAOlmpl dairyDAO;
	
	int totalRecordCount;
	int pageTotalCount;
	int countPerPage = 10;
	int blockPageNumcount = 5;

	@Override
	public List<HashMap> getDairyList(AccountFormVO vo) {
		return dairyDAO.getDairyList(vo);
		
	}
	@Override
	public void create(DairyVO vo) {
		dairyDAO.create(vo);
	}
	@Override
	public List<DairyVO> showList(AccountFormVO vo) {
		return dairyDAO.showList(vo);
	}
	
	@Override
	public List<DairyVO> recentDairy(AccountFormVO vo){
		return dairyDAO.recentDairy(vo);
	}
	
	@Override
	public List<DairyVO> topDairy(){
		return dairyDAO.topDairy();
	}
	
	@Override
	public List<DairyVO> recommenDairy(AccountFormVO vo){
		return dairyDAO.recommenDairy(vo);
	}
	
	@Override
	public List<DairyVO> searchDdairy(HashMap hash) {
		return dairyDAO.searchDdairy(hash);		
	}

	//--------------------------은주--------------------------
	@Override
	public List<MovieVO> recommendTitle(MovieVO mvo) {	// 영화제목 검색 후 리스트 받아옴
		return dairyDAO.recommendTitle(mvo);
	}
	@Override
	public int insertDiary(DairyVO dvo) {	// 다이어리 작성 후 DB에 입력
		return dairyDAO.insertDiary(dvo);
	}

	@Override
	public List<AccountFormVO> userInfo(AccountFormVO avo) {
		return dairyDAO.userInfo(avo);
	}
}
