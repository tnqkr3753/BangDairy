package com.kosmo.bangdairy.dao;

import java.util.HashMap;

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
	public int insertActor(ActorVO vo) {
		return sqlSession.insert("ThreadInsertDAO.insertActor", vo);
	}

	@Override
	public int insertDirector(DirectorVO vo) {
		return sqlSession.insert("ThreadInsertDAO.insertDirector", vo);
	}

	@Override
	public int insertStillImg(StillVO vo) {
		return sqlSession.insert("ThreadInsertDAO.insertStill", vo);
	}

	@Override
	public int insertMovie(MovieVO vo) {
		return sqlSession.insert("ThreadInsertDAO.insertMovie", vo);
	}

	@Override
	public int insertStarring(HashMap hash) {
		return sqlSession.insert("ThreadInsertDAO.insertStarring", hash);
	}


	@Override
	public int insertMovieDirector(HashMap hash) {
		return sqlSession.insert("ThreadInsertDAO.insertMovieDirector", hash);
	}

	@Override
	public int insertMovieGenre(HashMap hash) {
		return sqlSession.insert("ThreadInsertDAO.insertMovieGenre", hash);
	}

	@Override
	public ActorVO selectActorInfo(ActorVO vo) {
		return sqlSession.selectOne("ThreadInsertDAO.selectActor",vo);
	}

	@Override
	public DirectorVO selectDirectorInfo(DirectorVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ThreadInsertDAO.selectDirector",vo);
	}
	
}
