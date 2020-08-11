package com.kosmo.bangdairy.vo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class IndieVO {
	
	
	
	
private int indieId;
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
private long indiePosterSize;
private String Applicant;
private String userId;
private String indieGenre;
private String indieConfirm;
			
private String indieLike;
private String indieHate;
private Date regDate;
private String indiePosterAddr;


MultipartFile file;	// write.jsp에 파일첨부시 name="file"과 동일한 변수명

/*
 * 
 * 기능		: 파일을 서버에 업로드 하는 정해진 규칙같은 것 
 * 변수 		: indiePosterAddr,indiePosterSize,file
 * 작성자		: 신진섭
 */
String path="C:\\Users\\KOSMO_14\\git\\BangDairy2\\BangDairy\\src\\main\\webapp\\resources\\upload\\indie\\";
public void setFile(MultipartFile file) {
	this.file = file;

	// 업로드 파일 접근
	if(!file.isEmpty()){
		this.indiePosterAddr = file.getOriginalFilename();
		this.indiePosterSize = file.getSize();
		
		//***********************************************
		// 해당 경로로 변경
		File f = new File(path+indiePosterAddr);
		
		try {
			file.transferTo(f);
			
		} catch (IllegalStateException e) {				
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

public String getIndieGenre() {
	return indieGenre;
}

public void setIndieGenre(String indieGenre) {
	this.indieGenre = indieGenre;
}

public int getIndieId() {
	return indieId;
}
public void setIndieId(int indieId) {
	this.indieId = indieId;
}
public String getGenreId() {
	return indieGenre;
}
public void setGenreId(String indieGenre) {
	this.indieGenre = indieGenre;
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
public long getIndiePosterSize() {
	return indiePosterSize;
}
public void setIndiePosterSize(long indiePosterSize) {
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

public String getIndieConfirm() {
	return indieConfirm;
}

public void setIndieConfirm(String indieConfirm) {
	this.indieConfirm = indieConfirm;
}

public String getApplicant() {
	return Applicant;
}

public void setApplicant(String applicant) {
	Applicant = applicant;
}

@Override
public String toString() {
	return "IndieVO [indieId=" + indieId + ", indieTitle=" + indieTitle + ", indieDirector=" + indieDirector
			+ ", indieCountry=" + indieCountry + ", indieMakedate=" + indieMakedate + ", indiePlot=" + indiePlot
			+ ", indieActor=" + indieActor + ", indieAddr=" + indieAddr + ", indieKeyword=" + indieKeyword
			+ ", indieViewingHits=" + indieViewingHits + ", indieUpdateDate=" + indieUpdateDate + ", indiePosterSize="
			+ indiePosterSize + ", Applicant=" + Applicant + ", userId=" + userId + ", indieGenre=" + indieGenre
			+ ", indieConfirm=" + indieConfirm + ", indieLike=" + indieLike + ", indieHate=" + indieHate + ", regDate="
			+ regDate + ", indiePosterAddr=" + indiePosterAddr + ", file=" + file + ", path=" + path + "]";
}


}


