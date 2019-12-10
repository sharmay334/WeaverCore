/**
 * General Error codes : Prefix:- GEN_  
 * 						 Code Starts From:- 101
 * 
 *  Txn Error Codes :	Prefix:- TXN_  
 * 						Code Starts From:- 201	
 * 	Cashier Error Codes :	Prefix:- CSH_  
 * 						Code Starts From:- 301
 * 
 * Loyalty program Codes : Reserved error space 7000 - 7999 	
 * 
 */



package com.stpl.pms.exception;


public interface PMSErrorCode {
	//General Errors
	public static final int GEN_HIBERNATE_EXCEPTION = 101;
	public static final int GEN_SOME_INTERNAL_ERROR = 102;
	public static final int GEN_INVALID_REQ = 103;
	public static final int GEN_REQUEST_TIME_OUT = 104;
	public static final int GEN_INVALID_DATE_FORMAT = 105;
	public static final int GEN_INVALID_FILE_UPLOAD_REQUEST = 106;
	public static final int GEN_DEVICE_TYPE_EMPTY=107;
	public static final int GEN_USER_AGENT_EMPTY=108;
	public static final int GEN_SQL_EXCEPTION = 109;
	public static final int GEN_INVALID_PARAM_VALUE = 110;
	public static final int GEN_NO_RECORD_FOUND = 111;
	public static final int GEN_OP_NOT_SUPPORTED = 112;
	public static final int GEN_SYSTEM_SEND_SMS = 113;
    int JMS_QUEUE_DOWN = 114;
    int JMS_CONFIG_MISSING =115;
    int JMS_CONFIG_INVALID =116;
    int UNSUPPORTED_JMS_MESSAGE = 117;
    int GEN_REQ_DOC_EMPTY=118;
    int GEN_REQ_BANK_DETAIL_EMPTY=119;
    		
	//Txn Module Errors
	public static final int TXN_INVALID_REQ = 201;
	public static final int TXN_INVALID_SESSION = 202;
	public static final int TXN_PLR_NOT_LOGIN = 203;
	public static final int TXN_INVALID_SERVICE_CODE = 204;
	public static final int TXN_INVALID_AMOUNT = 205;
	public static final int TXN_INVALID_PLAYER = 206;
	public static final int TXN_UNAUTH_VENDOR = 207;
	public static final int TXN_INVALID_VENDOR_CREDIENTIALS = 208;
	public static final int TXN_INSUFFICIENT_BALANCE = 209;
	public static final int TXN_NOT_ALLOWED = 210;
	public static final int TXN_INCONSISTENT_USER_BAL = 211;
	public static final int TXN_INVALID_WALLET_TYPE = 212;
	public static final int TXN_INVALID_SUB_WALLET = 213;
	public static final int TXN_INVALID_BALANCE_TYPE = 214;
	public static final int TXN_INSUFFICIENT_BALANCE_TO_DEBIT = 215;
	public static final int TXN_DUPLICATE_TXN = 216;
	public static final int TXN_WDRL_ALREADY_CANCELLED = 217;
	public static final int TXN_WDRL_ALREADY_INITIATED = 218;
	public static final int TXN_INSUFFICIENT_TICKET_BALANCE = 219;
	public static final int TXN_INVALID_MAC_ADDRESS = 220;
	public static final int TXN_INVALID_ID = 221;
	public static final int TXN_ALREADY_PROCESSED = 222;
	int TXN_WINNING_PREFERENCE_ERROR = 223;
	int TP_TXN_NO_NOT_AVAIL = 224;

