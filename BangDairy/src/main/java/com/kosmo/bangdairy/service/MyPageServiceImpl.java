package com.kosmo.bangdairy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.MyPageDAO;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

@Service("myPageService")
public class MyPageServiceImpl implements MyPageService {
	@Autowired
	MyPageDAO myPageDAO;

	@Override
	public AccountFormVO selectUserInfo(AccountFormVO vo) {
		return myPageDAO.selectUserInfo(vo);
	}

	@Override
	public int updateUserInfo(AccountFormVO vo) {
		return myPageDAO.updateUserInfo(vo);
	}

	@Override
	public int deleteUserInfo(AccountFormVO vo) {
		return myPageDAO.deleteUserInfo(vo);
	}

	@Override
	public List<WishMovieVO> selectWishMovie(WishMovieVO vo) {
		return myPageDAO.selectWishMovie(vo);
	}

	@Override
	public int deleteWishMovie(WishMovieVO vo) {
		return myPageDAO.deleteWishMovie(vo);
	}
	
	
}
