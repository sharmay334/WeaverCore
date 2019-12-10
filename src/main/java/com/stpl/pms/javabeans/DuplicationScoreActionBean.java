package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class DuplicationScoreActionBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long newPlayerId;
	private Long oldPlayerId;
	private Double score;
	private String Status;
	private String userName;
	private String firstName;
	private String lastName;
	private Timestamp registrationDate;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Timestamp getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Long getNewPlayerId() {
		return newPlayerId;
	}
	public void setNewPlayerId(Long newPlayerId) {
		this.newPlayerId = newPlayerId;
	}
	public Long getOldPlayerId() {
		return oldPlayerId;
	}
	public void setOldPlayerId(Long oldPlayerId) {
		this.oldPlayerId = oldPlayerId;
	}
	
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
}
