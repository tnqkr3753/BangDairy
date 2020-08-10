package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface SearchService {
	public List<HashMap> searchMovie(MovieVO vo, int pNum, String selectOrder, String userId, String genre);		// ��ȭ �������� �˻�
	public List<HashMap> searchDirector(DirectorVO vo, int pNum, String selectOrder, String userId, String genre);	// ���� �̸����� �˻�
	public List<HashMap> searchActor(ActorVO vo, int pNum, String selectOrder, String userId, String genre);	// ��� �̸����� �˻�
	public List<HashMap> searchKeywords(MovieVO vo, int pNum, String selectOrder, String userId, String genre);	// Ű����� �˻�
	
	public int searchCountTitle(MovieVO vo, String genre);	// ��ȭ �������� �˻��� �� ��ü ������ ��
	public int searchCountDirector(DirectorVO vo, String genre);
	public int searchCountActor(ActorVO vo, String genre);
	public int searchCountKeywords(MovieVO vo, String genre);
	
	public int insertStarScore(CommentVO vo); // 사용자가 입력한 평점 DB에 INSERT
}