	//Cashier Deposit 
	public static final int CSH_INVALID_REQ_DATA = 301;
	public static final int CSH_OLA_INVALID_PLR_USERNAME = 302;
	public static final int CSH_SETTLEMENT_INVALID_PROVIDER = 303;
	public static final int CSH_SETTLEMENT_INVALID_HEADER_SEQUENCE = 304;
	public static final int CSH_SETTLEMENT_INVALID_FILE_FORMAT = 305;
	public static final int CSH_SETTLEMENT_DUPLICATE_ENTRY = 306;
	public static final int CSH_DUPLICATE_REDEEM_ACCOUNT =307;
	public static final int CSH_NO_OPTION_AVAILABLE =308;
	public static final int CSH_PAYMENT_FAILURE = 309;
	public static final int CSH_PROMO_CODE_NOT_APPLICABLE = 310;
	public static final int CSH_INVALID_PROMO_CODE = 311;
	public static final int CSH_SETTLEMENT_FILE = 312;
	public static final int CSH_SETTLEMENT_INVALID_FILE_FORMATCSV=313;
	public static final int CSH_VERIFICATION_CODE_EXPIRE = 314;
	public static final int PG_CHECKSUM_INVALID = 315;
	int INVALID_CURRENCY_CODE=316;
	int PMT_CODE_NOT_EXIST = 317;
	int CSH_REDEEM_ACCOUNT_NOT_EXIST = 318;
	//player management
	public static final int LOGIN_NOT_ALLOWED_FOR_DOMAIN = 401;
	public static final int WRONG_USERNAME = 402;
	public static final int CHNG_PWD_BEFORE_LOGIN = 403;
	public static final int WRONG_PASSWORD = 404;
	public static final int INVALID_USER = 405;
	public static final int INVALID_USER_PWD = 406;
	public static final int INVALID_LOGIN_BLOCK = 407;
	public static final int WRONG_OLD_PASS = 408;
	public static final int OLD_NEW_PASS_SAME = 409;
	public static final int PASS_FOUND_IN_HISTORY = 410;
	public static final int INVALID_LOGIN_BLOCK_SEND_MAIL = 411;
	public static final int VERIFICATION_PENDING = 412;
	public static final int DUPLICATE_PLAYER = 413;
	public static final int DUPLICATE_INFO = 414;
	public static final int MESSAGE_ALREADY_DELETED =415;
	public static final int LOGIN_COMMON_ERROR = 416;
	public static final int NO_MESSAGE_FOUND =417;
	public static final int INVALID_VERIFICATION_CODE =418;
	public static final int VERIFICATION_CODE_ALREADY_USED =419;
	public static final int INVALID_PLAYER_ID=420;
	public static final int PLR_COMM_NOT_POSSIBLE=421;
	public static final int INVALID_REFERAL_CODE=422;
	int PLR_RED_ACC_NOT_EXIST=423;
	
	
	//Player Mgmt
	public static final int PLR_USER_NAME_EXIST = 501;
	public static final int PLR_EMAIL_EXIST = 502;
	public static final int PLR_MOBILE_NO_EXIST = 503;
	public static final int PLR_NOT_EXIST_FOR_DOMAIN = 504;
	public static final int PLR_EXIST_WITH_SAME_INFO = 505;
	public static final int PLR_INCOMPLETE_INFO = 506;
	public static final int BO_LIMIT_REPORT_DATA=507;
	public static final int PLR_NOT_EXIST =508;
	public static final int MULTIPLE_OR_NO_PLR_EXIST = 509;
	public static final int PLR_EMAIL_MOBILE_EXIST = 510;
	public static final int PLR_USER_NAME_MOBILE_EXIST = 511;
	public static final int PLR_USER_NAME_EMAIL_EXIST = 512;
	public static final int PLR_USER_NAME_EMAIL_MOBILE_EXIST = 513;
	public static final int PLR_STATUS_INACTIVE = 514;
	public static final int PLR_UPDATE_MOBILE_VERIFIED = 515;
	public static final int PLR_UPDATE_EMAIL_VERIFIED = 516;
	public static final int PLR_FIRST_NAME_NOT_PROVIDED = 517;
	public static final int PLR_LAST_NAME_NOT_PROVIDED = 518;
	public static final int PLR_MOBILE_NO_NOT_PROVIDED = 519;
	public static final int PLR_RSA_ID_NOT_PROVIDED = 520;
	public static final int PLR_PIN_NOT_PROVIDED = 521;
	public static final int PLR_RSA_ID_NOT_VALID = 522;
	public static final int PLR_EMAIL_SERVICE_PARAMETER_REQUIRED = 523;
	public static final int PLR_SMS_SERVICE_PARAMETER_REQUIRED = 524;
	int CONFIRM_NEW_PASS_NOT_SAME = 525;
	int SOME_INPUT_MISSING = 526;
	int PLAYER_UNDER_AGE = 527;
	int PLR_RSA_ID_EXIST = 528; 
	int VERIFICATION_CODE_EXPIRED = 529;
	int VERIFICATION_CODE_NOT_VALID = 530;
	int VERIFICATION_CODE_NOT_GENERATED = 531;
	int OTP_NOT_PROVIDED = 532;
	int PLR_RSA_ID_NOT_EXIST = 533;

