package com.stpl.pms.javabeans;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SheriffGamingRealBonusBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//decimal not needed in balance.
	private String bonus;
	private String real;
	


	public String getReal() {
		return real;
	}

	public void setReal(String real) {
		this.real = real;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String txnSignatureString() throws UnsupportedEncodingException {
		return URLEncoder.encode("transaction[real]","UTF-8")+"="+real+"&"+URLEncoder.encode("transaction[bonus]","UTF-8")+"="+bonus;
	}

	@Override
	public String toString() {
		return "SheriffGamingRealBonusBean [real=" + real + ", bonus=" + bonus
		+ "]";

	}

	

}
