package com.stpl.pms.exception;

public interface PMSErrorMessage {
	//General Errors
	public static final String GEN_HIBERNATE_EXCEPTION = "Hibernate exception";
	public static final String GEN_SOME_INTERNAL_ERROR = "Some internal error";
	public static final String GEN_INVALID_REQ = "Invalid request";
	public static final String GEN_REQUEST_TIME_OUT = "Your request has been timed out.";
	public static final String GEN_INVALID_DATE_FORMAT = "Invalid date format.";
	public static final String GEN_INVALID_FILE_UPLOAD_REQUEST = "Invalid file upload request.Only multipart content allowed.";
	public static final String GEN_DEVICE_TYPE_EMPTY="Device type not supplied.";
	public static final String GEN_USER_AGENT_EMPTY="User agent type not supplied.";
	public static final String GEN_SQL_EXCEPTION ="SQL Exception.";
	public static final String GEN_NO_RECORD_FOUND = "No record found";
	public static final String GEN_OP_NOT_SUPPORTED= "Operation not supported";
	public static final String GEN_SYSTEM_SEND_SMS = "System send sms configuration is off";
	String GEN_REQ_DOC_EMPTY="Required Document field empty";
	String GEN_REQ_BANK_DETAIL_EMPTY="Required Bank details empty";
	
	//Txn Module Errors
	public static final String TXN_INVALID_REQ = "Invalid request";
	public static final String TXN_INVALID_SESSION = "Invalid session id";
	public static final String TXN_PLR_NOT_LOGIN = "Player not logged In";
	public static final String TXN_INVALID_SERVICE_CODE = "Invalid service code";
	public static final String TXN_INVALID_AMOUNT = "Invalid amount";
	public static final String TXN_INVALID_PLAYER = "Invalid player";
	public static final String TXN_UNAUTH_VENDOR = "Unauthentic vendor";
	public static final String TXN_INVALID_VENDOR_CREDIENTIALS = "Invalid vendor credientials";
	public static final String TXN_INSUFFICIENT_BALANCE = "Insufficient player balance";
	public static final String TXN_NOT_ALLOWED = "Your transaction has been temporary blocked";
	public static final String TXN_INCONSISTENT_USER_BAL = "Inconsistency in user balance.";
	public static final String TXN_INVALID_WALLET_TYPE = "Invalid wallet type.";
	public static final String TXN_INVALID_SUB_WALLET = "Invalid subwallet";
	public static final String TXN_INSUFFICIENT_BALANCE_TO_DEBIT = "Insufficient balance to debit player account.";
	public static final String TXN_INVALID_BALANCE_TYPE = "Invalid balance type.";
	public static final String TXN_DUPLICATE_TXN = "Duplicate transaction";
	public static final String TXN_WDRL_ALREADY_CANCELLED = "Withdrawal has been already cancelled.";
	public static final String TXN_WDRL_ALREADY_INITIATED = "Withdrawal can't be cancelled,already processed";
	public static final String TXN_INSUFFICIENT_TICKET_BALANCE = "Insufficient tickets.";
	public static final String TXN_INVALID_MAC_ADDRESS = "No Device found Mapped with the Given Mac Address";
	public static final String TXN_INVALID_ID = "Invalid Transaction Id";
	public static final String TXN_ALREADY_PROCESSED = "This transaction has already been processed";

	String TXN_WINNING_PREFERENCE_ERROR = "Something went wrong while fetching winning preference";
	 String TP_TXN_NO_NOT_AVAIL = "Tp txn no not provided";
	//Cashier Deposit 
	public static final String CSH_INVALID_REQ_DATA = "Invalid request data";
	public static final String CSH_OLA_INVALID_PLR_USERNAME = "Invalid player username";

	public static final String CSH_SETTLEMENT_INVALID_PROVIDER = "Invalid provider to upload settlement report.";
	public static final String CSH_SETTLEMENT_INVALID_HEADER_SEQUENCE = "Invalid sequence of report headers in file." ;
	public static final String CSH_SETTLEMENT_INVALID_FILE_FORMAT = "Invalid file format.Only .xls and .xlsx formats allowed.";
	public static final String CSH_SETTLEMENT_FILE = "Invalid file.";
	public static final String CSH_SETTLEMENT_INVALID_FILE_FORMAT_CSV = "Invalid file format.Only .csv formats allowed.";
	
	public static final String CSH_SETTLEMENT_DUPLICATE_ENTRY = "Some request already exist";
	public static final String CSH_NO_OPTION_AVAILABLE = "No payment options available.";
	public static final String CSH_DUPLICATE_REDEEM_ACCOUNT = "Account has been already created with this account no.";
	public static final String CSH_PAYMENT_FAILURE = "Your payment has been failed.Please try again.";
	public static final String CSH_PROMO_CODE_NOT_APPLICABLE = "Promo code is not applicable for this request.";
	public static final String CSH_INVALID_PROMO_CODE = "Invalid Promo Code.";
	public static final String CSH_VERIFICATION_CODE_EXPIRE = "Verification Code Expired";
	public static final String PG_CHECKSUM_INVALID = "CheckSum Mismatch";
	String INVALID_CURRENCY_CODE="Invalid Currency Code";
	String PMT_CODE_NOT_EXIST = "Payment Type Code Don't exist";
	String CSH_REDEEM_ACCOUNT_NOT_EXIST = "Redeem Account Not Exist";
	
