package com.kosmo.bangdairy.vo;

public class StillVO {
	private int stillId;
	private String movieId;
	private String stillAddr;
	public int getStillId() {
		return stillId;
	}
	public void setStillId(int stillId) {
		this.stillId = stillId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getStillAddr() {
		return stillAddr;
	}
	public void setStillAddr(String stillAddr) {
		this.stillAddr = stillAddr;
	}
	@Override
	public String toString() {
		return "StillVO [stillId=" + stillId + ", movieId=" + movieId + ", stillAddr=" + stillAddr + "]";
	}
	
}
