package com.kosmo.bangdairy.dao;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	@Override
	public List<IndieVO> indieGnareSelect() {
		return sqlSession.selectList("indieGnareSelect");
	}

	@Override
	public List<IndieVO> selectIndieInfo() {
		
		return sqlSession.selectList("selectIndieInfo");
	}

	
	  @Override 
	public IndieVO  selectIndieDetail(IndieVO ivo) { 
			 return  sqlSession.selectOne("selectIndieDetail", ivo);
	  }
	  @Override 
	public int selectTotalCount(HashMap hash) { 
		return  sqlSession.selectOne("selectTotalCount",hash);
		  }

	@Override
	public List<HashMap> selectIndiepaging(int firstRow,int endRow,String searchWord) {
        HashMap m = new HashMap();
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("searchWord", searchWord);
		return sqlSession.selectList("selectIndiepaging",m);
	}

	@Override
	public int goodInsert(int goodId1, String userId) {
	    HashMap<String, Object> m2 = new HashMap<String, Object>();
	    m2.put("goodId1",goodId1);
	    m2.put("userId",userId);
		
		return sqlSession.insert("goodInsert", m2);
		
	}
	@Override
	public int badInsert(int badid1, String userId) {
	    HashMap<String, Object> m2 = new HashMap<String, Object>();
	    m2.put("goodId1",badid1);
	    m2.put("userId",userId);
	    System.out.println("3번"+badid1);
		System.out.println("4번"+userId);
		
		return sqlSession.insert("badInsert", m2);
		
	} 
	@Override
	public int selectEqulegood(int goodId1, String userId) {
	    HashMap<String, Object> m3 = new HashMap<String, Object>();
	    m3.put("goodId1",goodId1);
	    m3.put("userId",userId);
		return sqlSession.selectOne("selectEqulegood", m3);
	}

	@Override
	public int selectNull(int goodi1, String userId) {
		 HashMap<String, Object> m3 = new HashMap<String, Object>();
		    m3.put("goodId1",goodi1);
		    m3.put("userId",userId);
			return sqlSession.selectOne("selectNull", m3);
	}
	@Override
	public int increaseHits(IndieVO vo) {
		return sqlSession.update("IndieDAO.increaseHits",vo);
	}
	
	
}
