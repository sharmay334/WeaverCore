package com.stpl.pms.hibernate.mapping;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Hibernate;



/**
 * StCmsPlaceholderCriteria entity. @author MyEclipse Persistence Tools
 */

public class StCmsPlaceholderCriteria implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer phCriteriaId;
	private Short domainId;
	private Short aliasId;
	private String criteriaName;
	private String vipLevelList;
	private String playerType;
	private String referTypeDirect;
	private String referTypeAffiliate;
	private String referTypeFriend;
	private String referTypePpc;
	private Blob ppcXml;
	private String specificCritria;
	private Blob specificXml;
	private String referTypeOla;
	private String isFile;

	// Constructors

	/** default constructor */
	public StCmsPlaceholderCriteria() {
	}




	// Property accessors

	public String getReferTypeOla() {
		return referTypeOla;
	}




	public void setReferTypeOla(String referTypeOla) {
		this.referTypeOla = referTypeOla;
	}




	public Integer getPhCriteriaId() {
		return this.phCriteriaId;
	}

	public void setPhCriteriaId(Integer phCriteriaId) {
		this.phCriteriaId = phCriteriaId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getCriteriaName() {
		return this.criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public String getVipLevelList() {
		return this.vipLevelList;
	}

	public void setVipLevelList(String vipLevelList) {
		this.vipLevelList = vipLevelList;
	}

	public String getPlayerType() {
		return this.playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String getReferTypeDirect() {
		return this.referTypeDirect;
	}

	public void setReferTypeDirect(String referTypeDirect) {
		this.referTypeDirect = referTypeDirect;
	}

	public String getReferTypeAffiliate() {
		return this.referTypeAffiliate;
	}

	public void setReferTypeAffiliate(String referTypeAffiliate) {
		this.referTypeAffiliate = referTypeAffiliate;
	}

	public String getReferTypeFriend() {
		return this.referTypeFriend;
	}

	public void setReferTypeFriend(String referTypeFriend) {
		this.referTypeFriend = referTypeFriend;
	}

	public String getReferTypePpc() {
		return this.referTypePpc;
	}
	

	public void setReferTypePpc(String referTypePpc) {
		this.referTypePpc = referTypePpc;
	}

	public Blob getPpcXml() {
		return this.ppcXml;
	}
	
	public List<String> getPpcXmlStr() throws SQLException {
		if(ppcXml!=null) {
			String s = new String(this.ppcXml.getBytes(1,(int)this.ppcXml.length()));
			return Arrays.asList(s.replaceAll("\\[", "").replaceAll("\\]","").replaceAll(" ","").split(","));
		} else {
			return null;
		}
	}

	public void setPpcXml(Blob ppcXml) {
		this.ppcXml = ppcXml;
	}
	public void setPpcXml(String ppcXml) {
		this.ppcXml =  ppcXml!=null?Hibernate.createBlob(ppcXml.getBytes()):null;
	}
	
	public String getSpecificCritria() {
		return this.specificCritria;
	}

	public void setSpecificCritria(String specificCritria) {
		this.specificCritria = specificCritria;
	}

	public Blob getSpecificXml() {
		return this.specificXml;
	}
	
	public List<String> getSpecificXmlStr() throws SQLException {
		if(specificXml!=null) {
			String criteriaStr = new String(this.specificXml.getBytes(1,(int)this.specificXml.length()));
			return  Arrays.asList(criteriaStr.replaceAll("\\[", "").replaceAll("\\]","").replaceAll(" ","").split(","));
		} else {
			return null;
		}
		
	}

	public void setSpecificXml(Blob specificXml) {
		this.specificXml = specificXml;
	}
	
	public void setSpecificXml(String specificXml) {
		this.specificXml = specificXml!=null?Hibernate.createBlob(specificXml.getBytes()):null;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}
	
	public String getIsFile() {
		return isFile;
	}
	
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	
}