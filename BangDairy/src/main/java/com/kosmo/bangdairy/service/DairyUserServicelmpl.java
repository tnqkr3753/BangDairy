package com.kosmo.bangdairy.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.DairyUserDAO;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

@Service("dairyUserService")
public class DairyUserServicelmpl implements DairyUserService {
	
	@Autowired
	DairyUserDAO dairyUserDAO;
	
	int totalRecordCount;
	int pageTotalCount;
	int countPerPage = 10;
	int blockPageNumcount = 5;
	int totalDiaryCount;
	
	@Override
	public List<HashMap> userInfo(DairyVO vo) {
		return dairyUserDAO.userInfo(vo);

	}
	
	@Override
	public List<DairyVO> updatehits(DairyVO vo){
		return dairyUserDAO.updatehits(vo);
	}
	
	@Override
	public List<WishMovieVO> selectWishMovie(DairyVO vo){
		return dairyUserDAO.selectWishMovie(vo);
	}
	
	@Override
	public List<DairyVO> getOtherDairyList(DairyVO vo){
		return dairyUserDAO.getOtherDairyList(vo);
	}
	
	@Override
	public List<AccountFormVO> leftUserInfo(DairyVO vo){
		return dairyUserDAO.leftUserInfo(vo);
	}
	
	@Override
	public void upLike(DairyUserVO vo) {
		dairyUserDAO.upLike(vo);
	}
	
	@Override
	public void upHate(DairyUserVO vo) {
		dairyUserDAO.upHate(vo);
	}
	
	@Override
	public int checkLikes(DairyUserVO vo) {
		return dairyUserDAO.countLikes(vo);
	}
	
	@Override
	public int checkHates(DairyUserVO vo) {
		return dairyUserDAO.countHates(vo);
	}
	
	@Override
	public int countLikes(DairyUserVO vo) {
		return dairyUserDAO.countLikes(vo);
	}
	
	@Override
	public int countHates(DairyUserVO vo) {
		return dairyUserDAO.countHates(vo);
	}
	
	@Override
	public void makeZero(DairyUserVO vo) {
		dairyUserDAO.makeZero(vo);
	}
	
	@Override
	public void insertZero(DairyUserVO vo) {
		dairyUserDAO.insertZero(vo);
	}
	
	@Override
	public void insertZeroLike(DairyUserVO vo) {
		dairyUserDAO.insertZeroLike(vo);
	}
	
	@Override
	public void insertZeroHate(DairyUserVO vo) {
		dairyUserDAO.insertZeroHate(vo);
	}
	
	@Override
	public void updatelikes(DairyUserVO vo) {
		dairyUserDAO.updatelikes(vo);
	}
	
	@Override
	public int selectlikes(DairyUserVO vo) {
		return dairyUserDAO.selectlikes(vo);
	}
	
	@Override
	public void updatehates(DairyUserVO vo) {
		dairyUserDAO.updatehates(vo);
	}
	
	@Override
	public int selecthates(DairyUserVO vo) {
		return dairyUserDAO.selecthates(vo);
	}
	

	//페이징

	@Override
	public int ocountoDiaryByUser(DairyVO vo) {
		totalDiaryCount = dairyUserDAO.ocountoDiaryByUser(vo);
		pageTotalCount = totalDiaryCount/3;
		
		if (totalDiaryCount % 3 > 0) pageTotalCount++;
		
		return pageTotalCount;
	}
	
	@Override
	public List<HashMap> odairyList(DairyVO vo, int pNum) {
		int firstRow = (pNum-1) * 3;
		int endRow = 3;
		
		return dairyUserDAO.odairyList(vo, firstRow, endRow);
	}

	
	


}
