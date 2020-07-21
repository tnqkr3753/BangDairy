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
	public int insertActor(ActorVO vo);
	public int insertDirector(DirectorVO vo);
	public int insertStillImg(StillVO vo);
	public int insertMovie(MovieVO vo);
	public int insertStarring(HashMap hash);
	public int insertMovieDirector(HashMap hash);
	public int insertMovieGenre(HashMap hash);
}
