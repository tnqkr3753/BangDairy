package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface MovieDetailDAO {
	public MovieVO selectOneMovie(MovieVO vo);
	public List<GenreVO> selectMovieGenre(MovieVO vo);
	public List<HashMap> selectStarring(MovieVO vo);
	public List<DirectorVO> selectDirectors(MovieVO vo);
	public List<CommentVO> selectComments(HashMap hash);
	public HashMap getCommentCount(HashMap hash);
	public int insertComment(CommentVO vo);
	public int increaseHist(MovieVO vo);
	public int insertWishMovie(WishMovieVO vo);
	public List<StillVO> selectStill(MovieVO vo);
	
	public float selectDetailStarScore(MovieVO vo); // 영화 평점 얻어오기
}
