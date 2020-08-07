package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.AdminDAO;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO adminDAO;

	@Override
	public List<HashMap> getMovie(HashMap hash) {
		return adminDAO.getMovie(hash);
	}

	@Override
	public List<AccountFormVO> getUser(HashMap hash) {
		return adminDAO.getUser(hash);
	}

	@Override
	public List<DairyVO> getDiary(HashMap hash) {
		return adminDAO.getDiary(hash);
	}
	
}
