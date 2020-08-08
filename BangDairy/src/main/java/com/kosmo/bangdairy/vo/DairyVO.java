package com.kosmo.bangdairy.vo;

import java.sql.Date;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import com.kosmo.bangdairy.aop.LoggerAspect;

public class DairyVO {
	private int diaryId;
	private String movieId;
	private String userId;
	private String diaryTitle;
	private String diaryContent;
	private String viewingTogether;
	private Date viewingDate;
	private String viewingLocation;
	private String diaryImage;
	private String diaryHits;
	private Date regDate;
	

	private long diaryImageSize;	// 이미지 사이즈
	MultipartFile file;

	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getDiaryTitle() {
		return diaryTitle;
	}
	
	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}
	
	public String getDiaryContent() {
		return diaryContent;
	}
	
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	
	public String getViewingTogether() {
		return viewingTogether;
	}
	
	public void setViewingTogether(String viewingTogether) {
		this.viewingTogether = viewingTogether;
	}
	
	public Date getViewingDate() {
		return viewingDate;
	}
	
	public void setViewingDate(Date viewingDate) {
		this.viewingDate = viewingDate;
	}
	
	public String getViewingLocation() {
		return viewingLocation;
	}
	
	public void setViewingLocation(String viewingLocation) {
		this.viewingLocation = viewingLocation;
	}
	
	public String getDiaryImage() {
		return diaryImage;
	}
	
	public void setDiaryImage(String diaryImage) {
		this.diaryImage = diaryImage;
	}
	
	public String getDiaryHits() {
		return diaryHits;
	}
	
	public void setDiaryHits(String diaryHits) {
		this.diaryHits = diaryHits;
	}
	
	@Override
	public String toString() {
		return "DairyVO [userId="+userId+",diaryTitle="+diaryTitle+
				"diaryContent="+diaryContent+",viewingTogether="+viewingTogether+
				",viewingLocation="+viewingLocation+",diaryImage="+diaryImage+",regDate="+regDate+"]";
	}
		
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;

		// 이미지가 저장될 경로
		String path = "resources/upload/diary/";

		if(!file.isEmpty()) {	// file이 비어있지 않으면
			this.diaryImage = file.getOriginalFilename();	// file 이름
			this.diaryImageSize = file.getSize();	// file 크기
			
			File f = new File(path + diaryImage);	// 파일로 저장
			String outputImagePath = path + diaryImage;	// 전체 경로
			
			try {
				// TODO 수정필요
				file.transferTo(f);
			}catch (Exception e) {
				LoggerAspect.logger.error("파일 전송 에러 : " + e.getMessage());
			}
		}
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}