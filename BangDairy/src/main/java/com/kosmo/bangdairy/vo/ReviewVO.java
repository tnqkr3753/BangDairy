package com.kosmo.bangdairy.vo;

public class ReviewVO {
	private int reviewId;
	private String movieId;
	private String siteName;
	private String reviewContent;
	private float reviewScore;
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getSiteName() {
		return siteName;
	}
	@Override
	public String toString() {
		return "ReviewVO [reviewId=" + reviewId + ", movieId=" + movieId + ", siteName=" + siteName + ", reviewContent=" + reviewContent + ", reviewScore=" + reviewScore + "]";
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public float getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(float reviewScore) {
		this.reviewScore = reviewScore;
	}
}
