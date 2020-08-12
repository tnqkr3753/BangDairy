package com.kosmo.bangdairy.dao;





import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;

@Repository("accountFormDAO")
public class AccountFormDAOImpl implements AccountFormDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int selectIdCheck(String id) {
		List<Object> list = sqlSession.selectList("selectIdCheck", id);
		int result = list.size();
		return result;
	}

	@Override
	public int insertUser(AccountFormVO vo) {
		int result = sqlSession.insert("insertUser", vo);
		return result;
	}

	@Override
	public AccountFormVO signInUser(AccountFormVO vo) {
		return  sqlSession.selectOne("SignInUser", vo);
		
	}

	@Override
	public int selectEmailCheck(String email) {
		List<Object> list = sqlSession.selectList("selectEmailCheck", email);
		return list.size();
	}

	@Override
	public AccountFormVO checkForKakao(AccountFormVO vo) {
		return sqlSession.selectOne("AccountFormDAO.checkForKakao",vo);
	}

	@Override
	public int joinKakao(AccountFormVO vo) {
		return sqlSession.insert("AccountFormDAO.joinKakao",vo);
	}

	@Override
	public int updateAuthCode(AccountFormVO vo) {
		return sqlSession.update("AccountFormDAO.updateAuthCode",vo);
	}

	@Override
	public int updateAuthStatus(AccountFormVO vo) {
		return sqlSession.update("AccountFormDAO.updateAuthStatus",vo);
	}
	
	

}
