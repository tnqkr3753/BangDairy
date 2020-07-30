package com.kosmo.bangdairy.vo;

import java.util.Date;

public class IndieGenreVO {

private int genreId;
private int indieId;


@Override
public String toString() {
	return "IndieGenreVO [genreId=" + genreId + ", indieId=" + indieId + "]";
}
public int getGenreId() {
	return genreId;
}
public void setGenreId(int genreId) {
	this.genreId = genreId;
}
public int getIndieId() {
	return indieId;
}
public void setIndieId(int indieId) {
	this.indieId = indieId;
}





}


