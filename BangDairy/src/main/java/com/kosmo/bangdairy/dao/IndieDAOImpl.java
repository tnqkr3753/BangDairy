package com.kosmo.bangdairy.dao;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;

@Repository("indieDAO")
public class IndieDAOImpl implements IndieDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
//	진섭 : 전체 인서트 하고 
	@Override
	public void indieInsert(IndieVO ivo) {
		sqlSession.insert("indieInsert", ivo);	
	}
//	셀렉스토 받아와서 
	@Override
	public List<IndieGenreVO> selectId() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("indieGnareSelect");
	}
//	다시 아이디를 인서트
	@Override
	public void indiegenreInsert(IndieVO ivo) {
		sqlSession.insert("indieInsert", ivo);	
	}
	@Override
	public List<IndieVO> indieGnareSelect() {
		return sqlSession.selectList("indieGnareSelect");
	}
	
	
}
