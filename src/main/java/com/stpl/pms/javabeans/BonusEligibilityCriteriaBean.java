package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

public class BonusEligibilityCriteriaBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private List<Integer> countryId;
	private List<Integer> stateId;//code added to add state list according to the country selected
	private List<Integer> vipLevelId;
	private String playerType;
	private List<BonusCriteriaListBean> criteriaList;
	private List<String> userNameList;
	private List<String> emailList;

	private String playerStatus;
	private String emailVerification;
	private String mobileVerification;
	private String isDepositor;
	private String isUserNameListByFile;
	private List<Integer> campIdList;
	
	
	
	public String getPlayerStatus() {
		return playerStatus;
	}

	public void setPlayerStatus(String playerStatus) {
		this.playerStatus = playerStatus;
	}

	public String getEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(String emailVerification) {
		this.emailVerification = emailVerification;
	}

	public String getMobileVerification() {
		return mobileVerification;
	}

	public void setMobileVerification(String mobileVerification) {
		this.mobileVerification = mobileVerification;
	}

	public String getIsDepositor() {
		return isDepositor;
	}

	public void setIsDepositor(String isDepositor) {
		this.isDepositor = isDepositor;
	}

	public List<Integer> getStateId() {
		return stateId;
	}

	public void setStateId(List<Integer> stateId) {
		this.stateId = stateId;
	}

	public void setStateId(Integer stateId) {
		if(this.stateId ==null)
			this.stateId = new ArrayList<Integer>();
		this.stateId.add(stateId);
	}
	
	public List<Integer> getCountryId() {
		return countryId;
	}

	public void setCountryId(List<Integer> countryId) {
		this.countryId = countryId;
	}
	
	public void setCountryId(Integer countryId) {
		if(this.countryId ==null)
			this.countryId = new ArrayList<Integer>();
		this.countryId.add(countryId);
	}

	public List<Integer> getVipLevelId() {
		return vipLevelId;
	}

	public void setVipLevelId(List<Integer> vipLevelId) {
		this.vipLevelId = vipLevelId;
	}
	
	public void setVipLevelId(Integer vipLevelId) {
		if(this.vipLevelId ==null)
			this.vipLevelId = new ArrayList<Integer>();
		this.vipLevelId.add(vipLevelId);
	}
	
	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public List<BonusCriteriaListBean> getCriteriaList() {
		return criteriaList;
	}

	public void setCriteriaList(List<BonusCriteriaListBean> criteriaList) {
		this.criteriaList = criteriaList;
	}
	
	public void setCriteriaList(BonusCriteriaListBean criteriaList) {
		if(this.criteriaList ==null)
			this.criteriaList = new ArrayList<BonusCriteriaListBean>();
		this.criteriaList.add(criteriaList);
	}
	
	public boolean isApplicable(int vipLevel,int countryId,String playerType,String userName,String emailId, String eligibilityGroup,Integer stateId, String playerStatus,
			String emailVerification, String mobileVerification, String isDepositor,Integer campId) {
		boolean isChk=false;
		if ("PLR_USERNAME_LIST".equals(eligibilityGroup) && userNameList!=null && userNameList.contains(userName)) {
			isChk=true;
		}
		
		if ("EMAIL_LIST".equals(eligibilityGroup) && emailList!=null && emailList.contains(emailId)) {
			isChk="BOTH".equals(this.playerType)?true:this.playerType.equals(playerType);
		}

		if(("GENERIC_CRITERIA".equals(eligibilityGroup)||"SPECIFIC_CRITERIA".equals(eligibilityGroup))){
			boolean chk = true;
			if(vipLevelId!=null && !vipLevelId.contains(vipLevel)){
				chk=false;
			}
			if(chk && this.countryId!=null && !this.countryId.contains(countryId)){
				chk=false;
			}
			if(chk && (this.stateId!=null && !this.stateId.contains(stateId))){
				chk=false;
			}
			if(chk && (this.playerStatus!=null && !this.playerStatus.contains(playerStatus))){
				chk=false;
			}
			if(chk && (this.emailVerification!=null && this.emailVerification.indexOf(emailVerification) ==-1))
			{
				chk=false;
			}
			if(chk && (this.mobileVerification!=null && this.mobileVerification.indexOf(mobileVerification) ==-1))
			{
				chk=false;
			}
			if(chk && (this.isDepositor!=null && !this.isDepositor.equals(isDepositor)))
			{
				chk=false;
			}
			if(chk && !("BOTH".equals(this.playerType) || this.playerType.equals(playerType))){
				chk=false;
			}
			if(chk && this.campIdList!=null && !this.campIdList.contains(campId)){
				chk=false;
			}
			isChk = chk;
		}
		return isChk;
	}
	
	public void setUserNameList(List<String> userNameList) {
		this.userNameList = userNameList;
	}
	
	public void setUserNameList(String userName) {
		if(this.userNameList ==null)
			this.userNameList = new ArrayList<String>();
		this.userNameList.add(userName);
	}

	public List<String> getUserNameList() {
		return userNameList;
	}

	public void setEmailList(List<String> emailList) {
		this.emailList = emailList;
	}

	public void setEmailList(String email) {
		if(this.emailList ==null)
			this.emailList = new ArrayList<String>();
		this.emailList.add(email);
	}
	
	public List<String> getEmailList() {
		return emailList;
	}
	
	

	public String getIsUserNameListByFile() {
		return isUserNameListByFile;
	}

	public void setIsUserNameListByFile(String isUserNameListByFile) {
		this.isUserNameListByFile = isUserNameListByFile;
	}
	


	public List<Integer> getCampIdList() {
		return campIdList;
	}

	public void setCampIdList(List<Integer> campIdList) {
		this.campIdList = campIdList;
	}
	
	public void setCampIdList(Integer campId) {
		if(this.campIdList ==null)
			this.campIdList = new ArrayList<Integer>();
		this.campIdList.add(campId);
	}

	@Override
	public String toString() {
		return "BonusEligibilityCriteriaBean [countryId=" + countryId + ", stateId=" + stateId + ", vipLevelId="
				+ vipLevelId + ", playerType=" + playerType + ", criteriaList=" + criteriaList + ", userNameList="
				+ userNameList + ", emailList=" + emailList + ", playerStatus=" + playerStatus + ", emailVerification="
				+ emailVerification + ", mobileVerification=" + mobileVerification + ", isDepositor=" + isDepositor
				+ ", isUserNameListByFile=" + isUserNameListByFile + "]";
	}
}
