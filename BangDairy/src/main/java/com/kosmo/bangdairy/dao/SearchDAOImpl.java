package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

@Repository("searchDAO")
public class SearchDAOImpl implements SearchDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<HashMap> searchMovie(MovieVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre) {					// ��ȭ �������� �˻�
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("movieTitle", vo.getMovieTitle());
		m.put("selectOrder", selectOrder);
		m.put("userId", userId);
		m.put("genre", genre);
		
		return sqlSession.selectList("SearchDAO.searchMovie", m);
	}
	
	@Override
	public List<HashMap> searchDirector(DirectorVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre) {	// ���� �̸����� �˻�
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("directorName", vo.getDirectorName());
		m.put("selectOrder", selectOrder);
		m.put("userId", userId);
		m.put("genre", genre);

		return sqlSession.selectList("SearchDAO.searchDirector", m);
	}

	@Override
	public List<HashMap> searchActor(ActorVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre) {	// ��� �̸����� �˻�
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("actorName", vo.getActorName());
		m.put("selectOrder", selectOrder);
		m.put("userId", userId);
		m.put("genre", genre);

		return sqlSession.selectList("SearchDAO.searchActor", m);
	}

	@Override
	public List<HashMap> searchKeywords(MovieVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre) {	// Ű����� �˻�
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("keyword", vo.getKeyword());
		m.put("selectOrder", selectOrder);
		m.put("userId", userId);
		m.put("genre", genre);
		
		return sqlSession.selectList("SearchDAO.searchKeywords", m);
	}

	@Override
	public int searchCountTitle(MovieVO vo, String genre) {	// ��ü ������ ��
		HashMap m = new HashMap();
		m.put("genre", genre);
		m.put("movieTitle", vo.getMovieTitle());
		
		return sqlSession.selectOne("SearchDAO.searchCountTitle", m);
	}

	@Override
	public int searchCountDirector(DirectorVO vo, String genre) {
		HashMap m = new HashMap();
		m.put("genre", genre);
		m.put("directorName", vo.getDirectorName());
		
		return sqlSession.selectOne("SearchDAO.searchCountDirector", m);
	}

	@Override
	public int searchCountActor(ActorVO vo, String genre) {
		HashMap m = new HashMap();
		m.put("genre", genre);
		m.put("actorName", vo.getActorName());
		
		return sqlSession.selectOne("SearchDAO.searchCountActor", m);

	}

	@Override
	public int searchCountKeywords(MovieVO vo, String genre) {
		HashMap m = new HashMap();
		m.put("genre", genre);
		m.put("keyword", vo.getKeyword());
		
		return sqlSession.selectOne("SearchDAO.searchCountKeywords", m);
	}

	@Override
	public int insertStarScore(CommentVO vo) {
		return sqlSession.insert("SearchDAO.insertStarScore", vo);
	}
}