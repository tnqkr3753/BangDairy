package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface SearchDAO {	
	public List<HashMap> searchMovie(MovieVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre);		// ��ȭ �������� �˻�
	public List<HashMap> searchDirector(DirectorVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre);	// ���� �̸����� �˻�
	public List<HashMap> searchActor(ActorVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre);	// ��� �̸����� �˻�
	public List<HashMap> searchKeywords(MovieVO vo, int firstRow, int endRow, String selectOrder, String userId, String genre);	// Ű����� �˻�
	
	public int searchCountTitle(MovieVO vo, String genre);	// ��ü ������ ��
	public int searchCountDirector(DirectorVO vo, String genre);
	public int searchCountActor(ActorVO vo, String genre);
	public int searchCountKeywords(MovieVO vo, String genre);
	
	public int insertStarScore(CommentVO vo); // 사용자가 입력한 평점 DB에 INSERT
}
