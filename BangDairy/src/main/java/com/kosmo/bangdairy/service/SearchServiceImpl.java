package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.SearchDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	SearchDAO searchDAO;
	int totalRecordCount;
	int pageTotalCount;
	int countPerPage = 10;	// 한 페이지에 들어갈 레코드 개수
	int blockPageNumcount = 5; // 블럭에 존재하는 페이지 개수

	@Override
	public List<HashMap> searchMovie(MovieVO vo, int pNum) {		// 영화 제목으로 검색
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow 값은 항상 10!

		return searchDAO.searchMovie(vo, firstRow, endRow);
	}

	@Override
	public List<HashMap> searchDirector(DirectorVO vo, int pNum) {	// 감독 이름으로 검색
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow 값은 항상 10!
		
		return searchDAO.searchDirector(vo, firstRow, endRow);		
	}

	@Override
	public List<HashMap> searchActor(ActorVO vo, int pNum) {	// 배우 이름으로 검색
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow 값은 항상 10!
		
		return searchDAO.searchActor(vo, firstRow, endRow);		
	}

	@Override
	public List<HashMap> searchKeywords(MovieVO vo, int pNum) {	// 키워드로 검색
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;	// Limit firstRow, endRow : endRow 값은 항상 10!
		
		return searchDAO.searchKeywords(vo, firstRow, endRow);
	}

	@Override
	public int searchCountTitle(MovieVO vo) {	// 영화 이름으로 검색했을 때 전체 페이지 수
		totalRecordCount = searchDAO.searchCountTitle(vo);	// 전체 레코드(rows) 개수
		
		pageTotalCount = totalRecordCount/countPerPage; // 전체페이지 수, 전체 레코드 수/페이지당 레코드 수
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}

	@Override
	public int searchCountDirector(DirectorVO vo) {	// 감독 이름으로 검색했을 때 전체 페이지 수
		totalRecordCount = searchDAO.searchCountDirector(vo);	// 전체 레코드(rows) 개수
		
		pageTotalCount = totalRecordCount/countPerPage; // 전체페이지 수, 전체 레코드 수/페이지당 레코드 수
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}

	@Override
	public int searchCountActor(ActorVO vo) {	// 배우 이름으로 검색했을 때 전체 페이지 수
		totalRecordCount = searchDAO.searchCountActor(vo);	// 전체 레코드(rows) 개수
		
		pageTotalCount = totalRecordCount/countPerPage; // 전체페이지 수, 전체 레코드 수/페이지당 레코드 수
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}

	@Override
	public int searchCountKeywords(MovieVO vo) {	// 키워드로 검색했을 때 전체 페이지 수
		totalRecordCount = searchDAO.searchCountKeywords(vo);	// 전체 레코드(rows) 개수
		
		pageTotalCount = totalRecordCount/countPerPage; // 전체페이지 수, 전체 레코드 수/페이지당 레코드 수
		
		if (totalRecordCount % countPerPage > 0) pageTotalCount++;
		
		return pageTotalCount;
	}
}
