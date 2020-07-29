package com.kosmo.bangdairy.vo;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class AccountFormVO {
	String userName;
	int userAge;
	String userId;
	String userPassword;
	String userEmail;
	int userGender;
	String userProfile;
	long userProfileSize;
	String userReg;
	
	
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	MultipartFile file;
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		if(!file.isEmpty()) {
			
			String fileName = file.getOriginalFilename();
			int pos = fileName.lastIndexOf( "." );
			String ext = fileName.substring( pos ); //파일 확장자
			this.userProfile = userId+ext; //파일이름을 userId로 바꿀거임
			this.userProfileSize  = file.getSize();
			//실제 파일로 저장
			File f = new File("../../../../../webapp/resources/upload/userProfile/"+userProfile);
			try {
				file.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("파일 전송 실패" + e.getMessage());
			}
		}
	}
	@Override
	public String toString() {
		return "AccountFormVO [userName=" + userName + ", userAge=" + userAge + ", userId=" + userId + ", userPassword="
				+ userPassword + ", userEmail=" + userEmail + ", userGender=" + userGender + ", userProfile="
				+ userProfile + ", userProfileSize=" + userProfileSize + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserGender() {
		return userGender;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	public long getUserProfileSize() {
		return userProfileSize;
	}
	public void setUserProfileSize(long userProfileSize) {
		this.userProfileSize = userProfileSize;
	}
	public String getUserReg() {
		return userReg;
	}
	public void setUserReg(String userReg) {
		this.userReg = userReg;
		Calendar cal = Calendar.getInstance();
		char lastNum = userReg.charAt(6);
		int birth = Integer.parseInt(userReg.substring(0, 2));
		if ( lastNum =='1' || lastNum =='3') {
			this.userGender = 1;
		}else if (lastNum=='2' || lastNum=='4') {
			this.userGender =2;
		}
		if(lastNum =='1' || lastNum =='2') {
			this.userAge=cal.YEAR-(1900+birth)+1;
		}else if(lastNum =='3' || lastNum =='4') {
			this.userAge=cal.YEAR-(2000+birth)+1;
		}
		
	}
	
	
}
