package com.kosmo.bangdairy.service;


import java.util.List;

import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface MovieDetailService {
	public MovieVO selectOneMovie(MovieVO vo);
	public List<CommentVO> selectComments(String pageNum,String movieId);
	public int commentCount(String movieId);
}
