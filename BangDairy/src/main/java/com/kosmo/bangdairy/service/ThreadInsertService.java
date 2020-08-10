package com.kosmo.bangdairy.service;

import java.util.List;

import com.kosmo.bangdairy.vo.MovieVO;

public interface ThreadInsertService {
	public void insertMovie(List<MovieVO> vo);
	public void updateMovieOpening(List<MovieVO> vo);
	public void insertStill(List<MovieVO> vo);
	public MovieVO getLastUpdate();
}
