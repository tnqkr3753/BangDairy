package com.kosmo.bangdairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosmo.bangdairy.dao.AccountFormDAOImpl;
import com.kosmo.bangdairy.dao.IndieDAO;
import com.kosmo.bangdairy.dao.IndieDAOImpl;
import com.kosmo.bangdairy.dao.SearchDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.MovieVO;


@Service("indieSevice")
public class IndieSeviceImpl implements IndieSevice {

	@Autowired
	private IndieDAOImpl indieDAO;
	
	@Override
	public void indieInsert(IndieVO ivo) {
		indieDAO.indieInsert(ivo);	
	}
	
	
	
	@Override
	public List<IndieVO> indieGnareSelect() {
		return 	indieDAO.indieGnareSelect();
	}
//	@Override
//	public void indiegenreInsert(IndieVO ivo) {
//		indieDAO.indieInsert(ivo);
//		
//	}

	public IndieVO selectIndieDetail(IndieVO ivo){
		return indieDAO.selectIndieDetail(ivo);
		
		
	}
	
	@Override
	public List<IndieVO> selectIndieInfo() {
		return indieDAO.selectIndieInfo();
		 
	}
	@Autowired
	IndieDAO IndieDAO;
	int totalRecordCount;
	int pageTotalCount;
	int countPerPage = 10;	// �� �������� �� ���ڵ� ����
	int blockPageNumcount = 5;

	@Override
	public List<HashMap> searchCountTitle1(int pNum) {
		int firstRow = (pNum-1)*countPerPage;
		int endRow = 10;
		
		return indieDAO.searchCountTitle1( firstRow, endRow);
	}
	




	

}
