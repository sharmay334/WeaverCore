package com.stpl.pms.javabeans;

import java.util.List;

public class NetGamingTxnReportBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String domainName;
	private List<NetGamingReportBean> playerTransaction;

	public NetGamingTxnReportBean() {
	}

	public NetGamingTxnReportBean(String domainName,
			List<NetGamingReportBean> playerTransaction) {
		this.domainName = domainName;
		this.playerTransaction = playerTransaction;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<NetGamingReportBean> getPlayerTransaction() {
		return playerTransaction;
	}

	public void setPlayerTransaction(List<NetGamingReportBean> playerTransaction) {
		this.playerTransaction = playerTransaction;
	}

	@Override
	public String toString() {
		return "NetGamingTxnReportBean [domainName=" + domainName
				+ ", playerTransaction=" + playerTransaction + "]";
	}

}
