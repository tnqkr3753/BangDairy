package com.kosmo.bangdairy.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.QnaVO;
import com.kosmo.bangdairy.vo.WishMovieVO;

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

	@Override
	public List<WishMovieVO> selectWishMovie(WishMovieVO vo) {
		return sqlSession.selectList("MyPageDAO.selectWishMovie",vo);
	}

	@Override
	public int deleteWishMovie(WishMovieVO vo) {
		return sqlSession.delete("MyPageDAO.deleteWishMovie",vo);
	}

	@Override
	public List<QnaVO> selectQnaList(QnaVO vo) {
		return sqlSession.selectList("MyPageDAO.selectQna",vo);
	}

	@Override
	public int insertQna(QnaVO vo) {
		return sqlSession.insert("MyPageDAO.insertQna",vo);
	}

	@Override
	public QnaVO selectQna(QnaVO vo) {
		return sqlSession.selectOne("MyPageDAO.selectQnaOne",vo);
	}
	
	
}