	//Player management
	public static final String LOGIN_NOT_ALLOWED_FOR_DOMAIN ="Login not allowed for this domain";
	public static final String WRONG_USERNAME = "Wrong Username";
	public static final String CHNG_PWD_BEFORE_LOGIN = "Please Change Password Before Login";
	public static final String WRONG_PASSWORD =  "Wrong Password";
	public static final String INVALID_USER = "User Is Not Valid !";
	public static final String INVALID_USER_PWD = "Either username or password is invalid";
	public static final String INVALID_LOGIN_BLOCK = "Login Try Limit Reached";
	public static final String INVALID_LOGIN_BLOCK_SEND_MAIL = "Too Many Invalid Login Try!! Please go to your mail for Re-Activate your account. ";
	public static final String WRONG_OLD_PASS = "Old Password Incorrect";
	public static final String OLD_NEW_PASS_SAME = "Current and New Password can not be same.";
	public static final String PASS_FOUND_IN_HISTORY = "New Password Can't be From Last Password's";
	public static final String VERIFICATION_PENDING = "Your verification is pending as you have requested to change your Mobile No/Email Id.Please enter the verification code.";
	public static final String DUPLICATE_INFO = "Player already exist with same info.Please provide valid detail to our support team.";
	public static final String LOGIN_COMMON_ERROR = "Some Problem in Login!! Contact Support Team.";
	public static final String INVALID_VERIFICATION_CODE = "Invalid verification code";
	public static final String INVALID_PLAYER_ID = "INVALID PLAYER ID";
	public static final String PLR_COMM_NOT_POSSIBLE = "No proper communication ID avalable for the user.";
	public static final String INVALID_REFERAL_CODE="Invalid referral code";
	
	
	//Player Mgmt
	public static final String PLR_USER_NAME_EXIST = "User name already exist.";
	public static final String PLR_EMAIL_EXIST = "E-mail ID already exist.";
	public static final String PLR_MOBILE_NO_EXIST = "Mobile no already exist.";
	public static final String PLR_NOT_EXIST_FOR_DOMAIN = "Player not exist for selected domain.";
	public static final String PLR_EXIST_WITH_SAME_INFO = "Player already exist with same information.";
	public static final String PLR_INCOMPLETE_INFO = "Imcomplete player info";
	public static final String BO_LIMIT_REPORT_DATA = "Too much data. Please select more filters";
	public static final String PLR_NOT_EXIST = "Player info not found.";
	public static final String MULTIPLE_OR_NO_PLR_EXIST = "Multiple or no player exist.";
	public static final String MESSAGE_ALREADY_DELETED = "Message has been deleted.";
	public static final String PLR_EMAIL_MOBILE_EXIST = "Email Id and Mobile Number already exist.";
	public static final String PLR_USER_NAME_MOBILE_EXIST = "Username and Mobile Number already exist.";
	public static final String PLR_USER_NAME_EMAIL_EXIST = "Username and Email id already exist.";
	public static final String PLR_USER_NAME_EMAIL_MOBILE_EXIST = "Username ,Email id and mobile number already exist.";
	public static final String PLR_STATUS_INACTIVE = "Player status is inactive.";
	public static final String PLR_UPDATE_MOBILE_VERIFIED ="Phone number can not be update because phone number already verified.";
	public static final String PLR_UPDATE_EMAIL_VERIFIED ="Email can not be update because email already verified.";
	public static final String PLR_FIRST_NAME_NOT_PROVIDED = "First Name is not provided."; 
	public static final String PLR_LAST_NAME_NOT_PROVIDED = "Last Name is not provided.";
	public static final String PLR_MOBILE_NO_NOT_PROVIDED = "Mobile number is not provided.";
	public static final String PLR_RSA_ID_NOT_PROVIDED = "RSA ID is not provided.";
	public static final String PLR_PIN_NOT_PROVIDED = "PIN is not provided.";
	public static final String PLR_RSA_ID_NOT_VALID = "RSA Id is not valid.";
	public static final String PLR_EMAIL_SERVICE_PARAMETER_REQUIRED = "Email service parameter not provided.";
	String CONFIRM_NEW_PASS_NOT_SAME = "New and Confirm password are not same";
	String SOME_INPUT_MISSING = "Required parameter are missing";
	String PLR_SMS_SERVICE_PARAMETER_REQUIRED = "SMS service parameter not provided.";
	String PLAYER_UNDER_AGE = "Invalid age - must be at least 18 years";
	String PLR_RSA_ID_EXIST = "RSA Id already exist.";
	String VERIFICATION_CODE_EXPIRED = "OTP Code has been expired.";
	String VERIFICATION_CODE_NOT_VALID = "OTP Code is not valid.";
	String VERIFICATION_CODE_NOT_GENERATED = "verification code not generated.";
    String OTP_NOT_PROVIDED="otp is not provided";
    String PLAYER_ID_NOT_PROVIDED = "Player Id not provided.";
    String PLR_RSA_ID_NOT_EXIST = "RSA Id for particular player not exists";
    String LOGIN_TYPE_NOT_PROVIDED = "Login type (PRE or POST) not provided.";
    String PLR_RED_ACC_NOT_EXIST="Redeem Acc doesn't exist for this player";
	
