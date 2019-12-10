package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlaceHolderCriteriaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String criteriaName;
	private String plrType;
	private List<String> vipLevelId;
	private List<String> userNameList;
	private List<String> emailList;
	private boolean referFriend;
	private boolean directPlayer;
	private boolean affiliatePlayer;
	private boolean olaPlayer;
	private boolean ppcPlayer;
	private List<String> ppcCampaign;
	private String criteriaWise;
	private List<String> criteriaSelect;
	private int phCriteriaId;
	private Map<Long, String> campNames;
	private String isFile;
	
	
	
	public boolean isOlaPlayer() {
		return olaPlayer;
	}
	public void setOlaPlayer(boolean olaPlayer) {
		this.olaPlayer = olaPlayer;
	}
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public String getPlrType() {
		return plrType;
	}
	public void setPlrType(String plrType) {
		this.plrType = plrType;
	}
	public List<String> getUserNameList() {
		return userNameList;
	}
	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}
	public List<String> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}
	public boolean isReferFriend() {
		return referFriend;
	}
	public void setReferFriend(boolean referFriend) {
		this.referFriend = referFriend;
	}
	public boolean isDirectPlayer() {
		return directPlayer;
	}
	public void setDirectPlayer(boolean directPlayer) {
		this.directPlayer = directPlayer;
	}
	public boolean isAffiliatePlayer() {
		return affiliatePlayer;
	}
	public void setAffiliatePlayer(boolean affiliatePlayer) {
		this.affiliatePlayer = affiliatePlayer;
	}
	public boolean isPpcPlayer() {
		return ppcPlayer;
	}
	public void setPpcPlayer(boolean ppcPlayer) {
		this.ppcPlayer = ppcPlayer;
	}
	public List<String> getPpcCampaign() {
		return ppcCampaign;
	}
	public void setPpcCampaign(List<String> ppcCampaign) {
		this.ppcCampaign = ppcCampaign;
	}
	public void setPpcCampaign(String ppcCamp){
		if(this.ppcCampaign == null){
			this.ppcCampaign = new ArrayList<String>();
		}
		this.ppcCampaign.add(ppcCamp);
	}
	public String getCriteriaWise() {
		return criteriaWise;
	}
	public void setCriteriaWise(String criteriaWise) {
		this.criteriaWise = criteriaWise;
	}
	public List<String> getCriteriaSelect() {
		return criteriaSelect;
	}
	public void setCriteriaSelect(List<String> criteriaSelect) {
		this.criteriaSelect = criteriaSelect;
	}
	public void setCriteriaSelect(String criteria) {
		if(this.criteriaSelect == null){
			this.criteriaSelect = new ArrayList<String>();
		}
		this.criteriaSelect.add(criteria);
	}
	public List<String> getVipLevelId() {
		return vipLevelId;
	}
	public void setVipLevelId(List<String> vipLevelId) {
		this.vipLevelId = vipLevelId;
	}
	public void setVipLevelId(String vipId){
		if(this.vipLevelId == null){
			this.vipLevelId = new ArrayList<String>();
		}
		this.vipLevelId.add(vipId);
	}
	public int getPhCriteriaId() {
		return phCriteriaId;
	}
	public void setPhCriteriaId(int phCriteriaId) {
		this.phCriteriaId = phCriteriaId;
	}
	public Map<Long, String> getCampNames() {
		return campNames;
	}
	public void setCampNames(Map<Long, String> campNames) {
		this.campNames = campNames;
	}
	public String getIsFile() {
		return isFile;
	}
	public void setIsFile(String isFile) {
		this.isFile = isFile;
	}
	
	
	
	
}
