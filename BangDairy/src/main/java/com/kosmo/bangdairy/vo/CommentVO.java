package com.kosmo.bangdairy.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentVO {
	private String movieId;
	private String userId;
	private String comment;
	private int receipt;
	private Date commentRegDate;
	private int commentScore;
	
	public Date getCommentRegDate() {
		return commentRegDate;
	}
	public void setCommentRegDate(Date commentRegDate) {
		this.commentRegDate = commentRegDate;
	}
	public int getCommentScore() {
		return commentScore;
	}
	public void setCommentScore(int commentScore) {
		this.commentScore = commentScore;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getReceipt() {
		return receipt;
	}
	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}
	@Override
	public String toString() {
		return "CommentVO [movieId=" + movieId + ", userId=" + userId + ", comment=" + comment + ", receipt=" + receipt
				+ ", commentRegDate=" + commentRegDate + ", commentScore=" + commentScore + "]";
	}
	
	
}
