package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;

public interface AdminDAO {
	public List<HashMap> getMovie(HashMap hash);
	public List<AccountFormVO> getUser(HashMap hash);
	public List<DairyVO> getDiary(HashMap hash);
}
