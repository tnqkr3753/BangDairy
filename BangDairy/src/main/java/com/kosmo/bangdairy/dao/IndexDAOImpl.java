package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.ActorVO;
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

	@Override
	public ActorVO getActorMovieWithWish(HashMap hash) {
		return sqlSession.selectOne("IndexDAO.getActorMovieWithWish",hash);
	}

	@Override
	public List<MovieVO> getMovieWithActor(ActorVO vo) {
		return sqlSession.selectList("IndexDAO.getMovieWithActor",vo);
	}

	@Override
	public ActorVO getActorName(ActorVO vo) {
		return sqlSession.selectOne("IndexDAO.getActorName", vo);
	}

	@Override
	public List<MovieVO> getMovieWithUserGenre(AccountFormVO vo) {
		return sqlSession.selectList("IndexDAO.getMovieWithUserGenre",vo);
	}
	
}
