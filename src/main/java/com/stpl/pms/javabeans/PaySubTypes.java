package com.stpl.pms.javabeans;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stpl.pms.hibernate.mapping.StCshPaySubMaster;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterBackOffice;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterBankTrans;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterCc;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterCshColln;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterCshcard;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterCshpay;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterDc;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterFreecharge;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterMobileWallet;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterNb;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterPaytm;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterPrepaid;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterUPI;


public enum PaySubTypes {
	CREDIT_CARD(StCshPaySubMasterCc.class,"cardName"),
	DEBIT_CARD(StCshPaySubMasterDc.class,"cardName"),
	NET_BANKING(StCshPaySubMasterNb.class,"bankNameDispCode"),
	CASH_PAYMENT(StCshPaySubMasterCshpay.class,"cshpayTypeDispCode"),
	CASH_COLLECTION(StCshPaySubMasterCshColln.class,"city"),
	BANK_TRANS(StCshPaySubMasterBankTrans.class,"bankNameDispCode"),
	CASH_CARD(StCshPaySubMasterCshcard.class,"cardName"),
	PREPAID_WALLET(StCshPaySubMasterPrepaid.class,"walletName"),
	MOBILE_MONEY(StCshPaySubMasterMobileWallet.class,"walletName"),
	PAYTM_WALLET(StCshPaySubMasterPaytm.class,"walletName"),
	MOBILE_WALLET(StCshPaySubMasterMobileWallet.class,"walletName"),	
	UPI_PAYMENT(StCshPaySubMasterUPI.class,"walletName"),
	BACK_OFFICE(StCshPaySubMasterBackOffice.class,"walletName"),
	FREECHARGE_WALLET(StCshPaySubMasterFreecharge.class,"walletName");
	
	private StCshPaySubMaster obj;
	private String tableName;
	private String className;
	private String displayProp;

	PaySubTypes(Class<? extends StCshPaySubMaster> clazz,String displayProp) {
		this.displayProp=displayProp;
		try {
			this.obj=clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public StCshPaySubMaster getInstance() {
		return this.obj;
	}
	
	public String getClassName() {
		if(this.className==null){
			int length=this.obj.getClass().getName().split("\\.").length;
			this.className=this.obj.getClass().getName().split("\\.")[length-1];
			System.out.println("----------------Initialised Cache for Class Name!-----------------");
		}
		return this.className;
	}
	
	public String getTableName() {
		//Initialising cache...
		if (this.tableName==null){
			Pattern p= Pattern.compile("([A-Z][a-z]*)");
			Matcher m=p.matcher(getClassName());
			StringBuilder sb=new StringBuilder();
			while(m.find())
				sb.append(m.group().toLowerCase()+'_');
			sb.deleteCharAt(sb.length()-1);
			if("st_csh_pay_sub_master_mobile_wallet".equals(sb.toString()))
				sb=new StringBuilder("st_csh_pay_sub_master_mobile_money");
			this.tableName=sb.toString();
		}
		return this.tableName;
	}
	
	public String getDispProperty() {
		return this.displayProp;
	}
	
}
