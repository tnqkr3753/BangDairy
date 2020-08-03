package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Repository("indexDAO")
public class IndexDAOImpl implements IndexDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<MovieVO> getMovieAsScore() {
		return sqlSession.selectList("IndexDAO.getMovieAsScore");
	}

	@Override
	public List<GenreVO> getHistAsGenre() {
		return sqlSession.selectList("IndexDAO.getHitsAsGenre");
	}

	@Override
	public List<MovieVO> getMovieWithGenre(HashMap hash) {
		return sqlSession.selectList("IndexDAO.getMovieAsGenre",hash);
	}

	@Override
	public GenreVO getGenreTitle(HashMap hash) {
		return sqlSession.selectOne("IndexDAO.getGenreTitle",hash);
	}
	
	
}
