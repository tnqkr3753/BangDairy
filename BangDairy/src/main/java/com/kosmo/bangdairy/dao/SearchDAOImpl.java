package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Repository("searchDAO")
public class SearchDAOImpl implements SearchDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<HashMap> searchMovie(MovieVO vo, int firstRow, int endRow) {					// 영화 제목으로 검색
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("movieTitle", vo.getMovieTitle());
		
		return sqlSession.selectList("SearchDAO.searchMovie", m);
	}
	
	@Override
	public List<HashMap> searchDirector(DirectorVO vo, int firstRow, int endRow) {	// 감독 이름으로 검색
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("directorName", vo.getDirectorName());
		
		return sqlSession.selectList("SearchDAO.searchDirector", m);
	}

	@Override
	public List<HashMap> searchActor(ActorVO vo, int firstRow, int endRow) {	// 배우 이름으로 검색
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("actorName", vo.getActorName());
		
		return sqlSession.selectList("SearchDAO.searchActor", m);
	}

	@Override
	public List<HashMap> searchKeywords(MovieVO vo, int firstRow, int endRow) {	// 키워드로 검색
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("keyword", vo.getKeyword());
		
		return sqlSession.selectList("SearchDAO.searchKeywords", m);
	}

	@Override
	public int searchCountTitle(MovieVO vo) {	// 전체 페이지 수
		return sqlSession.selectOne("SearchDAO.searchCountTitle", vo);
	}

	@Override
	public int searchCountDirector(DirectorVO vo) {
		return sqlSession.selectOne("SearchDAO.searchCountDirector", vo);

	}

	@Override
	public int searchCountActor(ActorVO vo) {
		return sqlSession.selectOne("SearchDAO.searchCountActor", vo);

	}

	@Override
	public int searchCountKeywords(MovieVO vo) {
		return sqlSession.selectOne("SearchDAO.searchCountKeywords", vo);

	}
}