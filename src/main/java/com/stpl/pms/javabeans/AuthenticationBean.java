package com.stpl.pms.javabeans;

public class AuthenticationBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String usernameType;
	private String password;
	private String salt;
	private String firsttimeuser;
	private String emailId;
	private String interfaceType;
	private String fbId;
	private Short domainId;

	public String getFirsttimeuser() {
		return firsttimeuser;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setFirsttimeuser(String firsttimeuser) {
		this.firsttimeuser = firsttimeuser;
	}


	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getEmailId() {
		return emailId;
	}

	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String getUsernameType() {
		return usernameType;
	}

	public void setUsernameType(String usernameType) {
		this.usernameType = usernameType;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getFbId() {
		return fbId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getDomainId() {
		return domainId;
	}

}
