package com.kosmo.bangdairy.service;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.DairyDAOlmpl;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Service("dairyService")
public class DairyServicelmpl implements DairyService {
	
	@Autowired
	DairyDAOlmpl dairyDAO;
	
	int totalRecordCount;
	int pageTotalCount;
	int countPerPage = 10;
	int blockPageNumcount = 5;

	@Override
	public List<DairyVO> showList(AccountFormVO vo) {
		return dairyDAO.showList(vo);
	}
	
	@Override
	public List<HashMap> mostlikeuser(AccountFormVO vo){
		return dairyDAO.mostlikeuser(vo);
	}
	
	@Override
	public List<DairyVO> recentDairy(AccountFormVO vo){
		return dairyDAO.recentDairy(vo);
	}
	
	@Override
	public List<HashMap> topDairy(){
		return dairyDAO.topDairy();
	} 
	
	@Override
	public List<DairyVO> recommenDairy(AccountFormVO vo){
		return dairyDAO.recommenDairy(vo);
	}
	
	@Override
	public List<HashMap> searchDdairy(HashMap hash) {
		return dairyDAO.searchDdairy(hash);		
	}

	@Override
	public AccountFormVO getMyProfile(AccountFormVO vo) {
		return dairyDAO.getMyProfile(vo);
	}
	//--------------------------��二�--------------------------
	@Override
	public List<MovieVO> recommendTitle(MovieVO mvo) {	// �쁺�솕�젣紐� 寃��깋 �썑 由ъ뒪�듃 諛쏆븘�샂
		return dairyDAO.recommendTitle(mvo);
	}
	@Override
	public int insertDiary(DairyVO dvo) {	// �떎�씠�뼱由� �옉�꽦 �썑 DB�뿉 �엯�젰
		return dairyDAO.insertDiary(dvo);
	}

	@Override
	public List<AccountFormVO> userInfo(AccountFormVO avo) { // �쑀���젙蹂� 媛��졇�샂
		return dairyDAO.userInfo(avo);
	}
	
	int totalDiaryCount;	// 珥� �떎�씠�뼱由� 由ъ뒪�듃 媛쒖닔
	
	@Override
	public int countDiaryByUser(AccountFormVO avo) { // �떎�씠�뼱由� 珥� 媛쒖닔 COUNT
		totalDiaryCount = dairyDAO.countDiaryByUser(avo);
		pageTotalCount = totalDiaryCount/5;
		
		if (totalDiaryCount % 5 > 0) pageTotalCount++;
		
		return pageTotalCount;
	}
	
	@Override	// �떎�씠�뼱由� 由ъ뒪�듃 紐⑸줉 媛��졇�샂
	public List<HashMap> getDairyList(AccountFormVO vo, int pNum) {
		int firstRow = (pNum-1) * 5;
		int endRow = 5;
		
		return dairyDAO.getDairyList(vo, firstRow, endRow);
	}

	@Override	// �떎�씠�뼱由� �긽�꽭�젙蹂� 媛��졇�샂
	public List<HashMap> getDetailDiary(DairyVO dvo) {
		dairyDAO.increateHits(dvo);
		return dairyDAO.getDetailDiary(dvo);
	}

	@Override	// �떎�씠�뼱由� �궘�젣
	public int deleteDiary(DairyVO dvo) {
		return dairyDAO.deleteDiary(dvo);
	}

	@Override	// �떎�씠�뼱由� �닔�젙
	public int updateDiary(DairyVO dvo) {
		return dairyDAO.updateDiary(dvo);
	}

	@Override
	public int clickLikeHate(DairyUserVO vo) {
		return dairyDAO.clickLikeHate(vo);
	}
	
	
}