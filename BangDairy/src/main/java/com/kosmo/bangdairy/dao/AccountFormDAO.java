package com.kosmo.bangdairy.dao;

import java.util.List;
import java.util.Map;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface AccountFormDAO {
	public int selectIdCheck(String id);
	public int selectEmailCheck(String email);
	public int insertUser(AccountFormVO vo);
	public int signInUser(AccountFormVO vo);
	public AccountFormVO checkForKakao(AccountFormVO vo);
	public int joinKakao(AccountFormVO vo);
	
}
