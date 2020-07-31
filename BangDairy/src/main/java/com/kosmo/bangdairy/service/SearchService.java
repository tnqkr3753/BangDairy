package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface SearchService {
	public List<HashMap> searchMovie(MovieVO vo, int pNum, String selectOrder);		// 영화 제목으로 검색
	public List<HashMap> searchDirector(DirectorVO vo, int pNum, String selectOrder);	// 감독 이름으로 검색
	public List<HashMap> searchActor(ActorVO vo, int pNum, String selectOrder);	// 배우 이름으로 검색
	public List<HashMap> searchKeywords(MovieVO vo, int pNum, String selectOrder);	// 키워드로 검색
	
	public int searchCountTitle(MovieVO vo);	// 영화 제목으로 검색한 후 전체 페이지 수
	public int searchCountDirector(DirectorVO vo);
	public int searchCountActor(ActorVO vo);
	public int searchCountKeywords(MovieVO vo);
}
