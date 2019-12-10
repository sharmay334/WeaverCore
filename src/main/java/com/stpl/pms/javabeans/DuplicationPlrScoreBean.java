package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class DuplicationPlrScoreBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long playerId;
	private String userName;
	private String firstName;
	private String lastName;
	private Timestamp registrationDate;
	private Double scoreAsNew;
	private Double scoreAsOld;
	
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
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
	public Double getScoreAsNew() {
		return scoreAsNew;
	}
	public void setScoreAsNew(Double scoreAsNew) {
		this.scoreAsNew = scoreAsNew;
	}
	public Double getScoreAsOld() {
		return scoreAsOld;
	}
	public void setScoreAsOld(Double scoreAsOld) {
		this.scoreAsOld = scoreAsOld;
	}
	
	
}
