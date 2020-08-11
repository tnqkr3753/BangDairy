package com.kosmo.bangdairy.service;


import java.util.List;

import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface MovieDetailService {
	public MovieVO selectOneMovie(MovieVO vo);
	public List<CommentVO> selectComments(String pageNum,String movieId);
	public int commentCount(String movieId);
	public int insertComment(CommentVO vo);
	public int insertWishMovie(WishMovieVO vo);
	public List<StillVO> selectStill(MovieVO vo);
	
	//public float selectDetailStarScore(MovieVO vo);
}
