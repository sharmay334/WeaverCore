package com.stpl.pms.utility;

import java.util.HashMap;
import java.util.Map;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;

public class RequiredFieldError {
	
	public static Map<String,Integer> errCode() {
		Map<String,Integer> errCodeMap = new HashMap<String,Integer>();
		errCodeMap.put("firstName",PMSErrorCode.PLR_FIRST_NAME_NOT_PROVIDED);
		errCodeMap.put("lastName",PMSErrorCode.PLR_LAST_NAME_NOT_PROVIDED);
		errCodeMap.put("mobileNo",PMSErrorCode.PLR_MOBILE_NO_NOT_PROVIDED);
		errCodeMap.put("rsaId",PMSErrorCode.PLR_RSA_ID_NOT_PROVIDED);
		errCodeMap.put("password",PMSErrorCode.PLR_PIN_NOT_PROVIDED);
		errCodeMap.put("isEmailService", PMSErrorCode.PLR_EMAIL_SERVICE_PARAMETER_REQUIRED);
		errCodeMap.put("isSmsService", PMSErrorCode.PLR_SMS_SERVICE_PARAMETER_REQUIRED);
		errCodeMap.put("otp", PMSErrorCode.OTP_NOT_PROVIDED);
		return errCodeMap;
	}
	
	public static Map<String,String> errMsg() {
		Map<String,String> errMsgMap = new HashMap<String,String>();
		errMsgMap.put("firstName",PMSErrorMessage.PLR_FIRST_NAME_NOT_PROVIDED);
		errMsgMap.put("lastName",PMSErrorMessage.PLR_LAST_NAME_NOT_PROVIDED);
		errMsgMap.put("mobileNo",PMSErrorMessage.PLR_MOBILE_NO_NOT_PROVIDED);
		errMsgMap.put("rsaId",PMSErrorMessage.PLR_RSA_ID_NOT_PROVIDED);
		errMsgMap.put("password",PMSErrorMessage.PLR_PIN_NOT_PROVIDED);
		errMsgMap.put("isEmailService", PMSErrorMessage.PLR_EMAIL_SERVICE_PARAMETER_REQUIRED);
		errMsgMap.put("isSmsService", PMSErrorMessage.PLR_SMS_SERVICE_PARAMETER_REQUIRED);
		errMsgMap.put("otp", PMSErrorMessage.OTP_NOT_PROVIDED);
		return errMsgMap;
	}
}