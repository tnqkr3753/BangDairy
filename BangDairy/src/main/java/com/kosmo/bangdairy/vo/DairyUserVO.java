package com.kosmo.bangdairy.vo;

import javax.xml.crypto.Data;

public class DairyUserVO {
	
	String userId;
	int diaryId;	
	String diaryLike;
	String diaryHate; 
	Data datetime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public String getDiaryLike() {
		return diaryLike;
	}
	public void setDiaryLike(String diaryLike) {
		this.diaryLike = diaryLike;
	}
	public String getDiaryHate() {
		return diaryHate;
	}
	public void setDiaryHate(String diaryHate) {
		this.diaryHate = diaryHate;
	}
	public Data getDatetime() {
		return datetime;
	}
	public void setDatetime(Data datetime) {
		this.datetime = datetime;
	}
	
}
