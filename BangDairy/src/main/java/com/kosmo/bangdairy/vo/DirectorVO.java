package com.kosmo.bangdairy.vo;

public class DirectorVO {
	private String directorId;
	private String directorName;
	private String directorEngName;
	public String getDirectorId() {
		return directorId;
	}
	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public String getDirectorEngName() {
		return directorEngName;
	}
	public void setDirectorEngName(String directorEngName) {
		this.directorEngName = directorEngName;
	}
	@Override
	public String toString() {
		return "DirectorVO [directorId=" + directorId + ", directorName=" + directorName + ", directorEngName="
				+ directorEngName + "]";
	}
	
}
