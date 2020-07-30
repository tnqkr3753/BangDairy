package com.kosmo.bangdairy.vo;

import java.util.Date;

public class WishMovieVO {
	private String movieId;
	private String userId;
	private Date regDate;
	private String movieTitle;
	private String viewingClass;
	private String posterAddr;
	
	@Override
	public String toString() {
		return "WishMovieVO [movieId=" + movieId + ", userId=" + userId + ", regDate=" + regDate + ", movieTitle="
				+ movieTitle + ", viewingClass=" + viewingClass + ", posterAddr=" + posterAddr + "]";
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getViewingClass() {
		return viewingClass;
	}
	public void setViewingClass(String viewingClass) {
		this.viewingClass = viewingClass;
	}
	public String getPosterAddr() {
		return posterAddr;
	}
	public void setPosterAddr(String posterAddr) {
		this.posterAddr = posterAddr;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
