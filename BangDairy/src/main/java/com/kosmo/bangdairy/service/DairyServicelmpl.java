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
	public List<DairyVO> showList(AccountFormVO vo) {
		return dairyDAO.showList(vo);
	}
	
	@Override
	public List<DairyVO> recentDairy(AccountFormVO vo){
		return dairyDAO.recentDairy(vo);
	}
	
	@Override
	public List<HashMap> topDairy(){
		return dairyDAO.topDairy();
	} 
	
	@Override
	public List<DairyVO> recommenDairy(AccountFormVO vo){
		return dairyDAO.recommenDairy(vo);
	}
	
	@Override
	public List<HashMap> searchDdairy(HashMap hash) {
		return dairyDAO.searchDdairy(hash);		
	}

	@Override
	public AccountFormVO getMyProfile(AccountFormVO vo) {
		return dairyDAO.getMyProfile(vo);
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
	public List<AccountFormVO> userInfo(AccountFormVO avo) { // 유저정보 가져옴
		return dairyDAO.userInfo(avo);
	}
	
	int totalDiaryCount;	// 총 다이어리 리스트 개수
	
	@Override
	public int countDiaryByUser(AccountFormVO avo) { // 다이어리 총 개수 COUNT
		totalDiaryCount = dairyDAO.countDiaryByUser(avo);
		pageTotalCount = totalDiaryCount/5;
		
		if (totalDiaryCount % 5 > 0) pageTotalCount++;
		
		return pageTotalCount;
	}
	
	@Override	// 다이어리 리스트 목록 가져옴
	public List<HashMap> getDairyList(AccountFormVO vo, int pNum) {
		int firstRow = (pNum-1) * 5;
		int endRow = 5;
		
		return dairyDAO.getDairyList(vo, firstRow, endRow);
	}

	@Override	// 다이어리 상세정보 가져옴
	public List<HashMap> getDetailDiary(DairyVO dvo) {
		return dairyDAO.getDetailDiary(dvo);
	}

	@Override	// 다이어리 삭제
	public int deleteDiary(DairyVO dvo) {
		return dairyDAO.deleteDiary(dvo);
	}

	@Override	// 다이어리 수정
	public int updateDiary(DairyVO dvo) {
		return dairyDAO.updateDiary(dvo);
	}
}