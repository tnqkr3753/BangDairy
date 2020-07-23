package com.kosmo.bangdairy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.ThreadInsertDAO;
import com.kosmo.bangdairy.dao.ThreadInsertDAOImpl;
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
	public void insertMovie(List<MovieVO> arr) {
		//foreach 연속 insert
		threadInsertDAO.insertMovie(arr);
		for (MovieVO vo : arr) {
			if (vo != null) {
				List<HashMap> genreList = new ArrayList<HashMap>();
				if (vo.getMovieGenre()!=null&&!vo.getMovieGenre().isEmpty()) {
					for (GenreVO gvo : vo.getMovieGenre()) {
						if (threadInsertDAO.insertGenre(gvo)==1) {}
						else {
							System.out.println("db genre입력실패 : "+gvo);
							gvo.setGenreId(threadInsertDAO.selectGenreInfo(gvo).getGenreId());
						}
						HashMap movieGenre = new HashMap();
						movieGenre.put("genreId",gvo.getGenreId());
						movieGenre.put("movieId",vo.getMovieId());
						genreList.add(movieGenre);
					}
					threadInsertDAO.insertMovieGenre(genreList);
				}
				//foreach 연속 insert
				HashMap<ActorVO, String> avoMap = vo.getStarring();
				List<ActorVO> actList=new ArrayList<ActorVO>(avoMap.keySet());
				List<HashMap> starList = new ArrayList<HashMap>();
				//foreach 연속 insert
				if(actList!=null&&!actList.isEmpty()) threadInsertDAO.insertActor(actList);
				//hashmap foreach -> list<HashMap> 저장
				//HashMap foreach 람다식 배우 입력
				avoMap.forEach((key,value) -> {
					if(key.getActorId() !=null) {
						HashMap starring = new HashMap();
						starring.put("movieId", vo.getMovieId());
						starring.put("actorId", key.getActorId());
						starring.put("role", value);
						starList.add(starring);
					}
				});
				//foreach 연속 insert starring테이블
				if(starList!=null&&!starList.isEmpty()) threadInsertDAO.insertStarring(starList);
				// foreach insert director 테이블
				if(vo.getMovieDirector()!=null&&!vo.getMovieDirector().isEmpty()) threadInsertDAO.insertDirector(vo.getMovieDirector());
				//insert moviedirector 테이블
				for (DirectorVO dvo : vo.getMovieDirector()) {
					HashMap movieDirector = new HashMap();
					movieDirector.put("movieId", vo.getMovieId());
					movieDirector.put("directorId", dvo.getDirectorId());
					if(threadInsertDAO.insertMovieDirector(movieDirector)==1) {}
					else {
						System.out.println("db movieDirector 입력실패 : " + movieDirector);
						continue;
					}
				}
				//스틸 영화 컬럼 db저장
				if (vo.getMovieStill()!=null && !vo.getMovieStill().isEmpty()) {
					threadInsertDAO.insertStillImg(vo.getMovieStill());
				}
			}
		}
	}
	@Override
	public void updateMovieOpening(List<MovieVO> vo) {
		threadInsertDAO.updateMovieOpening(vo);
	}

	
}
