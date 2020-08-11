package com.kosmo.bangdairy.service;

import java.util.Map;

import com.kosmo.bangdairy.vo.AccountFormVO;

public interface AccountFormService {
	public int idCheck(String id);
	public int emailCheck(String email);
	public int insertUser(AccountFormVO vo);
	public AccountFormVO signInUser(AccountFormVO vo);
	public AccountFormVO checkForKakao(AccountFormVO vo);
	public int joinKakao(AccountFormVO vo);
	public void sendEmail(AccountFormVO vo);
	public int updateAuthStatus(AccountFormVO vo);
}
