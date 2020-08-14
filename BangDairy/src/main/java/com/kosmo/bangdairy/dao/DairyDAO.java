package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface DairyDAO {
	
public List<DairyVO> showList(AccountFormVO vo);
	
	public List<DairyVO> recentDairy(AccountFormVO vo);

	public List<HashMap> topDairy();
	
	public List<DairyVO> recommenDairy(AccountFormVO vo);
	
	public List<HashMap> searchDdairy(HashMap hash);
	
	public AccountFormVO getMyProfile(AccountFormVO vo);
	
	//--------------------------은주--------------------------
	public List<MovieVO> recommendTitle(MovieVO mvo);	// 영화제목 검색 후 리스트 받아옴
	
	public int insertDiary(DairyVO dvo);	// 다이어리 작성 후 DB에 입력
	
	public List<AccountFormVO> userInfo(AccountFormVO avo); // 유저정보 가져옴
	
	public int countDiaryByUser(AccountFormVO avo); // 다이어리 총 개수 COUNT
	
	public List<HashMap> getDairyList(AccountFormVO vo, int firstRow, int endRow);	// 다이어리 리스트 목록 가져옴

	public List<HashMap> getDetailDiary(DairyVO dvo);	// 다이어리 상세정보 가져옴
	
	public int deleteDiary(DairyVO dvo);	// 다이어리 삭제
	
	public int updateDiary(DairyVO dvo);	// 다이어리 수정
	
	public int increateHits(DairyVO vo);
	public int clickLikeHate(DairyUserVO vo);
}