	//for third party service
	public static final String API_INVALID_DOMAIN = "Invalid domain";
	public static final String API_UNAUTH_SERVICE_USER = "Unauthentic service user";
	public static final String API_INVALID_REQUEST_METHOD = "Invalid request method.";
	public static final String API_PLAYER_ALREADY_BIND = "Player already bound with an affiliate system.";
	public static final String API_INVALID_ALIAS_NAME = "Invalid Alias Name";
	public static final String GEN_INVALID_PARAM_VALUE ="Invalid Request parameter(s).";
	public static final String API_CAMPAIGN_EXPIRED="Campaign expired or not found.";
	public static final String API_INVALID_PASSWORD= "Invalid password! Please try again!";
	public static final String API_INVALID_VERSION = "Invalid Version";
	public static final String API_NO_PLAYER_FOUND = "No Player found from supplied information";
	public static final String API_MOBILE_NO_NOT_FOUND = "Mobile Number Not Found";
	
	// For BetGamesTv
	public static final String API_NO_BET_PAY_IN = "No bet pay-in exist.";
	public static final String API_INVALID_TOKEN = "Invalid token.";
	public static final String API_TOKEN_EXPIRED = "Token expired.";
	public static final String API_SIGNATURE_MISMATCH = "Signature mismatched";
	
	
	//player eligibility criteria error message
	public static final String DOMAIN_NOT_VAILD = "Domain Name Not Vaild";
	public static final String PLAYER_NOT_VAILD = "Player Not Found";
	public static final String CRITERIA_NOT_FOUND = "Criteria Can't be Empty";
	
	//Third Party Poker integration Transaction Error message
	public static final String POKER_TOKEN_IS_INVALID="The player token is invalid.";
	public static final String POKER_TOKEN_IS_EXPIRE="The player token has expired.";
	public static final String POKER_VENDOR_AUTH_ERROR="The authentication credentials for the API are incorrect.";
	public static final String POKER_PLR_LOGIN_ERROR="The player's login credentials are incorrect.";
	public static final String POKER_PLR_ACC_LOCK="The player's account is locked.";
	public static final String POKER_PLR_CRE_ERROR="The account does not exist.";
	public static final String POKER_PLR_ACC_DEACT="The player is deactivated.";
	public static final String POKER_PLR_TXN_PROC="This transaction has already been processed";
	public static final String POKER_PLR_TXN_DUPL="A transaction with the same ID has already been processed";
	public static final String POKER_PLR_INSUFFICIENT_BAL="The player does not have enough funds to complete the Change Balance transaction.";
	public static final String POKER_PLR_EXCEED_BET_LIMIT="The player has exceeded one of their betting limits.";
	public static final String POKER_PLR_EXCEED_WEEK_LIMIT="The player has exceeded their weekly limit.";
	public static final String POKER_PLR_EXCEED_MONTH_LIMIT="The player has exceeded their monthly limit.";
	public static final String POKER_PLR_EXCEED_TIME_LIMIT="The player has exceeded their time limit.";
	public static final String POKER_PLR_EXCEED_LOSS_LIMIT="The player has exceeded their loss limit.";
	public static final String POKER_TXN_ERROR="The transaction failed with a general error, and should not be retried.";
 
	
	//AWS related Exceptions
    String AWS_SERVICE_UNSUPPORTED="AWS Service not supported!";

    //TPWallet related Exceptions
    String TP_WALLET_FAILED="Third Party wallet failure!";
    
    //JMS Error message
    String JMS_QUEUE_DOWN = "JMS queue is down";
    String JMS_CONFIG_MISSING = "JMS config missing. Please check JMS property file";
    String JMS_CONFIG_INVALID ="JMS config is invalid. Please check JMS property file";
    String UNSUPPORTED_JMS_MESSAGE = "JMS message type not supported";
    
    String PLR_RSA_MOBILE_EXIST = "RsaId and mobileNo exist";
 	String PLR_RSA_EMAIL_EXIST = "RsaId and emailId exist";
 	String PLR_RSA_EMAIL_MOBILE_EXIST = "RsaId, mobileNo and emailId exist";
 	
 	// ContactUs API parameters
 	String CONTACT_USER_NAME_NOT_PROVIDED = "User name is not provided.";
 	String CONTACT_EMAIL_ID_NOT_PROVIDED = "Email id not provided or not valid.";
}