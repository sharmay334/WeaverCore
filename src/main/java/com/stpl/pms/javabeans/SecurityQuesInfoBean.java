package com.stpl.pms.javabeans;

public class SecurityQuesInfoBean implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer secQues;
	private String displayName; 
	private String addedBy;
	private String status;
	private Long userId;
	private String userName;
	
	public String getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setSecQues(Integer secQues) {
		this.secQues = secQues;
	}
	public Integer getSecQues() {
		return secQues;
	}
	
	public boolean equals(SecurityQuesInfoBean quesInfoBeanObj){
		return(this.secQues == quesInfoBeanObj.secQues && this.status == quesInfoBeanObj.status);
		
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDisplayName() {
		return displayName;
	}

}
