package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface MovieDetailDAO {
	public MovieVO selectOneMovie(MovieVO vo);
	public List<GenreVO> selectMovieGenre(MovieVO vo);
	public List<HashMap> selectStarring(MovieVO vo);
	public List<DirectorVO> selectDirectors(MovieVO vo);
}
