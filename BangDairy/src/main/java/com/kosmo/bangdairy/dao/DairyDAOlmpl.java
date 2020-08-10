package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Repository("dairyDAO")
public class DairyDAOlmpl implements DairyDAO{
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<DairyVO> showList(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.listdairy",vo);
	}
	
	@Override
	public List<DairyVO> recentDairy(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.recentdairy",vo);
	}
	
	@Override
	public List<DairyVO> topDairy() {
		return sqlSession.selectList("DairyDAO.topdairy");
	}
	
	@Override
	public List<DairyVO> recommenDairy(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.recommendairy",vo);
	}
	
	@Override
	public List<DairyVO> searchDdairy(HashMap hash) {
		return sqlSession.selectList("DairyDAO.searchddairy",hash);
	}
	//--------------------------은주--------------------------
	@Override
	public List<MovieVO> recommendTitle(MovieVO mvo) {	// 영화제목 검색 후 리스트 받아옴
		return sqlSession.selectList("DairyDAO.recommendTitle", mvo);
	}
	
	@Override
	public int insertDiary(DairyVO dvo) {	// 다이어리 작성 후 DB에 입력
		return sqlSession.insert("DairyDAO.insertDiary", dvo);
	}
	
	@Override
	public List<AccountFormVO> userInfo(AccountFormVO avo) { // 유저정보 가져옴
		return sqlSession.selectList("DairyDAO.userInfo", avo);
	}
	
	@Override
	public int countDiaryByUser(AccountFormVO avo) { // 다이어리 총 개수 COUNT
		return sqlSession.selectOne("DairyDAO.countDiaryByUser", avo);
	}
	
	@Override	// 다이어리 리스트 목록 가져옴
	public List<HashMap> getDairyList(AccountFormVO vo, int firstRow, int endRow) {
		HashMap m = new HashMap();
		
		// System.out.println("daoImpl ========== " + firstRow);
		// System.out.println("daoImpl ========== " + endRow);

		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("userId", vo.getUserId());
		
		return sqlSession.selectList("DairyDAO.dairyList", m);
	}

	@Override
	public List<HashMap> getDetailDiary(DairyVO dvo) {	// 다이어리 상세정보 가져옴
		return sqlSession.selectList("DairyDAO.getDetailDiary", dvo);
	}

	@Override
	public int deleteDiary(DairyVO dvo) {	// 다이어리 삭제
		return sqlSession.delete("DairyDAO.deleteDiary", dvo);
	}

	@Override
	public int updateDiary(DairyVO dvo) {	// 다이어리 수정
		return sqlSession.update("DairyDAO.updateUserInfo", dvo);
	}
}