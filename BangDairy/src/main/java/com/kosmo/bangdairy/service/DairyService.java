package com.kosmo.bangdairy.service;



import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface DairyService {

	public List<HashMap> getDairyList(AccountFormVO vo);
	
	public List<DairyVO> showList(AccountFormVO vo);
	
	public List<DairyVO> recentDairy(AccountFormVO vo);
	
	public List<DairyVO> topDairy();
	
	public List<DairyVO> recommenDairy(AccountFormVO vo);
	
	public List<HashMap> searchWord(DairyVO vo, int pNum, String selectdOrder);		// ��ȭ �������� �˻�

	public int searchCountWord(DairyVO vo);

	//--------------------------은주--------------------------
	public List<MovieVO> recommendTitle(MovieVO mvo);	// 영화제목 검색 후 리스트 받아옴
	
	public int insertDiary(DairyVO dvo);	// 다이어리 작성 후 DB에 입력
	
	public List<AccountFormVO> userInfo(AccountFormVO avo);
}

