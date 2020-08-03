package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface IndexService {
	public List<MovieVO> getMovieAsScore();
	public List<GenreVO> getHitsAsGenre();
	public List<MovieVO> getMovieWithGenre(HashMap hash);
	public GenreVO getGenreTitle(HashMap hash);
}
