package com.kosmo.bangdairy.vo;

public class AccountFormVO {
	String userName;
	int userAge;
	String userId;
	String userPassword;
	String userEmail;
	int userGender;
	String userProfile;
	int userProfileSize;
	
	
	@Override
	public String toString() {
		return "AccountFormVO [userName=" + userName + ", userAge=" + userAge + ", userId=" + userId + ", userPassword="
				+ userPassword + ", userEmail=" + userEmail + ", userGender=" + userGender + ", userProfile="
				+ userProfile + ", userProfileSize=" + userProfileSize + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserGender() {
		return userGender;
	}
	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	public int getUserProfileSize() {
		return userProfileSize;
	}
	public void setUserProfileSize(int userProfileSize) {
		this.userProfileSize = userProfileSize;
	}
	
}
