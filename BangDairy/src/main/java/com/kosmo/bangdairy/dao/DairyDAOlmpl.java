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
public class DairyDAOlmpl implements DairyDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<DairyVO> showList(AccountFormVO vo) {
		return sqlSession.selectList("listdairy",vo);
	}
	
	@Override
	public List<DairyVO> recentDairy(AccountFormVO vo) {
		return sqlSession.selectList("recentdairy",vo);
	}
	
	@Override
	public List<DairyVO> topDairy() {
		return sqlSession.selectList("topdairy");
	}
	
	@Override
	public List<DairyVO> recommenDairy(AccountFormVO vo) {
		return sqlSession.selectList("recommendairy",vo);
	}
	
	public List<HashMap> searchWord(DairyVO vo, int firstRow, int endRow, String selectdOrder) {
		
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("diaryTitle", vo.getDiaryTitle());
		m.put("diaryContent", vo.getDiaryContent());
		m.put("diaryId", vo.getDiaryId());
		m.put("diaryHits",vo.getDiaryHits());
		
		m.put("selectdOrder", selectdOrder);
		
		return sqlSession.selectList("dairyDAO.searchDairy", m);
	}
	
	@Override
	public int searchCountWord(DairyVO vo) {
		return sqlSession.selectOne("dairyDAO.searchCountWord", vo);	
	}
	
	//--------------------------은주--------------------------
	@Override
	public List<MovieVO> recommendTitle(MovieVO mvo) {	// 영화제목 검색 후 리스트 받아옴
		return sqlSession.selectList("dairyDAO.recommendTitle", mvo);
	}
	
	@Override
	public int insertDiary(DairyVO dvo) {	// 다이어리 작성 후 DB에 입력
		return sqlSession.insert("dairyDAO.insertDiary", dvo);
	}
	
	@Override
	public List<AccountFormVO> userInfo(AccountFormVO avo) {
		return sqlSession.selectList("dairyDAO.userInfo", avo);
	}
	
	@Override
	public int countDiaryByUser(AccountFormVO avo) {
		return sqlSession.selectOne("dairyDAO.countDiaryByUser", avo);
	}
	
	@Override
	public List<HashMap> getDairyList(AccountFormVO vo, int firstRow, int endRow) {
		HashMap m = new HashMap();
		
		System.out.println("daoImpl ========== " + firstRow);
		System.out.println("daoImpl ========== " + endRow);

		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("userId", vo.getUserId());
		return sqlSession.selectList("dairyDAO.dairyList", m);
	}

	@Override
	public List<HashMap> getDetailDiary(DairyVO dvo) {
		return sqlSession.selectList("dairyDAO.getDetailDiary", dvo);
	}
}
