package com.stpl.pms.javabeans;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.stpl.pms.constants.InterswitchPaymentGatewayProperties;
import com.stpl.pms.hibernate.mapping.StCshPaySubMasterBankTrans;
import com.stpl.pms.hibernate.mapping.StCshPaymentOptionsDomainMapping;
import com.stpl.pms.hibernate.mapping.StCshPlrRedeemAccInfoBank;
import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StTxnPlrWithdrawalMaster;
import com.stpl.pms.javabeans.InterSwitchDepReqBean.Initiation.AccountReceivable;

@XmlRootElement (name="RequestDetails")
public class InterSwitchDepReqBean {

	private String entityCode;
	private String mac;
	private String transferCode;

	public static class Sender {
		private String lastName;
		private String otherName;
		private String email;
		private String phoneNo;

		public String getLastName() {
			return lastName;
		}

		@XmlElement (name="Lastname")
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getOtherName() {
			return otherName;
		}

		@XmlElement (name="Othernames")
		public void setOtherName(String otherName) {
			this.otherName = otherName;
		}

		public String getEmail() {
			return email;
		}

		@XmlElement (name="Email")
		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		@XmlElement (name="Phone")
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
	}
	private Sender sender;

	public static class Beneficiary extends Sender {
		
	}
	private Beneficiary beneficiary;

	public static class Initiation {
		private String amount;
		private String channel;
		private String paymentMethodCode;
		private String currencyCode;
		private String countryCode;
		private String depositSlip;
		private String entityCode;
		private Sender processor;

		public static class AccountReceivable {
			private String accountNumber;
			private String accountType;

			public String getAccountNumber() {
				return accountNumber;
			}

			@XmlElement (name="AccountNumber")
			public void setAccountNumber(String accountNumber) {
				this.accountNumber = accountNumber;
			}

			public String getAccountType() {
				return accountType;
			}

			@XmlElement (name="AccountType")
			public void setAccountType(String accountType) {
				this.accountType = accountType;
			}
		}
		private AccountReceivable accountReceivable;

		public String getAmount() {
			return amount;
		}

		@XmlElement (name="Amount")
		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getChannel() {
			return channel;
		}

		@XmlElement (name="Channel")
		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getPaymentMethodCode() {
			return paymentMethodCode;
		}

		@XmlElement (name="PaymentMethodCode")
		public void setPaymentMethodCode(String paymentMethodCode) {
			this.paymentMethodCode = paymentMethodCode;
		}

		public String getCurrencyCode() {
			return currencyCode;
		}

		@XmlElement (name="CurrencyCode")
		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}

		public String getCountryCode() {
			return countryCode;
		}

