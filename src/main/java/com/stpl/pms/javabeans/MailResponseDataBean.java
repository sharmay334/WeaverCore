package com.stpl.pms.javabeans;

import java.io.Serializable;

public class MailResponseDataBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String TotalNumberOfRecipients;
	private String NoOfEmailsSent;
	private String NoOfUnsentEmails;
	private String NoOfSuppressedEmails;
	private String NoOfFilteredEmails;
	private String Message;
	private String Errorcode;
	public String getTotalNumberOfRecipients() {
		return TotalNumberOfRecipients;
	}
	public void setTotalNumberOfRecipients(String totalNumberOfRecipients) {
		TotalNumberOfRecipients = totalNumberOfRecipients;
	}
	public String getNoOfEmailsSent() {
		return NoOfEmailsSent;
	}
	public void setNoOfEmailsSent(String noOfEmailsSent) {
		NoOfEmailsSent = noOfEmailsSent;
	}
	public String getNoOfUnsentEmails() {
		return NoOfUnsentEmails;
	}
	public void setNoOfUnsentEmails(String noOfUnsentEmails) {
		NoOfUnsentEmails = noOfUnsentEmails;
	}
	public String getNoOfSuppressedEmails() {
		return NoOfSuppressedEmails;
	}
	public void setNoOfSuppressedEmails(String noOfSuppressedEmails) {
		NoOfSuppressedEmails = noOfSuppressedEmails;
	}
	public String getNoOfFilteredEmails() {
		return NoOfFilteredEmails;
	}
	public void setNoOfFilteredEmails(String noOfFilteredEmails) {
		NoOfFilteredEmails = noOfFilteredEmails;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getErrorcode() {
		return Errorcode;
	}
	public void setErrorcode(String errorcode) {
		Errorcode = errorcode;
	}

}
