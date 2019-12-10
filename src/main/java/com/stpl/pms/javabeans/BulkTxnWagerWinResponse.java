package com.stpl.pms.javabeans;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
@JsonSerialize(include = Inclusion.NON_NULL)
public class BulkTxnWagerWinResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMsg;
	private Long playerId;
	private Double totalBal;
	private Double realBal;
	private String sessionId;
	private String serviceCode;
//	private List<BulkTxnStatusBean> txnStatusList;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Double getTotalBal() {
		return totalBal;
	}
	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}
	public Double getRealBal() {
		return realBal;
	}
	public void setRealBal(Double realBal) {
		this.realBal = realBal;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/*public void setWagerResponse(PlayerBulkTxnResponseBean txnResponse) {
//		playerId=txnResponse.getPlayerId();
		totalBal=txnResponse.getTotalBal();
		realBal=txnResponse.getRealBal();
		if(txnResponse.getTransactionInfoList()!=null && txnResponse.getTransactionInfoList().size()==1){
			wagerStatus=txnResponse.getTransactionInfoList().get(0).fetchBulkTxnStatusBean();
		}
	}
	public void setWinningResponse(TxnRespBean winningResponse) {
		if(winningResponse.getPlrWiseRespBean()!=null && winningResponse.getPlrWiseRespBean().size()>0){
			if(winStatus==null)
				winStatus=winningResponse.getPlrWiseRespBean().get(0).getBulkTxnStatusBean();
			
			//updating balance; 
			totalBal=winStatus.getTotalBal();
			realBal=winStatus.getRealBal();
			winStatus.setTotalBal(null);
			winStatus.setRealBal(null);
		}
		
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public BulkTxnStatusBean getWinStatus() {
		return winStatus;
	}
	public void setWinStatus(BulkTxnStatusBean winStatus) {
		this.winStatus = winStatus;
	}
	public BulkTxnStatusBean getWagerStatus() {
		return wagerStatus;
	}
	public void setWagerStatus(BulkTxnStatusBean wagerStatus) {
		this.wagerStatus = wagerStatus;
	}*/
}
