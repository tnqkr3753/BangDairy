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
	public List<HashMap> getDairyList(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.dairyList",vo);
	}
	@Override
	public void create(DairyVO vo) {
		 sqlSession.insert("DairyDAO.dairyInsert",vo);
		
	}
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
	public List<AccountFormVO> userInfo(AccountFormVO avo) {
		return sqlSession.selectList("DairyDAO.userInfo", avo);
	}
}
