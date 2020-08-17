package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.QnaVO;

public interface AdminService {
	public List<HashMap> getMovie(HashMap hash);
	public List<AccountFormVO> getUser(HashMap hash);
	public List<DairyVO> getDiary(HashMap hash);
	public List<HashMap> getComment(HashMap hash);
	public List<QnaVO> getQna(HashMap hash);
	public int updateQnaAnswer(QnaVO vo);
	public QnaVO getQnaAnswer(QnaVO vo);
	public List<IndieVO> getIndieList(HashMap hash);
	public IndieVO getIndieOne(IndieVO vo);
	public int updateIndieConfirm(IndieVO vo);
	public List<AccountFormVO> getUserBanList(AccountFormVO vo);
	public int allowUser(AccountFormVO vo);
	public int banUser(AccountFormVO vo);
	public int deleteComment(CommentVO vo);
	public List<HashMap> getUserScore(HashMap hash);
}
