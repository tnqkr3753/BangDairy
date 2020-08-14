package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.QnaVO;

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
	@Override
	public List<HashMap> getComment(HashMap hash) {
		return sqlSession.selectList("AdminDAO.getComment",hash);
	}
	@Override
	public List<QnaVO> getQna(HashMap hash) {
		return sqlSession.selectList("AdminDAO.getQna",hash);
	}
	@Override
	public int updateQnaAnswer(QnaVO vo) {
		return sqlSession.update("AdminDAO.updateQnaAnswer",vo);
	}
	@Override
	public QnaVO getQnaAnswer(QnaVO vo) {
		return sqlSession.selectOne("AdminDAO.getQnaAnswer",vo);
	}
	@Override
	public List<IndieVO> getIndieList(HashMap hash) {
		return sqlSession.selectList("AdminDAO.getIndieList", hash);
	}
	@Override
	public IndieVO getIndieOne(IndieVO vo) {
		return sqlSession.selectOne("AdminDAO.getIndieOne",vo);
	}
	@Override
	public int updateIndieConfirm(IndieVO vo) {
		return sqlSession.update("AdminDAO.updateIndieConfirm",vo);
	}
	@Override
	public List<AccountFormVO> getUserBanList(AccountFormVO vo) {
		return sqlSession.selectList("AdminDAO.getUserBanList",vo);
	}
	public int banUser(AccountFormVO vo) {
		return sqlSession.update("AdminDAO.banUser",vo);
	}
	@Override
	public int allowUser(AccountFormVO vo) {
		return sqlSession.update("AdminDAO.allowUser",vo);
	}
	@Override
	public int deleteComment(CommentVO vo) {
		return sqlSession.delete("AdminDAO.deleteComment",vo);
	}
	
	
	
}
