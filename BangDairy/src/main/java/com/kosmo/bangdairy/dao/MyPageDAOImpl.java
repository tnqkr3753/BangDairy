package com.kosmo.bangdairy.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;

@Repository("myPageDAO")
public class MyPageDAOImpl implements MyPageDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public AccountFormVO selectUserInfo(AccountFormVO vo) {
		return sqlSession.selectOne("MyPageDAO.selectUserInfo",vo);
	}

	@Override
	public int updateUserInfo(AccountFormVO vo) {
		return sqlSession.update("MyPageDAO.updateUserInfo",vo);
	}

	@Override
	public int deleteUserInfo(AccountFormVO vo) {
		return sqlSession.delete("MyPageDAO.deleteUserInfo",vo);
	}
	
	
}