		@XmlElement (name="CountryCode")
		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}

		public String getDepositSlip() {
			return depositSlip;
		}

		@XmlElement (name="DepositSlip")
		public void setDepositSlip(String depositSlip) {
			this.depositSlip = depositSlip;
		}

		public String getEntityCode() {
			return entityCode;
		}

		@XmlElement (name="EntityCode")
		public void setEntityCode(String entityCode) {
			this.entityCode = entityCode;
		}

		public Sender getProcessor() {
			return processor;
		}

		@XmlElement (name="Processor")
		public void setProcessor(Sender processor) {
			this.processor = processor;
		}

		public AccountReceivable getAccountReceivable() {
			return accountReceivable;
		}

		@XmlElement (name="AccountReceivable")
		public void setAccountReceivable(AccountReceivable accountReceivable) {
			this.accountReceivable = accountReceivable;
		}
	}
	private Initiation initiation;
	private Initiation termination;

	public String getEntityCode() {
		return entityCode;
	}

	@XmlElement (name="InitiatingEntityCode")
	private void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getMac() {
		return mac;
	}

	@XmlElement (name="MAC")
	private void setMac(String mac) {
		this.mac = mac;
	}

	public String getTransferCode() {
		return transferCode;
	}

	@XmlElement (name="TransferCode")
	private void setTransferCode(String transferCode) {
		this.transferCode = transferCode;
	}

	public Sender getSender() {
		return sender;
	}

	@XmlElement (name="Sender")
	private void setSender(Sender sender) {
		this.sender = sender;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	@XmlElement (name="Beneficiary")
	private void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Initiation getInitiation() {
		return initiation;
	}

	@XmlElement (name="Initiation")
	private void setInitiation(Initiation initiation) {
		this.initiation = initiation;
	}

	public Initiation getTermination() {
		return termination;
	}

	@XmlElement (name="Termination")
	private void setTermination(Initiation termination) {
		this.termination = termination;
	}

	private InterSwitchDepReqBean() {
	}

	public static InterSwitchDepReqBean createObject(StTxnPlrWithdrawalMaster wdrMas, 
			StCshPaymentOptionsDomainMapping podm,Map<Integer,String> propMap) throws Exception {
		InterSwitchDepReqBean requestBean = new InterSwitchDepReqBean();
		DecimalFormat decimalFormat=new DecimalFormat("#.#");
		String amountFormatted = decimalFormat.format(wdrMas.getToAmount()*100);
		requestBean.setEntityCode(propMap.get(InterswitchPaymentGatewayProperties.p5.getPropertyId()));
		requestBean.setTransferCode(getTransferCode(wdrMas.getTransactionId()));
		
		Sender sender = new Sender();
		sender.setLastName(propMap.get(InterswitchPaymentGatewayProperties.p6.getPropertyId()));
		sender.setOtherName(propMap.get(InterswitchPaymentGatewayProperties.p7.getPropertyId()));
		sender.setEmail(propMap.get(InterswitchPaymentGatewayProperties.p8.getPropertyId()));
		sender.setPhoneNo(propMap.get(InterswitchPaymentGatewayProperties.p9.getPropertyId()));
		requestBean.setSender(sender);
		
		Beneficiary beneficiary = new Beneficiary();
		StPmPlayerMaster pm = wdrMas.getPlrMaster();
		beneficiary.setLastName(pm.getUserName());
		beneficiary.setOtherName(pm.getUserName());
		beneficiary.setEmail(pm.getEmailId());
		beneficiary.setPhoneNo(pm.getMobileNo().toString());
		requestBean.setBeneficiary(beneficiary);

		Initiation initiation = new Initiation();
		initiation.setAmount(amountFormatted);
		initiation.setChannel(propMap.get(InterswitchPaymentGatewayProperties.p10.getPropertyId()));
		initiation.setPaymentMethodCode(propMap.get(InterswitchPaymentGatewayProperties.p11.getPropertyId()));
		initiation.setCurrencyCode(propMap.get(InterswitchPaymentGatewayProperties.p3.getPropertyId()));
		initiation.setDepositSlip("");
		
		Sender processor = new Sender();
		processor.setLastName("");
		processor.setOtherName("");
		initiation.setProcessor(processor);
		
		requestBean.setInitiation(initiation);

		Initiation termination = new Initiation();
		termination.setPaymentMethodCode(propMap.get(InterswitchPaymentGatewayProperties.p12.getPropertyId()));
		termination.setAmount(amountFormatted);
		termination.setCurrencyCode(propMap.get(InterswitchPaymentGatewayProperties.p3.getPropertyId()));
		termination.setCountryCode(propMap.get(InterswitchPaymentGatewayProperties.p13.getPropertyId()));
		String bankCode = ((StCshPaySubMasterBankTrans)podm.getPaySubTypeMas()).getBankCode();
		termination.setEntityCode(bankCode);
		AccountReceivable receivable = new AccountReceivable();
		StCshPlrRedeemAccInfoBank rdAcc = (StCshPlrRedeemAccInfoBank)wdrMas.getRedeemAccMas();
		receivable.setAccountNumber(rdAcc.getAccNum());
		receivable.setAccountType("SAVING".equals(rdAcc.getAccType())?"10":"20");
		termination.setAccountReceivable(receivable);
		requestBean.setTermination(termination);
		String mac = generateHash(initiation.getAmount(), initiation.getCurrencyCode(), initiation.getPaymentMethodCode(), termination.getAmount(), termination.getCurrencyCode(), termination.getPaymentMethodCode(), termination.getCountryCode());
		System.out.println("MAC Generated - "+mac);
		requestBean.setMac(mac);
		return requestBean;
	}
	
	public static String getTransferCode(long transactionId) {
		String appender = null;

		int length = String.valueOf(transactionId).length();

		switch (length) {
		case 4:
			appender = "1000";
			break;
		case 5:
			appender = "100";
			break;
		case 6:
			appender = "10";
			break;
		case 7:
			appender = "1";
			break;
		default:
			appender = "";
			break;
		}

		return "1214"+appender+transactionId;
	}
	
	public static String generateHash(String... params) throws Exception {
		StringBuilder messageBuilder = new StringBuilder();
		for(String param : params) {
			messageBuilder.append(param);
		}

		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(messageBuilder.toString().getBytes());
		byte[] mdbytes = md.digest();

		StringBuilder hashBuilder = new StringBuilder();
		for (int i = 0; i < mdbytes.length; i++) {
			hashBuilder.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		return hashBuilder.toString().toUpperCase();
	}
}