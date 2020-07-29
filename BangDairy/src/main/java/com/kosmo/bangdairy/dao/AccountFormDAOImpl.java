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
	public int signInUser(AccountFormVO vo) {
		int result = sqlSession.selectOne("SignInUser", vo);
		return result;
	}

	@Override
	public int selectEmailCheck(String email) {
		List<Object> list = sqlSession.selectList("selectEmailCheck", email);
		return list.size();
	}

}
