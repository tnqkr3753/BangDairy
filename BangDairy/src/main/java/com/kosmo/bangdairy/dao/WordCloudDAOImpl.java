package com.kosmo.bangdairy.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.ReviewVO;

@Repository("wordCloudDAO")
public class WordCloudDAOImpl implements WordCloudDAO {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<ReviewVO> getReviewContent(MovieVO vo) {
		return sqlSession.selectList("WordCloudDAO.getReviewContent",vo);
	}
	
}
