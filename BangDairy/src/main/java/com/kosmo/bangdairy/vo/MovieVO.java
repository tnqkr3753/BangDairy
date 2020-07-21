package com.kosmo.bangdairy.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MovieVO {
	private int movieId;
	private String movieTitle;
	private String MovieEngTitle;
	private String contry;
	private String company;
	private String openingDateStr;
	private Date openingDate;
	private String plot;
	private String showtimes;
	private String viewingClass;
	private int numbersViewers;
	private String keyword;
	private int numbersHists;
	private Date updateDate;
	private String posterAddr;
	private String previewAddr;
	private HashMap<ActorVO, String> starring;
	private HashMap<OstVO, String> movieOst;
	private ArrayList<DirectorVO> movieDirector;
	private ArrayList<CommentVO> movieComment;
	private ArrayList<GenreVO> movieGenre;
	private ArrayList<StillVO> movieStill;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getMovieEngTitle() {
		return MovieEngTitle;
	}
	public void setMovieEngTitle(String movieEngTitle) {
		MovieEngTitle = movieEngTitle;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(String showtimes) {
		this.showtimes = showtimes;
	}
	public String getViewingClass() {
		return viewingClass;
	}
	public void setViewingClass(String viewingClass) {
		this.viewingClass = viewingClass;
	}
	public int getNumbersViewers() {
		return numbersViewers;
	}
	public void setNumbersViewers(int numbersViewers) {
		this.numbersViewers = numbersViewers;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getNumbersHists() {
		return numbersHists;
	}
	public void setNumbersHists(int numbersHists) {
		this.numbersHists = numbersHists;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getPosterAddr() {
		return posterAddr;
	}
	public void setPosterAddr(String posterAddr) {
		this.posterAddr = posterAddr;
	}
	public String getPreviewAddr() {
		return previewAddr;
	}
	public void setPreviewAddr(String previewAddr) {
		this.previewAddr = previewAddr;
	}
	public HashMap<ActorVO, String> getStarring() {
		return starring;
	}
	public void setStarring(HashMap<ActorVO, String> starring) {
		this.starring = starring;
	}
	public HashMap<OstVO, String> getMovieOst() {
		return movieOst;
	}
	public void setMovieOst(HashMap<OstVO, String> movieOst) {
		this.movieOst = movieOst;
	}
	public ArrayList<DirectorVO> getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(ArrayList<DirectorVO> movieDirector) {
		this.movieDirector = movieDirector;
	}
	public ArrayList<CommentVO> getMovieComment() {
		return movieComment;
	}
	public void setMovieComment(ArrayList<CommentVO> movieComment) {
		this.movieComment = movieComment;
	}
	public ArrayList<GenreVO> getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(ArrayList<GenreVO> movieGenre) {
		this.movieGenre = movieGenre;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		this.openingDateStr = sd.format(openingDate);
	}
	public String getOpeningDateStr() {
		return openingDateStr;
	}
	public void setOpeningDateStr(String openingDateStr) {
		this.openingDateStr = openingDateStr;
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
		try {
			this.openingDate  = sd.parse(openingDateStr);
		} catch (ParseException e) {
			System.out.println("날짜 파싱 오류 :" +e.getMessage());
		}
		
	}
	public ArrayList<StillVO> getMovieStill() {
		return movieStill;
	}
	public void setMovieStill(ArrayList<StillVO> movieStill) {
		this.movieStill = movieStill;
	}
	@Override
	public String toString() {
		return "MovieVO [movieId=" + movieId + ", movieTitle=" + movieTitle + ", MovieEngTitle=" + MovieEngTitle
				+ ", contry=" + contry + ", company=" + company + ", openingDateStr=" + openingDateStr
				+ ", openingDate=" + openingDate + ", plot=" + plot + ", showtimes=" + showtimes + ", viewingClass="
				+ viewingClass + ", numbersViewers=" + numbersViewers + ", keyword=" + keyword + ", numbersHists="
				+ numbersHists + ", updateDate=" + updateDate + ", posterAddr=" + posterAddr + ", previewAddr="
				+ previewAddr + ", starring=" + starring + ", movieOst=" + movieOst + ", movieDirector=" + movieDirector
				+ ", movieComment=" + movieComment + ", movieGenre=" + movieGenre + ", movieStill=" + movieStill + "]";
	}
	
	
}
