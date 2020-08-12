package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.WishMovieVO;



public interface DairyUserDAO {
	
	public List<HashMap> userInfo(DairyVO vo);
	
	public List<DairyVO> updatehits(DairyVO vo);
	
	public List<AccountFormVO> leftUserInfo(DairyVO vo);
	
	public List<DairyVO> getOtherDairyList(DairyVO vo);
	
	public void upLike(DairyUserVO vo);
	
	public void upHate(DairyUserVO vo);
	
	public int checkLikes(DairyUserVO vo);
	
	public int checkHates(DairyUserVO vo);

	public List<WishMovieVO> selectWishMovie(DairyVO vo);
	
	public int countLikes(DairyUserVO vo);
	
	public int countHates(DairyUserVO vo);
	
	public void makeZero(DairyUserVO vo);
	
	public void insertZeroLike(DairyUserVO vo);
	
	public void insertZeroHate(DairyUserVO vo);
	
	public void updatelikes(DairyUserVO vo);
	
	public int selectlikes(DairyUserVO vo);
	
	public void updatehates(DairyUserVO vo);
	
	public int selecthates(DairyUserVO vo);

	public void insertZero(DairyUserVO vo);

	//페이징
	
	public int ocountoDiaryByUser(DairyVO vo); 
	
	public List<HashMap> odairyList(DairyVO vo, int firstRow, int endRow);

	

}
