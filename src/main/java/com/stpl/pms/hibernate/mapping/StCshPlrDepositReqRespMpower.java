package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositReqRespMpower entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositReqRespMpower implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long requestId;
	private String token;
	private String oprToken;
	private String redirectUrl;
	private String respCode;
	private String respText;
	private String description;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPlrDepositReqRespMpower() {
	}

	/** minimal constructor */
	public StCshPlrDepositReqRespMpower(Long requestId, String token) {
		this.requestId = requestId;
		this.token = token;
	}

	/** full constructor */
	public StCshPlrDepositReqRespMpower(Long requestId, String token,
			String oprToken, String redirectUrl, String respCode,
			String respText, String description, String status) {
		this.requestId = requestId;
		this.token = token;
		this.oprToken = oprToken;
		this.redirectUrl = redirectUrl;
		this.respCode = respCode;
		this.respText = respText;
		this.description = description;
		this.status = status;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOprToken() {
		return this.oprToken;
	}

	public void setOprToken(String oprToken) {
		this.oprToken = oprToken;
	}

	public String getRedirectUrl() {
		return this.redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getRespCode() {
		return this.respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespText() {
		return this.respText;
	}

	public void setRespText(String respText) {
		this.respText = respText;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}