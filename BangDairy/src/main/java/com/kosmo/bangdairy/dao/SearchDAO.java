package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface SearchDAO {	
	public List<HashMap> searchMovie(MovieVO vo, int firstRow, int endRow, String selectOrder);		// 영화 제목으로 검색
	public List<HashMap> searchDirector(DirectorVO vo, int firstRow, int endRow, String selectOrder);	// 감독 이름으로 검색
	public List<HashMap> searchActor(ActorVO vo, int firstRow, int endRow, String selectOrder);	// 배우 이름으로 검색
	public List<HashMap> searchKeywords(MovieVO vo, int firstRow, int endRow, String selectOrder);	// 키워드로 검색
	
	public int searchCountTitle(MovieVO vo);	// 전체 페이지 수
	public int searchCountDirector(DirectorVO vo);
	public int searchCountActor(ActorVO vo);
	public int searchCountKeywords(MovieVO vo);
};
