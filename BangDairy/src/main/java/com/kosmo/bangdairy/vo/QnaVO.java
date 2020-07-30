package com.kosmo.bangdairy.vo;

import java.util.Date;

public class QnaVO {
	private int qnaId;
	private String userId;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaRegDate;
	private int qnaStatus;
	private String qnaAnswer;
	
	@Override
	public String toString() {
		return "QnaVO [qnaId=" + qnaId + ", userId=" + userId + ", qnaTitle=" + qnaTitle + ", qnaContent=" + qnaContent
				+ ", qnaRegDate=" + qnaRegDate + ", qnaStatus=" + qnaStatus + ", qnaAnswer=" + qnaAnswer + "]";
	}
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Date getQnaRegDate() {
		return qnaRegDate;
	}
	public void setQnaRegDate(Date qnaRegDate) {
		this.qnaRegDate = qnaRegDate;
	}
	public int getQnaStatus() {
		return qnaStatus;
	}
	public void setQnaStatus(int qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	
}
