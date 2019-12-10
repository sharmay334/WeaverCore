package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class StTpCustomMsg implements Serializable {

	/**
	 * @author pankaj kumar
	 */
	private static final long serialVersionUID = -1165351643982654544L;
	private long id;
	private String statusCode;
	private String customMsg;
	private String preferredWallet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getCustomMsg() {
		return customMsg;
	}

	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}

	public String getPreferredWallet() {
		return preferredWallet;
	}

	public void setPreferredWallet(String preferredWallet) {
		this.preferredWallet = preferredWallet;
	}
}