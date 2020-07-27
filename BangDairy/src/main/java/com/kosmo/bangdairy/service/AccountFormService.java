package com.kosmo.bangdairy.service;

import com.kosmo.bangdairy.vo.AccountFormVO;

public interface AccountFormService {
	public int idCheck(String user_id);
	public int insertUser(AccountFormVO vo);
	public int signInUser(AccountFormVO vo);
}
