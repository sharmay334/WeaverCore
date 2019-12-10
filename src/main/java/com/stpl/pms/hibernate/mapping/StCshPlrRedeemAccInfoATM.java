package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class StCshPlrRedeemAccInfoATM extends StCshPlrRedeemAccMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	private StCshPaySubMaster subTypeMas;
	
	public StCshPlrRedeemAccInfoATM() {
		
	}

	public StCshPlrRedeemAccInfoATM(StCshPlrRedeemAccMaster redAccMaster,
			 String status, StCshPaySubMaster subTypeMas) {
		super(redAccMaster.getPaymentType(),
				redAccMaster.getProviderId(), 0l,
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.status = status;
		this.subTypeMas = subTypeMas;
	}
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StCshPaySubMaster getSubTypeMas() {
		return subTypeMas;
	}
	public void setSubTypeMas(StCshPaySubMaster subTypeMas) {
		this.subTypeMas = subTypeMas;
	}
	
	
	

}
