package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	@Override
	public List<HashMap> getMovie(HashMap hash) {
		return sqlSession.selectList("AdminDAO.getMovie", hash);
	}
	@Override
	public List<AccountFormVO> getUser(HashMap hash) {
		return sqlSession.selectList("AdminDAO.getUser",hash);
	}
	@Override
	public List<DairyVO> getDiary(HashMap hash) {
		return sqlSession.selectList("AdminDAO.getDiary",hash);
	}
	
}
