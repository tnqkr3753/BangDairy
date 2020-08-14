package com.kosmo.bangdairy.dao;

import java.util.List;

import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.ReviewVO;

public interface WordCloudDAO {
	public List<ReviewVO> getReviewContentDaum(MovieVO vo);
	public List<ReviewVO> getReviewContentNaver(MovieVO vo);
	public List<ReviewVO> getReviewContentWacha(MovieVO vo);
}
