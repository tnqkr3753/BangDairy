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
		return accountFormDAO.joinKakao(vo);
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
							.append("<a href='http://115.91.88.227:60003/bangdairy/email/confirm")
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

	@Override
	public AccountFormVO findAccount(AccountFormVO vo) {
		return accountFormDAO.findAccount(vo);
	}

	@Override
	public String sendPassEmail(AccountFormVO vo) {
		AccountFormVO avo = accountFormDAO.findAccount(vo);
		try {
			if( avo != null) { 
				MailHandler sendMail;
				
				sendMail = new MailHandler(mailSender);

				sendMail.setSubject("[MovieAry 회원 찾기 결과]");
				String text = new StringBuffer().append("<h1>비밀번호 찾기 결과</h1>")
						.append("<p>").append(avo.getUserId())
						.append("님의 비밀번호는  ").append(avo.getUserPassword())
						.append("  입니다.</p>").toString();
				LoggerAspect.logger.info(text);
				sendMail.setText(text);
				sendMail.setFrom("tnqkr3753@a.ut.ac.kr", "무비어리 운영자");
				sendMail.setTo(vo.getUserEmail());
				sendMail.send();
				return "회원님의 비밀번호를 <br/> "+avo.getUserEmail()+"에 <br/> 보냈습니다.";
			}else {
				return "일치하는 아이디가<br/> 없습니다.";
			}
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
			LoggerAspect.logger.error("메일 에러 : "+ e.getMessage());
			return "메일 전송에 <br/>실패했습니다.";
		}
	}
	
	
	
}
