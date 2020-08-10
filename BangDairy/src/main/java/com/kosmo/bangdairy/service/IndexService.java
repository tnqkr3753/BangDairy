package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface IndexService {
	public List<MovieVO> getMovieAsScore();
	public List<GenreVO> getHitsAsGenre();
	public List<MovieVO> getMovieWithGenre(HashMap hash);
	public GenreVO getGenreTitle(HashMap hash);
	public ActorVO getActorMovieWithWish(HashMap hash);
	public List<MovieVO> getMovieWithActor(ActorVO vo);
	public List<MovieVO> getMovieWithUserGenre(AccountFormVO vo); 
	public List<MovieVO> getUserMovies(String userId);
	public List<MovieVO> getRecommendedMovieDetail(List<MovieVO> list);
}
