package com.kosmo.bangdairy.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.dao.AccountFormDAOImpl;
import com.kosmo.bangdairy.mail.MailHandler;
import com.kosmo.bangdairy.mail.TempKey;
import com.kosmo.bangdairy.vo.AccountFormVO;

@Service("accountFormService")
public class AccountFormServiceImpl implements AccountFormService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private AccountFormDAOImpl accountFormDAO;
	
	@Override
	public int idCheck(String id) {
		int result = accountFormDAO.selectIdCheck(id);
		return result;
	}

	@Override
	public int insertUser(AccountFormVO vo) {
		int result = accountFormDAO.insertUser(vo);
		return result;
	}

	@Override
	public AccountFormVO signInUser(AccountFormVO vo) {
		return accountFormDAO.signInUser(vo);
	}

	@Override
	public int emailCheck(String email) {
		int result = accountFormDAO.selectEmailCheck(email);
		return result;
	}

	@Override
	public AccountFormVO checkForKakao(AccountFormVO vo) {
		return accountFormDAO.checkForKakao(vo);
	}

	@Override
	public int joinKakao(AccountFormVO vo) {
		return accountFormDAO.insertUser(vo);
	}

	@Override
	public void sendEmail(AccountFormVO vo){
			LoggerAspect.logger.info("sendEmail진입");
			String key = new TempKey().getKey(50, false);
			vo.setUserAuthCode(key);
			int result = accountFormDAO.updateAuthCode(vo);
			try {
				if( result == 1) { 
					MailHandler sendMail;
					
						sendMail = new MailHandler(mailSender);
	
					sendMail.setSubject("[MovieAry 서비스 메일 인증]");
					String text = new StringBuffer().append("<h1>메일인증</h1>")
							.append("<a href='http://192.168.0.8:8080/bangdairy/email/confirm")
							.append("?id=").append(vo.getUserId())
							.append("&key=").append(vo.getUserAuthCode())
							.append("' target='_blank'>이메일 인증 확인</a>").toString();
					LoggerAspect.logger.info(text);
					sendMail.setText(text);
					sendMail.setFrom("tnqkr3753@a.ut.ac.kr", "무비어리 운영자");
					sendMail.setTo(vo.getUserEmail());
					sendMail.send();
				}
			} catch (MessagingException | UnsupportedEncodingException e) {
				e.printStackTrace();
				LoggerAspect.logger.error("메일 에러 : "+ e.getMessage());
			}
	}

	@Override
	public int updateAuthStatus(AccountFormVO vo) {
		return accountFormDAO.updateAuthStatus(vo);
	}
	
	
}
