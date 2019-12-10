package com.stpl.pms.javabeans;

public class PlayGameData implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private MostGamePlayedDataBean mostGamePlayedData;
	private ReferralPlayerData referralPlayerData;
	private IpData ipData;
	
	public MostGamePlayedDataBean getMostGamePlayedData() {
		return mostGamePlayedData;
	}

	public void setMostGamePlayedData(MostGamePlayedDataBean mostGamePlayedData) {
		this.mostGamePlayedData = mostGamePlayedData;
	}

	public ReferralPlayerData getReferralPlayerData() {
		return referralPlayerData;
	}

	public void setReferralPlayerData(ReferralPlayerData referralPlayerData) {
		this.referralPlayerData = referralPlayerData;
	}

	public IpData getIpData() {
		return ipData;
	}

	public void setIpData(IpData ipData) {
		this.ipData = ipData;
	}

	@Override
	public String toString() {
		return "PlayGameData [mostGamePlayedData=" + mostGamePlayedData
				+ ", referralPlayerData=" + referralPlayerData + ", ipData="
				+ ipData + "]";
	}

}