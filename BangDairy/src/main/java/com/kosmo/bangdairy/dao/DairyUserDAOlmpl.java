package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

@Repository("dairyUserDAO")
public class DairyUserDAOlmpl implements DairyUserDAO {
		
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<HashMap> userInfo(DairyVO vo) {
		return  sqlSession.selectList("dairyUserDAO.insertDiaryLike",vo);
	}
	
	@Override
	public List<DairyVO> updatehits(DairyVO vo){
		return sqlSession.selectList("dairyUserDAO.addhits",vo);
	}
	
	@Override
	public List<DairyVO> getOtherDairyList(DairyVO vo){
		return sqlSession.selectList("dairyUserDAO.otherdiarylist",vo);
	}
	
	@Override
	public List<WishMovieVO> selectWishMovie(DairyVO vo){
		return sqlSession.selectList("dairyUserDAO.selectwishmovie",vo);
	}
	
	@Override
	public List<AccountFormVO> leftUserInfo(DairyVO vo){
		return sqlSession.selectList("dairyUserDAO.leftInfo",vo);
	}
	
	//좋아요싫어요

	@Override
	public void upLike(DairyUserVO vo) {
		sqlSession.insert("dairyUserDAO.uplike",vo);
	}
	
	@Override
	public void upHate(DairyUserVO vo) {
		sqlSession.insert("dairyUserDAO.uphate",vo);
	}
	
	@Override
	public int checkLikes(DairyUserVO vo) {
		return  sqlSession.selectOne("dairyUserDAO.checklike", vo);
	}
	
	@Override
	public int checkHates(DairyUserVO vo) {
		return  sqlSession.selectOne("dairyUserDAO.checkhate", vo);
	}	
	
	@Override
	public int countLikes(DairyUserVO vo) {
		return  sqlSession.selectOne("dairyUserDAO.countlikes", vo);
	}
	
	@Override
	public int countHates(DairyUserVO vo) {
		return  sqlSession.selectOne("dairyUserDAO.counthates", vo);
	}	
	
	@Override
	public void makeZero(DairyUserVO vo) {
		sqlSession.delete("dairyUserDAO.makezero",vo);
	}
	
	@Override
	public void insertZero(DairyUserVO vo) {
		sqlSession.insert("dairyUserDAO.insertzero",vo);
	}
	
	@Override
	public void insertZeroLike(DairyUserVO vo) {
		sqlSession.insert("dairyUserDAO.insertzerolike",vo);
	}
	
	@Override
	public void insertZeroHate(DairyUserVO vo) {
		sqlSession.insert("dairyUserDAO.insertzerohate",vo);
	}
	
	@Override
	public void updatelikes(DairyUserVO vo) {
		sqlSession.update("dairyUserDAO.changelike",vo);
	}
	
	@Override
	public int selectlikes(DairyUserVO vo) {
		return  sqlSession.selectOne("dairyUserDAO.selectlike", vo);
	}
	
	@Override
	public void updatehates(DairyUserVO vo) {
		sqlSession.update("dairyUserDAO.changehate",vo);
	}
	
	@Override
	public int selecthates(DairyUserVO vo) {
		return  sqlSession.selectOne("dairyUserDAO.selecthate", vo);
	}

	
	@Override	
	public List<HashMap> odairyList(DairyVO vo, int firstRow, int endRow) {
		HashMap m = new HashMap();
		
		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("diaryId", vo.getDiaryId());
		
		return sqlSession.selectList("dairyUserDAO.odairylist", m);
	}

	@Override
	public int ocountoDiaryByUser(DairyVO vo) {
		return sqlSession.selectOne("dairyUserDAO.ocountodiarybyUser", vo);
	}

}
