package com.stpl.pms.exception;

import java.io.PrintStream;

public class PMSException extends Exception{
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private Integer errorCode;

	public PMSException() {
		super();
	}

	public PMSException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public PMSException(String errorMessage, Throwable throwable) {
		super(errorMessage, throwable);
		this.errorMessage = errorMessage;		
	}

	public PMSException(int errorCode) {
		this.errorCode = errorCode;
	}

	public PMSException(Integer errorCode, String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	public PMSException(Integer errorCode, String errorMessage, Throwable throwable) {
		super(errorMessage,throwable);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
    public void printStackTrace(){
        if(getErrorCode()!=null && (PMSErrorCode.PLR_USER_NAME_EMAIL_MOBILE_EXIST==getErrorCode()||PMSErrorCode.PLR_USER_NAME_EMAIL_EXIST==getErrorCode()||
                PMSErrorCode.PLR_USER_NAME_MOBILE_EXIST==getErrorCode()||PMSErrorCode.PLR_EMAIL_MOBILE_EXIST==getErrorCode()||
                PMSErrorCode.PLR_NOT_EXIST==getErrorCode()||PMSErrorCode.PLR_USER_NAME_EXIST==getErrorCode()||PMSErrorCode.PLR_EMAIL_EXIST==getErrorCode()||
                PMSErrorCode.PLR_MOBILE_NO_EXIST==getErrorCode()||PMSErrorCode.TXN_INSUFFICIENT_BALANCE==getErrorCode()||
                PMSErrorCode.TXN_INSUFFICIENT_BALANCE_TO_DEBIT==getErrorCode()||PMSErrorCode.TXN_INSUFFICIENT_TICKET_BALANCE==getErrorCode()||
                PMSErrorCode.POKER_PLR_INSUFFICIENT_BAL==getErrorCode()||
                PMSErrorCode.INVALID_USER_PWD==getErrorCode())){

            printSingleMessage();

        }
        else{

            super.printStackTrace();

        }

    }

    public void printSingleMessage(){
        printSingleMessage(System.err);
    }

    public void printSingleMessage(PrintStream s){
        synchronized (s){
            s.println(this);
        }
    }
}
