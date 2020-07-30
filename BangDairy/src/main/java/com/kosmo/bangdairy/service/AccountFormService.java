package com.kosmo.bangdairy.service;

import java.util.Map;

import com.kosmo.bangdairy.vo.AccountFormVO;

public interface AccountFormService {
	public int idCheck(String id);
	public int emailCheck(String email);
	public int insertUser(AccountFormVO vo);
	public int signInUser(AccountFormVO vo);
}
