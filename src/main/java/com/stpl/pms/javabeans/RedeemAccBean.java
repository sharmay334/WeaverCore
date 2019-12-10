package com.stpl.pms.javabeans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
@JsonSerialize(include = Inclusion.NON_NULL)

public class RedeemAccBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long playerId;

	private PlrRedeemAccChequeInfoBean chqAccInfo;
	private HashMap<Long, PlrRedeemAccBankInfoBean> bankRedAccMap;
	private PlrRedeemAccCshPayInfoBean cshPayRedAcc;
    private PlrRedeemAccPrepaidWalletInfoBean prepaidAcc;
    private List<PlrRedeemAccWariInfoBean> wariAcc;

    private Map<Integer,PlrRedeemAccMobMoneyInfoBean> MobileMoneyAccMap;

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public PlrRedeemAccChequeInfoBean getChqAccInfo() {
		return chqAccInfo;
	}

	public void setChqAccInfo(PlrRedeemAccChequeInfoBean chqAccInfo) {
		this.chqAccInfo = chqAccInfo;
	}

	public void setBankRedAccMap(
			HashMap<Long, PlrRedeemAccBankInfoBean> bankRedAccMap) {
		this.bankRedAccMap = bankRedAccMap;
	}

	public HashMap<Long, PlrRedeemAccBankInfoBean> getBankRedAccMap() {
		return bankRedAccMap;
	}

	public void setCshPayRedAcc(PlrRedeemAccCshPayInfoBean cshPayRedAcc) {
		this.cshPayRedAcc = cshPayRedAcc;
	}

	public PlrRedeemAccCshPayInfoBean getCshPayRedAcc() {
		return cshPayRedAcc;
	}
	
	public PlrRedeemAccPrepaidWalletInfoBean getPrepaidAcc() {
		return prepaidAcc;
	}
	
	public void setPrepaidAcc(PlrRedeemAccPrepaidWalletInfoBean prepaidAcc) {
		this.prepaidAcc = prepaidAcc;
	}


    public Map<Integer, PlrRedeemAccMobMoneyInfoBean> getMobileMoneyAccMap() {
        return MobileMoneyAccMap;
    }

    public void setMobileMoneyAccMap(Map<Integer, PlrRedeemAccMobMoneyInfoBean> mobileMoneyAccMap) {
        MobileMoneyAccMap = mobileMoneyAccMap;
    }

	public List<PlrRedeemAccWariInfoBean> getWariAcc() {
		return wariAcc;
	}

	public void setWariAcc(List<PlrRedeemAccWariInfoBean> wariAcc) {
		this.wariAcc = wariAcc;
	}

    
}
