package com.kosmo.bangdairy.dao;


import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;

public interface ThreadInsertDAO {
	public int insertGenre(GenreVO vo);
	public int insertActor(List<ActorVO> list);
	public int insertDirector(List<DirectorVO> list);
	public int insertStillImg(List<StillVO> list);
	public int insertMovie(MovieVO list);
	public int insertStarring(List<HashMap> list);
	public int insertMovieDirector(HashMap vo);
	public int insertMovieGenre(List<HashMap> list);
	public ActorVO selectActorInfo(ActorVO vo);
	public DirectorVO selectDirectorInfo(DirectorVO vo);
	public GenreVO selectGenreInfo(GenreVO vo);
	public int updateMovieOpening(List<MovieVO> list);
}
