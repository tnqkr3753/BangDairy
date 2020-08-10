package com.kosmo.bangdairy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.dao.AdminDAO;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.QnaVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDAO adminDAO;

	@Override
	public List<HashMap> getMovie(HashMap hash) {
		return adminDAO.getMovie(hash);
	}

	@Override
	public List<AccountFormVO> getUser(HashMap hash) {
		return adminDAO.getUser(hash);
	}

	@Override
	public List<DairyVO> getDiary(HashMap hash) {
		return adminDAO.getDiary(hash);
	}

	@Override
	public List<HashMap> getComment(HashMap hash) {
		return adminDAO.getComment(hash);
	}

	@Override
	public List<QnaVO> getQna(HashMap hash) {
		return adminDAO.getQna(hash);
	}

	@Override
	public int updateQnaAnswer(QnaVO vo) {
		return adminDAO.updateQnaAnswer(vo);
	}

	@Override
	public QnaVO getQnaAnswer(QnaVO vo) {
		return adminDAO.getQnaAnswer(vo);
	}

	@Override
	public List<IndieVO> getIndieList(HashMap hash) {
		return adminDAO.getIndieList(hash);
	}

	@Override
	public IndieVO getIndieOne(IndieVO vo) {
		return adminDAO.getIndieOne(vo);
	}

	@Override
	public int updateIndieConfirm(IndieVO vo) {
		return adminDAO.updateIndieConfirm(vo);
	}
	
	
}
