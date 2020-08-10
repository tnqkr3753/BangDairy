package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosmo.bangdairy.vo.ActorVO;
import com.kosmo.bangdairy.vo.DirectorVO;
import com.kosmo.bangdairy.vo.GenreVO;
import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.MovieVO;

public interface IndieSevice {
	public void indieInsert(IndieVO ivo);
//	public void indiegenreInsert(IndieVO ivo);
	public List<IndieVO>selectIndieInfo();
	public List<IndieVO>indieGnareSelect();
	public IndieVO selectIndieDetail(IndieVO ivo);
	
	
}
