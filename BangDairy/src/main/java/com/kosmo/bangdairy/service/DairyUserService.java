package com.kosmo.bangdairy.service;



import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface DairyUserService {

	    public List<HashMap> userInfo(DairyVO vo) throws Exception;
	    
	    public List<DairyVO> updatehits(DairyVO vo) throws Exception;
	    
	    public List<AccountFormVO> leftUserInfo(DairyVO vo) throws Exception;
	    
	    public List<DairyVO> getOtherDairyList(DairyVO vo) throws Exception;
	    
	    public List<WishMovieVO> selectWishMovie(DairyVO vo) throws Exception;
	    
	    public void upLike(DairyUserVO vo) throws Exception;
	    
	    public void upHate(DairyUserVO vo) throws Exception;
	    
	    public int checkLikes(DairyUserVO vo) throws Exception;
	    
	    public int checkHates(DairyUserVO vo) throws Exception;
	    
	    public int countLikes(DairyUserVO vo) throws Exception;
	    
	    public int countHates(DairyUserVO vo) throws Exception;
	    
	    public void makeZero(DairyUserVO vo) throws Exception;
	    
	    public void insertZeroLike(DairyUserVO vo) throws Exception;;
	    
	    public void insertZeroHate(DairyUserVO vo) throws Exception;;
	    
	    public int selectlikes(DairyUserVO vo) throws Exception;
	    
	    public void updatelikes(DairyUserVO vo) throws Exception;
	    	    
	    public int selecthates(DairyUserVO vo) throws Exception;
	    
	    public void updatehates(DairyUserVO vo) throws Exception;

		public void insertZero(DairyUserVO vo) throws Exception;

		//페이징
		
		public int ocountoDiaryByUser(DairyVO vo); 
		
		public List<HashMap> odairyList(DairyVO vo, int pNum);

	
}

