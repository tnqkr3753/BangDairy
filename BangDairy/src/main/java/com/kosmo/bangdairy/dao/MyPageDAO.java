package com.kosmo.bangdairy.dao;

import com.kosmo.bangdairy.vo.AccountFormVO;

public interface MyPageDAO {
	public AccountFormVO selectUserInfo(AccountFormVO vo);
	public int updateUserInfo(AccountFormVO vo);
	public int deleteUserInfo(AccountFormVO vo);
}
