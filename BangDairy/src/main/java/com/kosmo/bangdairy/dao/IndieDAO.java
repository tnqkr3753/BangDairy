package com.kosmo.bangdairy.dao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;


public interface IndieDAO {
	public void indieInsert(IndieVO ivo);
//	public void indiegenreInsert(IndieVO ivo);
	public List<IndieVO>selectIndieInfo();
	public List<IndieVO> indieGnareSelect();
	
}
