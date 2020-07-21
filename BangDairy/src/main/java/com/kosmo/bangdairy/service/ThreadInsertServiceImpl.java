package com.kosmo.bangdairy.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.ThreadInsertDAO;
import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
import com.kosmo.bangdairy.vo.StillVO;
@Service("threadInsertService")
public class ThreadInsertServiceImpl implements ThreadInsertService{
	@Autowired
	ThreadInsertDAO threadInsertDAO;
	@Override
	public void insertMovie(MovieVO vo) {
		if (threadInsertDAO.insertMovie(vo)==1) {}
		else {
			System.out.println("db movie입력실패 : " + vo);
		}
		for (GenreVO gvo : vo.getMovieGenre()) {
			if (threadInsertDAO.insertGenre(gvo)==1) {}
			else {
				System.out.println("db genre입력실패 : "+gvo);
				continue;
			}
			HashMap movieGenre = new HashMap();
			movieGenre.put("genreId",gvo.getGenreId());
			movieGenre.put("movieId",vo.getMovieId());
			if (threadInsertDAO.insertMovieGenre(movieGenre)==1) {}
			else {
				System.out.println("db movieGenre 입력실패 : " + movieGenre);
			}
		}
		HashMap<ActorVO, String> avoMap = vo.getStarring();
		//HashMap foreach 람다식 배우 입력
		avoMap.forEach((key,value) -> {
			if(threadInsertDAO.insertActor(key)==1) {}
			else {
				System.out.println("db actor입력실패 : "+key);
			}
			HashMap starring = new HashMap();
			starring.put("movieId", vo.getMovieId());
			starring.put("actorId", key.getActorId());
			starring.put("actorId", value);
			if(threadInsertDAO.insertStarring(starring)==1) {}
			else {
				System.out.println("db starring 입력실패" + starring);
			}
		});
		for (DirectorVO dvo : vo.getMovieDirector()) {
			if(threadInsertDAO.insertDirector(dvo)==1) {}
			else {
				System.out.println("db director입력실패 : "+dvo);
				continue;
			}
			HashMap movieDirector = new HashMap();
			movieDirector.put("movieId", vo.getMovieId());
			movieDirector.put("directorId", dvo.getDirectorId());
			if(threadInsertDAO.insertMovieDirector(movieDirector)==1) {}
			else {
				System.out.println("db movieDirector 입력실패 : " + movieDirector);
				continue;
			}
		}
		for (StillVO svo : vo.getMovieStill()) {
			if(threadInsertDAO.insertStillImg(svo)==1) {}
			else {
				System.out.println("db still-img 입력실패 : " + svo);
				continue;
			}
		}
	}

	
}
