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

	/*
	 * // 다시 아이디를 인서트
	 * 
	 * @Override public void indiegenreInsert(IndieVO ivo) {
	 * sqlSession.insert("indieInsert", ivo); }
	 */
	
	
	
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
	public int selectTotalCount() { 
		return  sqlSession.selectOne("selectTotalCount");
		  }

	@Override
	public List<HashMap> selectIndiepaging(int firstRow,int endRow) {
        HashMap<String, Integer> m = new HashMap<String, Integer>();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		System.out.println("^^^^^^^^^^%$$^$%^$%^%^%^#^#$%@#@!%^&*^%$#@$%^&%$#@$%^&*");
		System.out.println("1번"+firstRow);
		System.out.println("2번"+endRow);
		
		return sqlSession.selectList("selectIndiepaging",m);
	}

	@Override
	public int goodInsert(int goodId1, String userId) {
	    HashMap<String, Object> m2 = new HashMap<String, Object>();
	    m2.put("goodId1",goodId1);
	    m2.put("userId",userId);
	    System.out.println("1번"+goodId1);
		System.out.println("2번"+userId);
		
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
	    System.out.println("3번"+goodId1);
		System.out.println("4번"+userId);
		
		return sqlSession.selectOne("selectEqulegood", m3);	
}
	
	
@Override
public int selectEqulebad(int badIdInt, String userId) {
    HashMap<String, Object> m3 = new HashMap<String, Object>();
    m3.put("badIdInt",badIdInt);
    m3.put("userId",userId);
    System.out.println("3번"+badIdInt);
	System.out.println("4번"+userId);
	
	return sqlSession.selectOne("selectEqulegood", m3);	
}
	@Override
	public int selectHateNum(int goodi1, String userId) {
		 HashMap<String, Object> m3 = new HashMap<String, Object>();
		    m3.put("goodId1",goodi1);
		    m3.put("userId",userId);
		    System.out.println("3번"+goodi1);
			System.out.println("4번"+userId);
			
			return sqlSession.selectOne("selectHateNum", m3);
	
	}
	
	
	public int selectLikeNum(int badIdInt, String userId) {
		 HashMap<String, Object> m3 = new HashMap<String, Object>();
		    m3.put("goodId1",badIdInt);
		    m3.put("userId",userId);
		    System.out.println("3번"+badIdInt);
			System.out.println("4번"+userId);
			
			return sqlSession.selectOne("selectLikeNum", m3);
	
	}
	
	
	

	@Override
	public void updateLike(int goodi1, String userId) {
		 HashMap<String, Object> m3 = new HashMap<String, Object>();
		    m3.put("goodId1",goodi1);
		    m3.put("userId",userId);
		    System.out.println("3번"+goodi1);
			System.out.println("4번"+userId);
			
			 sqlSession.update("updateLike", m3);
	
	}
	
	@Override
	public void updateHate(int badIdInt, String userId) {
		 HashMap<String, Object> m3 = new HashMap<String, Object>();
		    m3.put("badIdInt",badIdInt);
		    m3.put("userId",userId);
		    System.out.println("3번"+badIdInt);
			System.out.println("4번"+userId);
			
			 sqlSession.update("updateHate", m3);
	
	}
	
	}

