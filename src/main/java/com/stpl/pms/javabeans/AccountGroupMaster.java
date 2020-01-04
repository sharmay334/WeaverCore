package com.stpl.pms.javabeans;

public class AccountGroupMaster {
	private int groupId;
	private String groupName;
	private String groupUnder;
	private String subLedger;
	private String blncForRep;
	private String forCalc;
	private String purInvoice;
	private String groupUnderName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupUnder() {
		return groupUnder;
	}

	public void setGroupUnder(String groupUnder) {
		this.groupUnder = groupUnder;
	}

	public String getSubLedger() {
		return subLedger;
	}

	public void setSubLedger(String subLedger) {
		this.subLedger = subLedger;
	}

	public String getBlncForRep() {
		return blncForRep;
	}

	public void setBlncForRep(String blncForRep) {
		this.blncForRep = blncForRep;
	}

	public String getForCalc() {
		return forCalc;
	}

	public void setForCalc(String forCalc) {
		this.forCalc = forCalc;
	}

	public String getPurInvoice() {
		return purInvoice;
	}

	public void setPurInvoice(String purInvoice) {
		this.purInvoice = purInvoice;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupUnderName() {
		return groupUnderName;
	}

	public void setGroupUnderName(String groupUnderName) {
		this.groupUnderName = groupUnderName;
	}

}
