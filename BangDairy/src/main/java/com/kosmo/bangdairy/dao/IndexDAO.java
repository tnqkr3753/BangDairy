package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface IndexDAO {
	public List<MovieVO> getMovieAsScore();
	public List<GenreVO> getHistAsGenre();
	public List<MovieVO> getMovieWithGenre(HashMap hash);
	public GenreVO getGenreTitle(HashMap hash);
}
