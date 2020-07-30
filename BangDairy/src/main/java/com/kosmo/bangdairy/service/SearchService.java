package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface SearchService {
	public List<HashMap> searchMovie(MovieVO vo, int pNum);		// ��ȭ �������� �˻�
	public List<HashMap> searchDirector(DirectorVO vo, int pNum);	// ���� �̸����� �˻�
	public List<HashMap> searchActor(ActorVO vo, int pNum);	// ��� �̸����� �˻�
	public List<HashMap> searchKeywords(MovieVO vo, int pNum);	// Ű����� �˻�
	
	public int searchCountTitle(MovieVO vo);	// ��ȭ �������� �˻��� �� ��ü ������ ��
	public int searchCountDirector(DirectorVO vo);
	public int searchCountActor(ActorVO vo);
	public int searchCountKeywords(MovieVO vo);
}
