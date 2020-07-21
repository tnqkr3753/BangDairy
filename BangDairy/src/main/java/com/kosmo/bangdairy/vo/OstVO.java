package com.kosmo.bangdairy.vo;

public class OstVO {
	private int ostId;
	private String ostTitle;
	private String ostSinger;
	public int getOstId() {
		return ostId;
	}
	public void setOstId(int ostId) {
		this.ostId = ostId;
	}
	public String getOstTitle() {
		return ostTitle;
	}
	public void setOstTitle(String ostTitle) {
		this.ostTitle = ostTitle;
	}
	public String getOstSinger() {
		return ostSinger;
	}
	public void setOstSinger(String ostSinger) {
		this.ostSinger = ostSinger;
	}
	@Override
	public String toString() {
		return "OstVO [ostId=" + ostId + ", ostTitle=" + ostTitle + ", ostSinger=" + ostSinger + "]";
	}
}
