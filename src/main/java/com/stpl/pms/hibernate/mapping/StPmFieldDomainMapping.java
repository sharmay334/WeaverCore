package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;


/**
 * StPmFieldDomainMapping entity. @author MyEclipse Persistence Tools
 */

public class StPmFieldDomainMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer fieldId;
	private String fieldName;
	private Integer fieldDispCode;
	private Short pageSectionNo;
	private Short fieldSequenceNo;
	private String isMandatory;
	private String validationExp;
	private Integer helpStringCode;
	private String isUnique;
	private String isShow;
	private String fieldInputType;
	private String optionValues;
	private String isNull;
	private Integer sectionNameCode;
	private String isEditable;
	private Short domainId;
	private Short aliasId;
	private String isEditablePlayer;
	private String defaultValue;
	private String isPartOfMiniReg;
	private Short miniRegSeqNo;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	private String serviceName; // API Name
	

	// Constructors
	/** default constructor */
	public StPmFieldDomainMapping() {
	}

	/** minimal constructor */
	public StPmFieldDomainMapping(String fieldName, Integer fieldDispCode,
			Short pageSectionNo, Short fieldSequenceNo, String isMandatory,
			String validationExp, Integer helpStringCode, String isUnique,
			String fieldInputType, String optionValues,
			Integer sectionNameCode, String isEditablePlayer, String defaultValue,
			String isPartOfMiniReg, Short miniRegSeqNo) {
		this.fieldName = fieldName;
		this.fieldDispCode = fieldDispCode;
		this.pageSectionNo = pageSectionNo;
		this.fieldSequenceNo = fieldSequenceNo;
		this.isMandatory = isMandatory;
		this.validationExp = validationExp;
		this.helpStringCode = helpStringCode;
		this.isUnique = isUnique;
		this.fieldInputType = fieldInputType;
		this.optionValues = optionValues;
		this.sectionNameCode = sectionNameCode;
		this.isEditablePlayer = isEditablePlayer;
		this.defaultValue = defaultValue;
		this.isPartOfMiniReg = isPartOfMiniReg;
		this.miniRegSeqNo = miniRegSeqNo;
		
	}
	
	/*   */
	public StPmFieldDomainMapping(Integer fieldId, String fieldName, Integer fieldDispCode,
			Short pageSectionNo, Short fieldSequenceNo, String isMandatory,
			String validationExp, Integer helpStringCode, 
			String fieldInputType, String optionValues,
			Integer sectionNameCode, String defaultValue, String isEditable, String isPartOfMiniReg, Short miniRegSeqNo){
		
		this.fieldId = fieldId;
		this.fieldName = fieldName;
		this.fieldDispCode = fieldDispCode;
		this.pageSectionNo = pageSectionNo;
		this.fieldSequenceNo = fieldSequenceNo;
		this.isMandatory = isMandatory;
		this.validationExp = validationExp;
		this.helpStringCode = helpStringCode;
		this.fieldInputType = fieldInputType;
		this.optionValues = optionValues;
		this.sectionNameCode = sectionNameCode;
		this.defaultValue = defaultValue;
		this.isEditable = isEditable;
		this.isPartOfMiniReg = isPartOfMiniReg;
		this.miniRegSeqNo = miniRegSeqNo;
	}
	
	

	/** full constructor */
	public StPmFieldDomainMapping(String fieldName, Integer fieldDispCode,
			Short pageSectionNo, Short fieldSequenceNo, String isMandatory,
			String validationExp, Integer helpStringCode, String isUnique,
			String isShow, String fieldInputType, String optionValues,
			String isNull, Integer sectionNameCode, String isEditable,
			Short domainId, String isEditablePlayer, String defaultValue,
			String isPartOfMiniReg, Short miniRegSeqNo) {
		this.fieldName = fieldName;
		this.fieldDispCode = fieldDispCode;
		this.pageSectionNo = pageSectionNo;
		this.fieldSequenceNo = fieldSequenceNo;
		this.isMandatory = isMandatory;
		this.validationExp = validationExp;
		this.helpStringCode = helpStringCode;
		this.isUnique = isUnique;
		this.isShow = isShow;
		this.fieldInputType = fieldInputType;
		this.optionValues = optionValues;
		this.isNull = isNull;
		this.sectionNameCode = sectionNameCode;
		this.isEditable = isEditable;
		this.domainId = domainId;
		this.isEditablePlayer = isEditablePlayer;
		this.defaultValue = defaultValue;
		this.isPartOfMiniReg = isPartOfMiniReg;
		this.miniRegSeqNo = miniRegSeqNo;
	}

	// Property accessors
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public Integer getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getFieldDispCode() {
		return this.fieldDispCode;
	}

	public void setFieldDispCode(Integer fieldDispCode) {
		this.fieldDispCode = fieldDispCode;
	}

	public Short getPageSectionNo() {
		return this.pageSectionNo;
	}

	public void setPageSectionNo(Short pageSectionNo) {
		this.pageSectionNo = pageSectionNo;
	}

	public Short getFieldSequenceNo() {
		return this.fieldSequenceNo;
	}

	public void setFieldSequenceNo(Short fieldSequenceNo) {
		this.fieldSequenceNo = fieldSequenceNo;
	}

	public String getIsMandatory() {
		return this.isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}

	public String getValidationExp() {
		return this.validationExp;
	}

	public void setValidationExp(String validationExp) {
		this.validationExp = validationExp;
	}

	public Integer getHelpStringCode() {
		return this.helpStringCode;
	}

	public void setHelpStringCode(Integer helpStringCode) {
		this.helpStringCode = helpStringCode;
	}

	public String getIsUnique() {
		return this.isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getIsShow() {
		return this.isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getFieldInputType() {
		return this.fieldInputType;
	}

	public void setFieldInputType(String fieldInputType) {
		this.fieldInputType = fieldInputType;
	}

	public String getOptionValues() {
		return this.optionValues;
	}

	public void setOptionValues(String optionValues) {
		this.optionValues = optionValues;
	}

	public String getIsNull() {
		return this.isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public Integer getSectionNameCode() {
		return this.sectionNameCode;
	}

	public void setSectionNameCode(Integer sectionNameCode) {
		this.sectionNameCode = sectionNameCode;
	}

	public String getIsEditable() {
		return this.isEditable;
	}

	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getIsEditablePlayer() {
		return this.isEditablePlayer;
	}

	public void setIsEditablePlayer(String isEditablePlayer) {
		this.isEditablePlayer = isEditablePlayer;
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getIsPartOfMiniReg() {
		return this.isPartOfMiniReg;
	}

	public void setIsPartOfMiniReg(String isPartOfMiniReg) {
		this.isPartOfMiniReg = isPartOfMiniReg;
	}

	public Short getMiniRegSeqNo() {
		return this.miniRegSeqNo;
	}

	public void setMiniRegSeqNo(Short miniRegSeqNo) {
		this.miniRegSeqNo = miniRegSeqNo;
	}


	public Object clone() throws CloneNotSupportedException{
		return super.clone();
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

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	
}