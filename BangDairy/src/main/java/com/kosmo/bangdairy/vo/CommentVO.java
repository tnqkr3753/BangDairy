package com.kosmo.bangdairy.vo;

public class CommentVO {
	private String movieId;
	private String userId;
	private String comment;
	private int receipt;
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
				+ "]";
	}
	
}
