package com.kosmo.bangdairy.vo;

import java.util.Date;

public class IndieVO {
private String indieId;
private String indieTitle;
private String indieDirector;
private String indieCountry;
private Date indieMakedate;
private String indiePlot;
private String indieActor;
private String indieAddr;
private String indieKeyword;
private int indieViewingHits;
private Date indieUpdateDate;
private String indiePosterAddr;
private int indiePosterSize;
private String userId;
private String genreId;

private String indieLike;
private String indieHate;
private Date regDate;




public String getIndieId() {
	return indieId;
}
public void setIndieId(String indieId) {
	this.indieId = indieId;
}
public String getGenreId() {
	return genreId;
}
public void setGenreId(String genreId) {
	this.genreId = genreId;
}
@Override
public String toString() {
	return "IndieVO [indieId=" + indieId + ", indieTitle=" + indieTitle + ", indieDirector=" + indieDirector
			+ ", indieCountry=" + indieCountry + ", indieMakedate=" + indieMakedate + ", indiePlot=" + indiePlot
			+ ", indieActor=" + indieActor + ", indieAddr=" + indieAddr + ", indieKeyword=" + indieKeyword
			+ ", indieViewingHits=" + indieViewingHits + ", indieUpdateDate=" + indieUpdateDate + ", indiePosterAddr="
			+ indiePosterAddr + ", indiePosterSize=" + indiePosterSize + ", userId=" + userId + ", indieLike="
			+ indieLike + ", indieHate=" + indieHate + ", regDate=" + regDate + "]";
}
public String getIndie_id() {
	return indieId;
}
public void setIndie_id(String indieId) {
	this.indieId = indieId;
}
public String getIndieTitle() {
	return indieTitle;
}
public void setIndieTitle(String indieTitle) {
	this.indieTitle = indieTitle;
}

public String getPrivateindieTitle() {
	return indieTitle;
}
public void setPrivateindieTitle(String privateindieTitle) {
	this.indieTitle = privateindieTitle;
}
public String getIndieDirector() {
	return indieDirector;
}
public void setIndieDirector(String indieDirector) {
	this.indieDirector = indieDirector;
}
public String getIndieCountry() {
	return indieCountry;
}
public void setIndieCountry(String indieCountry) {
	this.indieCountry = indieCountry;
}
public Date getIndieMakedate() {
	return indieMakedate;
}
public void setIndieMakedate(Date indieMakedate) {
	this.indieMakedate = indieMakedate;
}

public String getIndiePlot() {
	return indiePlot;
}
public void setIndiePlot(String indiePlot) {
	this.indiePlot = indiePlot;
}
public String getIndieActor() {
	return indieActor;
}
public void setIndieActor(String indieActor) {
	this.indieActor = indieActor;
}
public String getIndieAddr() {
	return indieAddr;
}
public void setIndieAddr(String indieAddr) {
	this.indieAddr = indieAddr;
}
public String getIndieKeyword() {
	return indieKeyword;
}
public void setIndieKeyword(String indieKeyword) {
	this.indieKeyword = indieKeyword;
}
public int getIndieViewingHits() {
	return indieViewingHits;
}
public void setIndieViewingHits(int indieViewingHits) {
	this.indieViewingHits = indieViewingHits;
}
public Date getIndieUpdateDate() {
	return indieUpdateDate;
}
public void setIndieUpdateDate(Date indieUpdateDate) {
	this.indieUpdateDate = indieUpdateDate;
}
public String getIndiePosterAddr() {
	return indiePosterAddr;
}
public void setIndiePosterAddr(String indiePosterAddr) {
	this.indiePosterAddr = indiePosterAddr;
}
public int getIndiePosterSize() {
	return indiePosterSize;
}
public void setIndiePosterSize(int indiePosterSize) {
	this.indiePosterSize = indiePosterSize;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getIndieLike() {
	return indieLike;
}
public void setIndieLike(String indieLike) {
	this.indieLike = indieLike;
}
public String getIndieHate() {
	return indieHate;
}
public void setIndieHate(String indieHate) {
	this.indieHate = indieHate;
}
public Date getRegDate() {
	return regDate;
}
public void setRegDate(Date regDate) {
	this.regDate = regDate;
}





}


