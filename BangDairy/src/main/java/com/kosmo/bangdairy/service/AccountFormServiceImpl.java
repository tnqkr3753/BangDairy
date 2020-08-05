package com.kosmo.bangdairy.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.AccountFormDAOImpl;
import com.kosmo.bangdairy.vo.AccountFormVO;

@Service("accountFormService")
public class AccountFormServiceImpl implements AccountFormService {
	
	@Autowired
	private AccountFormDAOImpl accountFormDAO;
	
	@Override
	public int idCheck(String id) {
		int result = accountFormDAO.selectIdCheck(id);
		return result;
	}

	@Override
	public int insertUser(AccountFormVO vo) {
		int result = accountFormDAO.insertUser(vo);
		return result;
	}

	@Override
	public int signInUser(AccountFormVO vo) {
		int result = accountFormDAO.signInUser(vo);
		return result;
	}

	@Override
	public int emailCheck(String email) {
		int result = accountFormDAO.selectEmailCheck(email);
		return result;
	}

	@Override
	public AccountFormVO checkForKakao(AccountFormVO vo) {
		return accountFormDAO.checkForKakao(vo);
	}

	@Override
	public int joinKakao(AccountFormVO vo) {
		return accountFormDAO.insertUser(vo);
	}
	
	
}
