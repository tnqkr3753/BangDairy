package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.IndexDAO;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Service("indexService")
public class IndexServiceImpl implements IndexService {
	@Autowired
	IndexDAO indexDAO;

	@Override
	public List<MovieVO> getMovieAsScore() {
		return indexDAO.getMovieAsScore();
	}

	@Override
	public List<GenreVO> getHitsAsGenre() {
		return indexDAO.getHistAsGenre();
	}

	@Override
	public List<MovieVO> getMovieWithGenre(HashMap hash) {
		return indexDAO.getMovieWithGenre(hash);
	}

	@Override
	public GenreVO getGenreTitle(HashMap hash) {
		return indexDAO.getGenreTitle(hash);
	}

	@Override
	public ActorVO getActorMovieWithWish(HashMap hash) {
		ActorVO vo = indexDAO.getActorMovieWithWish(hash);
		vo = indexDAO.getActorName(vo);
		return vo;
	}

	@Override
	public List<MovieVO> getMovieWithActor(ActorVO vo) {
		return indexDAO.getMovieWithActor(vo);
	}

	@Override
	public List<MovieVO> getMovieWithUserGenre(AccountFormVO vo) {
		return indexDAO.getMovieWithUserGenre(vo);
	}

	@Override
	public List<MovieVO> getUserMovies(String userId) {
		return indexDAO.getUserMovies(userId);
	}

	@Override
	public List<MovieVO> getRecommendedMovieDetail(List<MovieVO> list) {
		
		return indexDAO.getRecommendedMovieDetail(list);
	}
	
	
	
	
}
