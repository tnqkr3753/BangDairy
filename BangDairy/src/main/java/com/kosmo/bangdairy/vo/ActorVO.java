package com.kosmo.bangdairy.vo;

public class ActorVO {
	private int actorId;
	private String actorName;
	private String actorEngName;
	private String actorRegId;
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorEngName() {
		return actorEngName;
	}
	public void setActorEngName(String actorEngName) {
		this.actorEngName = actorEngName;
	}
	public String getActorRegId() {
		return actorRegId;
	}
	public void setActorRegId(String actorRegId) {
		this.actorRegId = actorRegId;
	}
	@Override
	public String toString() {
		return "ActorVO [actorId=" + actorId + ", actorName=" + actorName + ", actorEngName=" + actorEngName
				+ ", actorRegId=" + actorRegId + "]";
	}
	
}
