package com.kosmo.bangdairy.dao;

import com.kosmo.bangdairy.vo.AccountFormVO;

public interface AccountFormDAO {
	public int selectIdCheck(String user_id);
	public int insertUser(AccountFormVO vo);
}
