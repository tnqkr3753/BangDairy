package com.kosmo.bangdairy.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;
import com.kosmo.bangdairy.vo.WishMovieVO;
@Repository("MovieDetailDAO")
public class MovieDetailDAOImpl implements MovieDetailDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public MovieVO selectOneMovie(MovieVO vo) {
		return sqlSession.selectOne("MovieDetailDAO.selectMovie",vo);
	}
	@Override
	public List<GenreVO> selectMovieGenre(MovieVO vo) {
		List<GenreVO> gvo =sqlSession.selectList("MovieDetailDAO.selectGenre",vo);
		LoggerAspect.logger.info(gvo);
//		return sqlSession.selectList("MovieDetailDAO.selectGenre");
		return gvo;
	}
	@Override
	public List<HashMap> selectStarring(MovieVO vo) {
		return  sqlSession.selectList("MovieDetailDAO.selectStarring",vo);
	}
	@Override
	public List<DirectorVO> selectDirectors(MovieVO vo) {
		return  sqlSession.selectList("MovieDetailDAO.selectDirectors",vo);
	}
	@Override
	public List<CommentVO> selectComments(HashMap hash) {
		return sqlSession.selectList("MovieDetailDAO.selectComment",hash);
	}
	@Override
	public HashMap getCommentCount(HashMap hash) {
		return sqlSession.selectOne("MovieDetailDAO.getCommentCount", hash);
	}
	@Override
	public int insertComment(CommentVO vo) {
		return sqlSession.insert("MovieDetailDAO.insertComment",vo);
	}
	@Override
	public int increaseHist(MovieVO vo) {
		return sqlSession.update("MovieDetailDAO.increaseHits",vo);
	}
	@Override
	public int insertWishMovie(WishMovieVO vo) {
		return sqlSession.insert("MovieDetailDAO.insertWishMovie",vo);
	}
	@Override
	public List<StillVO> selectStill(MovieVO vo) {
		return sqlSession.selectList("MovieDetailDAO.getStill",vo);
	}
	

}
