package com.kosmo.bangdairy.service;

import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.QnaVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

public interface MyPageService {
	public AccountFormVO selectUserInfo(AccountFormVO vo);
	public int updateUserInfo(AccountFormVO vo);
	public int deleteUserInfo(AccountFormVO vo);
	public List<WishMovieVO> selectWishMovie(WishMovieVO vo);
	public int deleteWishMovie(WishMovieVO vo);
	public List<QnaVO> selectQnaList(QnaVO vo);
	public int insertQna(QnaVO vo);
	public QnaVO selectQna(QnaVO vo);
	public AccountFormVO checkUser(AccountFormVO vo);
}
