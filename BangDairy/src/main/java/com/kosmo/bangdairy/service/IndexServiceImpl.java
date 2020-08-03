package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.IndexDAO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.MovieVO;
@Service("indexService")
public class IndexServiceImpl implements IndexService {
	@Autowired
	IndexDAO indexDAO;

	@Override
	public List<MovieVO> getMovieAsScore() {
		return indexDAO.getMovieAsScore();
	}

	@Override
	public List<GenreVO> getHitsAsGenre() {
		return indexDAO.getHistAsGenre();
	}

	@Override
	public List<MovieVO> getMovieWithGenre(HashMap hash) {
		return indexDAO.getMovieWithGenre(hash);
	}

	@Override
	public GenreVO getGenreTitle(HashMap hash) {
		return indexDAO.getGenreTitle(hash);
	}
	
	
}
