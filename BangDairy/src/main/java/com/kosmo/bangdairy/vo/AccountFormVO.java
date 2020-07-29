package com.kosmo.bangdairy.vo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import com.kosmo.bangdairy.aop.LoggerAspect;

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
	String absoluteFilePath;
	MultipartFile file;
	
	public String getAbsoluteFilePath() {
		return absoluteFilePath;
	}
	public MultipartFile getFile() {
		return file;
	}
	/*
	 * 메소드명 		: setFile
	 * 기능			: Multipartfile을 받아 파일을 resources/upload/userProfile에 저장하고
	 * 						fileName과 filesize를 설정한다.
	 * 변수			: MultipartFile file
	 * 작성자			: 박윤태
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
		String path = "C:\\Users\\KOSMO_25\\git\\BangDairy\\BangDairy\\src\\main\\webapp\\resources\\upload\\userProfile\\";
		if(!file.isEmpty()) {
			
			String fileName = file.getOriginalFilename();
			int pos = fileName.lastIndexOf( "." );
			String ext = fileName.substring( pos ); //파일 확장자
			this.userProfile = userId+ext; //파일이름을 userId로 바꿀거임
			//실제 파일로 저장
			File f = new File(path+"tmp\\"+userProfile);
			String inputImagePath = path+"tmp\\"+userProfile;
			String outputImagePath = path+userProfile;
			try {
				file.transferTo(f);
				resize(inputImagePath, outputImagePath, 200, 200);
				f.delete();
			} catch (IllegalStateException | IOException e) {
				LoggerAspect.logger.error("파일 resize실패 : " +e.getMessage());
			}
			File nFile = new File(outputImagePath);
			this.userProfileSize  = nFile.length();
			this.absoluteFilePath = outputImagePath;
		}
	}
	/*
	 * 메소드명 		: resize
	 * 기능			: 이미지 주소와 내보낼이미지 주소와 변환할 사이즈를 입력받아 리사이징한다.
	 * 변수			: inputImagePath, outputImagePath, scaledWidth, scaleHeight
	 * 작성자			: 박윤태
	 */
	public void resize(String inputImagePath, String outputImagePath , int scaledWidth, int scaleHeight) throws IOException{
		// 이미지 파일 읽기
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		// output이미지파일 만들기
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaleHeight, inputImage.getType());
		// 인풋 이미지 아웃 이미지로 쓰기
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage,0,0,scaledWidth,scaleHeight,null);
		g2d.dispose();
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".")+1);
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}
	@Override
	public String toString() {
		return "AccountFormVO [userName=" + userName + ", userAge=" + userAge + ", userId=" + userId + ", userPassword="
				+ userPassword + ", userEmail=" + userEmail + ", userGender=" + userGender + ", userReg=" + userReg
				+ ", userProfile=" + userProfile + ", userProfileSize=" + userProfileSize + ", absoluteFilePath="
				+ absoluteFilePath + ", file=" + file + "]";
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
		String path = "C:\\Users\\KOSMO_25\\git\\BangDairy\\BangDairy\\src\\main\\webapp\\resources\\upload\\userProfile\\";
		this.absoluteFilePath = path+userProfile;
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
	/*
	 * 메소드명 		: setUserReg
	 * 기능			: 주민등록번호를 받아 성별과 나이를 구함
	 * 변수			: userReg
	 * 작성자			: 박윤태
	 */
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
