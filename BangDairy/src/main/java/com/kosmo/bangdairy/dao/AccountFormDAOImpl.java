package com.kosmo.bangdairy.dao;





import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;

@Repository("accountFormDAO")
public class AccountFormDAOImpl implements AccountFormDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public int selectIdCheck(String user_id) {
		List<Object> list = sqlSession.selectList("selectIdCheck", user_id);
		int result = list.size();
		return result;
	}

	@Override
	public int insertUser(AccountFormVO vo) {
		int result = sqlSession.insert("insertUser", vo);
		return result;
	}

}
