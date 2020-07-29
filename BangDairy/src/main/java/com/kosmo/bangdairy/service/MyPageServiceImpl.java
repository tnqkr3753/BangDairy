package com.kosmo.bangdairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.MyPageDAO;
import com.kosmo.bangdairy.vo.AccountFormVO;

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
	
}
