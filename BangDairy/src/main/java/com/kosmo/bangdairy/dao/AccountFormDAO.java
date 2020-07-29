package com.kosmo.bangdairy.dao;

import java.util.Map;

import com.kosmo.bangdairy.vo.AccountFormVO;

public interface AccountFormDAO {
	public int selectIdCheck(String id);
	public int selectEmailCheck(String email);
	public int insertUser(AccountFormVO vo);
	public int signInUser(AccountFormVO vo);
}