	//for third party service
	public static final int API_INVALID_DOMAIN = 601;
	public static final int API_UNAUTH_SERVICE_USER = 602;
	public static final int API_INVALID_REQUEST_METHOD = 603;
	public static final int API_PLAYER_ALREADY_BIND = 604;
	public static final int API_SERVICE_UNAVAILABLE = 605;
	public static final int API_INVALID_ALIAS_NAME = 606;
	public static final int API_CAMPAIGN_EXPIRED=608;
	public static final int API_INVALID_PASSWORD=609;
	public static final int API_INVALID_VERSION=610;
	public static final int API_NO_PLAYER_FOUND=611;
	public static final int API_MOBILE_NO_NOT_FOUND=615;
	//for BetGamesTV
	public static final int API_NO_BET_PAY_IN = 700;
	public static final int API_INVALID_TOKEN = 701;
	public static final int API_TOKEN_EXPIRED = 702;
	public static final int API_SIGNATURE_MISMATCH = 703;
	
	
	
	//BetSoftGames Error codes given by betsoft games
	public static final int BSG_INTERNAL_ERROR = 399;
	public static final int BSG_INVALID_TOKEN = 400;
	public static final int BSG_INVALID_HASH = 500;
	public static final int BSG_UNKNOWN_USER_ID = 310;
	public static final int BSG_INSUFFICIENT_FUNDS = 300;
	public static final int BSG_OPERATION_FAILED = 301;
	
	
	//player eligibility criteria error code
	public static final int DOMAIN_NOT_VAILD = 801;
	public static final int PLAYER_NOT_VAILD = 802;
	public static final int CRITERIA_NOT_FOUND = 803;
//	public static final int BSG_UNKNOWN_USER_ID = 310;
//	public static final int BSG_INSUFFICIENT_FUNDS = 300;
//	public static final int BSG_OPERATION_FAILED = 301;
	
	//Third Party Poker integration Transaction Error code
	public static final int POKER_TOKEN_IS_INVALID=6001;
	public static final int POKER_TOKEN_IS_EXPIRE=6002;
	public static final int POKER_VENDOR_AUTH_ERROR=6003;
	public static final int POKER_PLR_LOGIN_ERROR=6101;
	public static final int POKER_PLR_ACC_LOCK=6102;
	public static final int POKER_PLR_CRE_ERROR=6103;
	public static final int POKER_PLR_ACC_DEACT=6112;
	public static final int POKER_PLR_TXN_PROC=6500;
	public static final int POKER_PLR_TXN_DUPL=6501;
	public static final int POKER_PLR_INSUFFICIENT_BAL=6503;
	public static final int POKER_PLR_EXCEED_BET_LIMIT=6505;
	public static final int POKER_PLR_EXCEED_WEEK_LIMIT=6506;
	public static final int POKER_PLR_EXCEED_MONTH_LIMIT=6507;
	public static final int POKER_PLR_EXCEED_TIME_LIMIT=6508;
	public static final int POKER_PLR_EXCEED_LOSS_LIMIT=6509;
	public static final int POKER_TXN_ERROR=6010;
	public static final int UNKNOWN_VENDOR_ALIAS_MAPPING=6011;
	 
	
	

	//AWS related execptions
    int AWS_SERVICE_UNSUPPORTED=900;

    //TPWallet related Exceptions
    int TP_WALLET_FAILED=950;
    
	// Player Management Error Code
	int PLR_RSA_MOBILE_EXIST = 534;
	int PLR_RSA_EMAIL_EXIST = 535;
	int PLR_RSA_EMAIL_MOBILE_EXIST = 536;
	int PLAYER_ID_NOT_PROVIDED = 537;
	int LOGIN_TYPE_NOT_PROVIDED = 538;
	
	// ContactUs API parameters
	int CONTACT_USER_NAME_NOT_PROVIDED = 540;
	int CONTACT_EMAIL_ID_NOT_PROVIDED = 541;
}
