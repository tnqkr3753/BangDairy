package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.SearchDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchDAO searchDAO;
	int totalRecordCount;
	int pageTotalCount;
	int countPerPage = 10;	// �� �������� �� ���ڵ� ����
	int blockPageNumcount = 5; // ���� �����ϴ� ������ ����

	@Override
	public List<HashMap> searchMovie(MovieVO vo, int pNum, String selectOrder, String userId, String genre) {		// ��ȭ �������� �˻�
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow ���� �׻� 10!

		return searchDAO.searchMovie(vo, firstRow, endRow, selectOrder, userId, genre);
	}

	@Override
	public List<HashMap> searchDirector(DirectorVO vo, int pNum, String selectOrder, String userId, String genre) {	// ���� �̸����� �˻�
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow ���� �׻� 10!
		
		return searchDAO.searchDirector(vo, firstRow, endRow, selectOrder, userId, genre);		
	}

	@Override
	public List<HashMap> searchActor(ActorVO vo, int pNum, String selectOrder, String userId, String genre) {	// ��� �̸����� �˻�
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow ���� �׻� 10!
		
		return searchDAO.searchActor(vo, firstRow, endRow, selectOrder, userId, genre);		
	}

	@Override
	public List<HashMap> searchKeywords(MovieVO vo, int pNum, String selectOrder, String userId, String genre) {	// Ű����� �˻�
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow ���� �׻� 10!
		
		return searchDAO.searchKeywords(vo, firstRow, endRow, selectOrder, userId, genre);
	}

	@Override
	public int searchCountTitle(MovieVO vo, String genre) {	// ��ȭ �̸����� �˻����� �� ��ü ������ ��
		totalRecordCount = searchDAO.searchCountTitle(vo, genre);	// ��ü ���ڵ�(rows) ����
		
		pageTotalCount = totalRecordCount/countPerPage; // ��ü������ ��, ��ü ���ڵ� ��/�������� ���ڵ� ��
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}

	@Override
	public int searchCountDirector(DirectorVO vo, String genre) {	// ���� �̸����� �˻����� �� ��ü ������ ��
		totalRecordCount = searchDAO.searchCountDirector(vo, genre);	// ��ü ���ڵ�(rows) ����
		
		pageTotalCount = totalRecordCount/countPerPage; // ��ü������ ��, ��ü ���ڵ� ��/�������� ���ڵ� ��
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}

	@Override
	public int searchCountActor(ActorVO vo, String genre) {	// ��� �̸����� �˻����� �� ��ü ������ ��
		totalRecordCount = searchDAO.searchCountActor(vo, genre);	// ��ü ���ڵ�(rows) ����
		
		pageTotalCount = totalRecordCount/countPerPage; // ��ü������ ��, ��ü ���ڵ� ��/�������� ���ڵ� ��
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}

	@Override
	public int searchCountKeywords(MovieVO vo, String genre) {	// Ű����� �˻����� �� ��ü ������ ��
		totalRecordCount = searchDAO.searchCountKeywords(vo, genre);	// ��ü ���ڵ�(rows) ����
		
		pageTotalCount = totalRecordCount/countPerPage; // ��ü������ ��, ��ü ���ڵ� ��/�������� ���ڵ� ��
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}
	
	// 사용자가 입력한 평점 DB에 INSERT
	@Override
	public int insertStarScore(CommentVO vo) {
		return searchDAO.insertStarScore(vo);
	}
}
