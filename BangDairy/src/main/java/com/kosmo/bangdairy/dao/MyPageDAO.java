package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface MyPageDAO {
	public AccountFormVO selectUserInfo(AccountFormVO vo);
	public int updateUserInfo(AccountFormVO vo);
	public int deleteUserInfo(AccountFormVO vo);
	public List<WishMovieVO> selectWishMovie(WishMovieVO vo);
	public int deleteWishMovie(WishMovieVO vo);
}
