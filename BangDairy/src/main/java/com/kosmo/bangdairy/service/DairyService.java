package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyUserVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.MovieVO;

@Service
public interface DairyService {
public List<DairyVO> showList(AccountFormVO vo);
	
	public List<DairyVO> recentDairy(AccountFormVO vo);
	
	public List<HashMap> topDairy();
	
	public List<HashMap> mostlikeuser(AccountFormVO vo);
	
	public List<DairyVO> recommenDairy(AccountFormVO vo);
	
	public List<HashMap> searchDdairy(HashMap hash);
	
	public AccountFormVO getMyProfile(AccountFormVO vo);
	//--------------------------��二�--------------------------
	public List<MovieVO> recommendTitle(MovieVO mvo);	// �쁺�솕�젣紐� 寃��깋 �썑 由ъ뒪�듃 諛쏆븘�샂
	
	public int insertDiary(DairyVO dvo);	// �떎�씠�뼱由� �옉�꽦 �썑 DB�뿉 �엯�젰
	
	public List<AccountFormVO> userInfo(AccountFormVO avo); // �쑀���젙蹂� 媛��졇�샂
	
	public int countDiaryByUser(AccountFormVO avo); // �떎�씠�뼱由� 珥� 媛쒖닔 COUNT
	
	public List<HashMap> getDairyList(AccountFormVO vo, int pNum);	// �떎�씠�뼱由� 由ъ뒪�듃 紐⑸줉 媛��졇�샂
	
	public List<HashMap> getDetailDiary(DairyVO dvo);	// �떎�씠�뼱由� �긽�꽭�젙蹂� 媛��졇�샂
	
	public int deleteDiary(DairyVO dvo);	// �떎�씠�뼱由� �궘�젣
	
	public int updateDiary(DairyVO dvo);	// �떎�씠�뼱由� �닔�젙
	public int clickLikeHate(DairyUserVO vo);
}