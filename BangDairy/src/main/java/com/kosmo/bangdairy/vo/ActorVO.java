package com.kosmo.bangdairy.vo;

public class ActorVO {
	private String actorId;
	private String actorName;
	private String actorEngName;
	public String getActorId() {
		return actorId;
	}
	public void setActorId(String actorId) {
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
	@Override
	public String toString() {
		return "ActorVO [actorId=" + actorId + ", actorName=" + actorName + ", actorEngName=" + actorEngName
				+"]";
	}
	
}
