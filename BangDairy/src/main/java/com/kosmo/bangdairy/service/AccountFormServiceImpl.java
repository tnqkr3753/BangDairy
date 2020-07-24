package com.kosmo.bangdairy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.AccountFormDAOImpl;

@Service("accountFormService")
public class AccountFormServiceImpl implements AccountFormService {
	
	@Autowired
	private AccountFormDAOImpl accountFormDAO;
	
	@Override
	public int idCheck(String user_id) {
		int result = accountFormDAO.selectIdCheck(user_id);
		return result;
	}

}
