package com.stpl.pms.javabeans;

public class UserPrivBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pid;
	private String privRelatedTo;
	private String privTitle;
	private String status;

	public int getPid() {
		return pid;
	}

	public String getPrivRelatedTo() {
		return privRelatedTo;
	}

	public String getPrivTitle() {
		return privTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPrivRelatedTo(String privRelatedTo) {
		this.privRelatedTo = privRelatedTo;
	}

	public void setPrivTitle(String privTitle) {
		this.privTitle = privTitle;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}