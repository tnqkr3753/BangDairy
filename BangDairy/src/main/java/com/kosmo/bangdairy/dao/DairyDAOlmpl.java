package com.kosmo.bangdairy.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Repository("dairyDAO")
public class DairyDAOlmpl implements DairyDAO{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<DairyVO> showList(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.listdairy",vo);
	}
	
	@Override
	public List<HashMap> mostlikeuser(AccountFormVO vo){
		return sqlSession.selectList("DairyDAO.mostlikeuserr",vo);
	}
	
	@Override
	public List<DairyVO> recentDairy(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.recentdairy",vo);
	}
	
	@Override
	public List<HashMap> topDairy() {
		return sqlSession.selectList("DairyDAO.topdairy");
	}
	
	@Override
	public List<DairyVO> recommenDairy(AccountFormVO vo) {
		return sqlSession.selectList("DairyDAO.recommendairy",vo);
	}
	
	@Override
	public List<HashMap> searchDdairy(HashMap hash) {
		return sqlSession.selectList("DairyDAO.searchddairy",hash);
	}
	
	@Override
	public AccountFormVO getMyProfile(AccountFormVO vo) {
		return sqlSession.selectOne("DairyDAO.getMyProfile",vo);
	}
	
	//--------------------------��二�--------------------------
	@Override
	public List<MovieVO> recommendTitle(MovieVO mvo) {	// �쁺�솕�젣紐� 寃��깋 �썑 由ъ뒪�듃 諛쏆븘�샂
		return sqlSession.selectList("DairyDAO.recommendTitle", mvo);
	}
	
	@Override
	public int insertDiary(DairyVO dvo) {	// �떎�씠�뼱由� �옉�꽦 �썑 DB�뿉 �엯�젰
		return sqlSession.insert("DairyDAO.insertDiary", dvo);
	}
	
	@Override
	public List<AccountFormVO> userInfo(AccountFormVO avo) { // �쑀���젙蹂� 媛��졇�샂
		return sqlSession.selectList("DairyDAO.userInfo", avo);
	}
	
	@Override
	public int countDiaryByUser(AccountFormVO avo) { // �떎�씠�뼱由� 珥� 媛쒖닔 COUNT
		return sqlSession.selectOne("DairyDAO.countDiaryByUser", avo);
	}
	
	@Override	// �떎�씠�뼱由� 由ъ뒪�듃 紐⑸줉 媛��졇�샂
	public List<HashMap> getDairyList(AccountFormVO vo, int firstRow, int endRow) {
		HashMap m = new HashMap();
		
		// System.out.println("daoImpl ========== " + firstRow);
		// System.out.println("daoImpl ========== " + endRow);

		m.put("firstRow", firstRow);
		m.put("endRow", endRow);
		m.put("userId", vo.getUserId());
		
		return sqlSession.selectList("DairyDAO.dairyList", m);
	}

	@Override
	public List<HashMap> getDetailDiary(DairyVO dvo) {	// �떎�씠�뼱由� �긽�꽭�젙蹂� 媛��졇�샂
		return sqlSession.selectList("DairyDAO.getDetailDiary", dvo);
	}

	@Override
	public int deleteDiary(DairyVO dvo) {	// �떎�씠�뼱由� �궘�젣
		return sqlSession.delete("DairyDAO.deleteDiary", dvo);
	}

	@Override
	public int updateDiary(DairyVO dvo) {	// �떎�씠�뼱由� �닔�젙
		return sqlSession.update("DairyDAO.updateUserInfo", dvo);
	}

	@Override
	public int increateHits(DairyVO vo) {
		return sqlSession.update("DairyDAO.addhits",vo);
	}

	@Override
	public int clickLikeHate(DairyUserVO vo) {
		return sqlSession.insert("DairyDAO.clickLikeHate",vo);
	}


	
	
}