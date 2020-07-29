package com.kosmo.bangdairy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.dao.MovieDetailDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Service("movieDetailService")
public class MovieDetailServiceImpl implements MovieDetailService {
	int commentPerPage = 5;
	@Autowired
	MovieDetailDAO movieDetailDAO;
	/*
	 * 메소드명	: selectOneMovie
	 * 기능		: 영화에 대한 정보 가져오기( 포함된 정보 모두)
	 * 변수 		: MovieVO
	 * 작성자		: 박윤태
	 */
	@Override
	public MovieVO selectOneMovie(MovieVO vo) {
		MovieVO rvo = movieDetailDAO.selectOneMovie(vo);
		ArrayList<GenreVO> gvo =  (ArrayList<GenreVO>)movieDetailDAO.selectMovieGenre(vo);
		rvo.setMovieGenre(gvo);
		HashMap<ActorVO, String> star = new HashMap<ActorVO, String>();
		for (HashMap hash : movieDetailDAO.selectStarring(vo)) {
			ActorVO avo = new ActorVO();
			avo.setActorId((String)hash.get("actor_id"));
			avo.setActorName((String)hash.get("actor_name"));
			star.put(avo, (String)hash.get("role"));
		}
		rvo.setStarring(star);
		movieDetailDAO.increaseHist(rvo);
		rvo.setMovieDirector((ArrayList<DirectorVO>)movieDetailDAO.selectDirectors(vo));
		LoggerAspect.logger.info("rvo : "+rvo);
		return rvo;
	}
	/*
	 * 메소드명	: selectComments
	 * 기능		: Comment 페이징 후 가져오기
	 * 변수 		: pageNum, movieId
	 * 작성자		: 박윤태
	 */
	@Override
	public List<CommentVO> selectComments(String pageNum, String movieId) {
		int pNum = Integer.parseInt(pageNum);
		HashMap hm = new HashMap();
		hm.put("movieId", movieId);
		int totalCount = ((Long)movieDetailDAO.getCommentCount(hm).get("cnt")).intValue();
		int totalPage = totalCount/commentPerPage+1;
		if (totalCount!=0&&totalCount%commentPerPage==0) totalPage-=1;
		int startRow  = 1;
		int endRow = 10;
		if(pNum>=1 && pNum <= totalPage) {
			startRow = (pNum-1)*commentPerPage+1;
			endRow = (pNum)*commentPerPage;
		}
		HashMap hash = new HashMap();
		hash.put("startRow", startRow);
		hash.put("endRow", endRow);
		hash.put("movieId", movieId);
		return movieDetailDAO.selectComments(hash);
	}
	public int commentCount(String movieId) {
		HashMap hm = new HashMap();
		hm.put("movieId", movieId);
		return ((Long)movieDetailDAO.getCommentCount(hm).get("cnt")).intValue();
	}
	/*
	 * 메소드명	: insertComment
	 * 기능		: Comment 입력
	 * 변수 		: CommentVO
	 * 작성자		: 박윤태
	 */
	@Override
	public int insertComment(CommentVO vo) {
		return movieDetailDAO.insertComment(vo);
	}
	
	
}
