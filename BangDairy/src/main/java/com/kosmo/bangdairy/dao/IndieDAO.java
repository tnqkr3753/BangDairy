package com.kosmo.bangdairy.dao;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosmo.bangdairy.vo.IndieGenreVO;
import com.kosmo.bangdairy.vo.IndieVO;


public interface IndieDAO {
	public void indieInsert(IndieVO ivo);
//	public void indiegenreInsert(IndieVO ivo);
	public List<IndieVO>selectIndieInfo();
	public List<IndieVO> indieGnareSelect();
	public IndieVO selectIndieDetail(IndieVO ivo);
	public int selectTotalCount(HashMap hash);
	public List<HashMap>selectIndiepaging(int firstRow,int endRow,String searchWord);
	public int goodInsert(int goodId1, String userId);
	public int badInsert(int badid1, String userId);
	public int selectEqulegood(int goodId1, String userId);
	public int selectNull(int goodi1, String userId);
	public int increaseHits(IndieVO vo);
}
