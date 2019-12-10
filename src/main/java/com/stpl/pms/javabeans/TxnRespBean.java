package com.stpl.pms.javabeans;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class TxnRespBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String txnType;
	private int errorCode;
	private String errorMsg;
	private String serviceCode;
	
	private List<PlrWiseTxnRespBean>plrWiseRespBean;
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnType() {
		return txnType;
	}

	@Override
	public String toString() {
		return "PlayerTxnResponseBean [confirmWagerRespBean=" + plrWiseRespBean
				+ ", errorCode=" + errorCode + ", errorMsg=" + errorMsg
				+ ", txnType=" + txnType + "]";
	}

	public List<PlrWiseTxnRespBean> getPlrWiseRespBean() {
		return plrWiseRespBean;
	}

	public void setPlrWiseRespBean(List<PlrWiseTxnRespBean> plrWiseRespBean) {
		this.plrWiseRespBean = plrWiseRespBean;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

}
