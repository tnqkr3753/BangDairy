package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface SearchDAO {	
	public List<HashMap> searchMovie(MovieVO vo, int firstRow, int endRow, String selectOrder);		// ��ȭ �������� �˻�
	public List<HashMap> searchDirector(DirectorVO vo, int firstRow, int endRow, String selectOrder);	// ���� �̸����� �˻�
	public List<HashMap> searchActor(ActorVO vo, int firstRow, int endRow, String selectOrder);	// ��� �̸����� �˻�
	public List<HashMap> searchKeywords(MovieVO vo, int firstRow, int endRow, String selectOrder);	// Ű����� �˻�
	
	public int searchCountTitle(MovieVO vo);	// ��ü ������ ��
	public int searchCountDirector(DirectorVO vo);
	public int searchCountActor(ActorVO vo);
	public int searchCountKeywords(MovieVO vo);
};
