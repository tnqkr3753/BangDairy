package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;
@Repository("threadInsertDAO")
public class ThreadInsertDAOImpl implements ThreadInsertDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public int insertGenre(GenreVO vo) {
		return sqlSession.insert("ThreadInsertDAO.insertGenre", vo);
	}

	@Override
	public int insertActor(List<ActorVO> list) {
		return sqlSession.insert("ThreadInsertDAO.insertActor", list);
	}

	@Override
	public int insertDirector(List<DirectorVO> list) {
		return sqlSession.insert("ThreadInsertDAO.insertDirector", list);
	}

	@Override
	public int insertStillImg(List<StillVO> list) {
		return sqlSession.insert("ThreadInsertDAO.insertStill", list);
	}

	@Override
	public int insertMovie(MovieVO list) {
		return sqlSession.insert("ThreadInsertDAO.insertMovie", list);
	}

	@Override
	public int insertStarring(List<HashMap> list) {
		return sqlSession.insert("ThreadInsertDAO.insertStarring", list);
	}


	@Override
	public int insertMovieDirector(HashMap hash) {
		return sqlSession.insert("ThreadInsertDAO.insertMovieDirector", hash);
	}

	@Override
	public int insertMovieGenre(List<HashMap> list) {
		return sqlSession.insert("ThreadInsertDAO.insertMovieGenre", list);
	}
	
	@Override
	public ActorVO selectActorInfo(ActorVO vo) {
		return sqlSession.selectOne("ThreadInsertDAO.selectActor",vo);
	}

	@Override
	public DirectorVO selectDirectorInfo(DirectorVO vo) {
		return sqlSession.selectOne("ThreadInsertDAO.selectDirector",vo);
	}

	@Override
	public GenreVO selectGenreInfo(GenreVO vo) {
		return sqlSession.selectOne("ThreadInsertDAO.selectGenre",vo);
	}

	@Override
	public int updateMovieOpening(List<MovieVO> list) {
		// TODO Auto-generated method stub
		return sqlSession.update("ThreadInsertDAO.updateMovieOpening",list);
	}

	@Override
	public MovieVO getLastUpdate() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ThreadInsertDAO.getLastUpdate");
	}	
	
	
}
