package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class StRiskDuplicateMaster implements java.io.Serializable,
		Comparable<StRiskDuplicateMaster> {

	private Integer id;
	private Short domainId;
	private Integer fromScore;
	private Integer toScore;
	private String isRecord;
	private String actionNew;
	private String actionOld;
	private String notoficationNew;
	private String notoficationOld;
	private String sectionName;
	private String status;
	
	private List<String> actionNewList;
	private List<String> actionOldList;
	private List<String> notifiNewList;
	private List<String> notifiOldList;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;

	/** default constructor */
	public StRiskDuplicateMaster() {
	}

	
	public StRiskDuplicateMaster(Integer fromScore, Integer toScore,
			String isRecord, String actionNew, String actionOld,
			String notoficationNew, String notoficationOld, String sectionName,
			String status) {
		super();
		this.fromScore = fromScore;
		this.toScore = toScore;
		this.isRecord = isRecord;
		this.actionNew = actionNew;
		this.actionOld = actionOld;
		this.notoficationNew = notoficationNew;
		this.notoficationOld = notoficationOld;
		this.sectionName = sectionName;
		this.setStatus(status);
	}


	public String getIsRecord() {
		return isRecord;
	}

	public void setIsRecord(String isRecord) {
		this.isRecord = isRecord;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromScore() {
		return this.fromScore;
	}

	public void setFromScore(Integer fromScore) {
		this.fromScore = fromScore;
	}

	public Integer getToScore() {
		return this.toScore;
	}

	public void setToScore(Integer toScore) {
		this.toScore = toScore;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionName() {
		return sectionName;
	}

	public List<String> getActionNewList() {
		return actionNewList;
	}

	public List<String> getActionOldList() {
		return actionOldList;
	}

	public List<String> getNotifiNewList() {
		return notifiNewList;
	}

	public List<String> getNotifiOldList() {
		return notifiOldList;
	}

	public void setActionNewList(List<String> actionNewList) {
		this.actionNewList = actionNewList;
	}

	public void setActionOldList(List<String> actionOldList) {
		this.actionOldList = actionOldList;
	}

	public void setNotifiNewList(List<String> notifiNewList) {
		this.notifiNewList = notifiNewList;
	}

	public void setNotifiOldList(List<String> notifiOldList) {
		this.notifiOldList = notifiOldList;
	}

	public void setActionNew(String actionNew) {
		this.actionNew = actionNew;
		this.actionNewList = Arrays.asList(actionNew.split(","));
	}

	public String getActionNew() {
		return actionNew;
	}

	public void setActionOld(String actionOld) {
		this.actionOld = actionOld;
		this.actionOldList = Arrays.asList(actionOld.split(","));
	}

	public String getActionOld() {
		return actionOld;
	}

	public void setNotoficationNew(String notoficationNew) {
		this.notoficationNew = notoficationNew;
		this.notifiNewList = Arrays.asList(notoficationNew.split(","));
	}

	public String getNotoficationNew() {
		return notoficationNew;
	}

	public void setNotoficationOld(String notoficationOld) {
		this.notoficationOld = notoficationOld;
		this.notifiOldList = Arrays.asList(notoficationOld.split(","));
	}

	public String getNotoficationOld() {
		return notoficationOld;
	}

	public int compareTo(StRiskDuplicateMaster o) {

		if (this.fromScore.equals(o.fromScore)
				&& this.toScore.equals(o.toScore)
				&& this.actionNew.equals(o.actionNew)
				&& this.actionOld.equals(o.actionOld)
				&& this.isRecord.equals(o.isRecord)
				&& this.notoficationNew.equals(o.notoficationNew)
				&& this.notoficationOld.equals(o.notoficationOld)) {
			return 1;
		}

		return 0;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getStatus() {
		return status;
	}


	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}


	public Timestamp getCreationTime() {
		return creationTime;
	}


	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}


	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}


	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}


	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

}