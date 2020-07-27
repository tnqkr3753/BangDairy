package com.kosmo.bangdairy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.dao.MovieDetailDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Service("movieDetailService")
public class MovieDetailServiceImpl implements MovieDetailService {
	@Autowired
	MovieDetailDAO movieDetailDAO;
	@Override
	public MovieVO selectOneMovie(MovieVO vo) {
		MovieVO rvo = movieDetailDAO.selectOneMovie(vo);
		ArrayList<GenreVO> gvo =  (ArrayList<GenreVO>)movieDetailDAO.selectMovieGenre(vo);
		LoggerAspect.logger.info("gvo : "+gvo);
		rvo.setMovieGenre(gvo);
		HashMap<ActorVO, String> star = new HashMap<ActorVO, String>();
		for (HashMap hash : movieDetailDAO.selectStarring(vo)) {
			ActorVO avo = new ActorVO();
			avo.setActorId((String)hash.get("actor_id"));
			avo.setActorName((String)hash.get("actor_name"));
			star.put(avo, (String)hash.get("role"));
		}
		rvo.setStarring(star);
		LoggerAspect.logger.info("star : "+star);
		rvo.setMovieDirector((ArrayList<DirectorVO>)movieDetailDAO.selectDirectors(vo));
		return rvo;
	}

}
