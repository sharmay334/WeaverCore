package com.stpl.pms.javabeans;

public class RespGamingLimitBean implements Cloneable,java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String criteria;
	private String errorMsg;
	private int limit;

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	@Override
	public RespGamingLimitBean clone() throws CloneNotSupportedException {
		return (RespGamingLimitBean) super.clone();
	}

	@Override
	public String toString() {
		return "RespGamingLimitBean [criteria=" + criteria + ", errorMsg="
				+ errorMsg + ", limit=" + limit + "]";
	}
	
	
}
