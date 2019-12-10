/*
 * � copyright 2007, SkilRock Technologies, A Sugal & Damani Company.
 * All Rights Reserved
 * The contents of this file are the property of Sugal & Damani Lottery Agency Pvt. Ltd.
 * and are subject to a License agreement with Sugal & Damani Lottery Agency Pvt. Ltd.; you may
 * not use this file except in compliance with that License.  You may obtain a
 * copy of that license from:
 * Legal Department
 * Sugal & Damani Lottery Agency Pvt. Ltd.
 * 6/35,WEA, Karol Bagh,
 * New Delhi
 * India - 110005
 * This software is distributed under the License and is provided on an �AS IS�
 * basis, without warranty of any kind, either express or implied, unless
 * otherwise provided in the License.  See the License for governing rights and
 * limitations under the License.
 */

package com.stpl.pms.utility;

public class ConfigurationVariables {

	public final static String NAMING_PROVIDER_URL = "jnp://192.168.123.21:1099";

	public final static String PERSISTENCE_TYPE = "HIBERNATE";
	public final static String JNDI_PLAYER_MASTER = "jndiPlayerMaster";
	public final static String JNDI_PLAYER_INFO = "jndiPlayerInfo";
	public final static String JNDI_PLAYER_RESPON_GAMING = "jndiPlayerResponGaming";
	public final static String JNDI_TRX_MASTER = "TrxImpl";
	public final static String JNDI_DEPOSITE = "TrxDeposite";
	public final static String JNDI_WITHDRAWL = "TrxWithdrawl";
	public final static String JNDI_TRX_MESSAGES = "jndiPlayerMessages";
	public final static String JNDI_REDEEM_ACCOUNT = "jndiRedeemAccount";
	public final static String JNDI_PLAYER_REMOTE = "PlayerRegistrationRemote";
	public final static String JNDI_GAME_MASTER = "jndiGameMaster";
	public final static String JNDI_TICKET_ARCHIVE_TRY = "localIgTicketArchiveTry";
	public final static String JNDI_TICKET_ARCHIVE = "localIgTicketArchive";
	public final static String JNDI_TRANSACTION_TICKETS = "localIgTransactionTickets";
	public final static String JNDI_TRANSACTION_TICKETS_ARCHIVE = "localIgTransactionTicketsArchive";
	public final static String JNDI_KEYS = "localJndiIgKeys";
	public final static String JNDI_PURCHASE_MASTER = "localIgsPurchaseMaster";
	public final static String JNDI_COUNTRY_MASTER = "igsCountryMasterJndi";
	public final static String JNDI_STATE_MASTER = "igsStateMasterJndi";
	public final static String JNDI_REDEEM_CHN_REQ = "redeemAccChngReq";

	public final static String RG_PERSISTENCE_TYPE = "HIBERNATE";
	public final static String PURCHASE_IGE_TX = "PURCHASE_IGE";
	public final static String PURCHASE_SGE_TX = "PURCHASE_SGE";
	public final static String PURCHASE_DGE_TX = "PURCHASE_DGE";
	
	public final static String PURCHASE_BGE_TX = "PURCHASE_BGE";
	public final static String CANCEL_BGE_TX = "CANCEL_BGE";
	public final static String WINNING_BGE_TX = "WINNING_BGE";
	public final static String WINNING_BGE_TX_STATUS_PENDING = "PENDING";
	public final static String WINNING_BGE_TX_STATUS_APPROVED ="APPROVED";
	public final static String BGE_WIN_APPROVAL_PENDING = "PENDING";
	public final static String BGE_WIN_APPROVAL_APPROVED = "APPROVED";
	public final static String BGE_WIN_APPROVAL_REJECTED = "REJECTED";
	
	public final static String WINNING_SGE_TX = "WINING_SGE";
	public final static String WINNING_IGE_TX = "WIN_IGE";
	
	public final static String WINNING_SGE_TX_STATUS_PENDING = "PENDING";
	public final static String WINNING_SGE_TX_STATUS_APPROVED ="APPROVED";
	public final static String WINNING_IGE_TX_STATUS_PENDING = "PENDING";
	public final static String WINNING_IGE_TX_STATUS_APPROVED ="APPROVED";

	public final static String PURCHASED_FROM = "directly";
	public final static Character IS_FINISH_NO = 'N';
	public final static Character IS_FINISH_YES = 'Y';
	public final static Character IS_FINISH_INTERMEDIATE = 'I';
	// public final static String IS_MOBILE_PURCHASE_STATUS_NO = "N";
	public final static Character IS_MOBILE_PURCHASE_STATUS_NO = 'N';
	// public final static String IS_MOBILE_PURCHASE_STATUS_YES = "Y";
	public final static Character IS_MOBILE_PURCHASE_STATUS_YES = 'Y';
	public final static String BOOK_STATUS_YOT = "YOT";
	public final static String BOOK_STATUS_OPEN = "OPEN";
	public final static String IS_SOLD_Y = "Y";
	public final static String IS_SOLD_N = "N";

	// some confuurable figurs
	public final static Double OPERATOR_LIMIT = 1000.0;
	public final static Double MIN_WITHDRAWAL_AMT = 500.0;
	public final static Double MIN_DEPOSIT_AMT = 500.0;

	public final static int MAX_OPEN_BOOKS = 10;
	public final static int NO_OF_BOOKS_TO_OPEN = 1;

	public final static Double PLAYER_INITIAL_BAL = 0.0;
	public final static Double AFFILIATE_INITIAL_BAL = 0.0;

	// player login status
	public final static String PLAYER_LOGIN_ACTIVE = "ACTIVE";
	public final static String AFFILIATE_LOGIN_PENDING = "PENDING";
	public final static String AFFILIATE_LOGIN_REJECTED = "REJECTED";
	public final static String PLAYER_LOGIN_INACTIVE = "INACTIVE";
	public final static String PLAYER_LOGIN_TERMINATED = "TERMINATE";
	// public final static Character AUTO_PASSWORD_YES = 'Y';
	public final static String AUTO_PASSWORD_YES = "Y";
	public final static String AUTO_PASSWORD_NO = "N";

	// REDEEM ACCOUNT STATUS
	public final static String REDEEM_ACNT_ACTIVE = "ACTIVE";
	public final static String REDEEM_ACNT_FREEZE = "FREEZE";
	public final static String REDEEM_ACNT_CHNG_REQUEST = "REQUESTED";
	public final static String REDEEM_ACNT_CHNG_PENDING = "PENDING";
	public final static String REDEEM_ACNT_NEW = "NEW";
	public final static String REDEEM_UPDATE_PENDING_WITH = "WITHDRAWAL_PENDING";
	public final static String REDEEM_UPDATE_PENDING_REQ = "REQUEST_PENDING";

	// PAYMENT RELATED STATUS
	public final static String DEPOSIT_TX_TYPE = "DEPOSIT";
	public final static String WITHDRAWAL_TX_TYPE = "WITHDRAW";
	public final static String WITHDRAWAL_STATUS_PROCESSED = "PROCESSED";
	public final static String WITHDRAWAL_STATUS_PENDING = "PENDING";
	public final static String WITHDRAWAL_STATUS_INITIATED= "INITIATED";
	public final static String WITHDRAWAL_STATUS_CANCEL_BY_PLAYER = "CANCEL BY PLAYER";
	public final static String TRANSACTION_WITH = "PLAYER";
	public final static String TRANSACTION_CONFIRM = "CONFIRM";
	public final static String WITHDRAWAL_MODE_BO = "BACKOFFICE";
	public final static String WITHDRAWAL_MODE_AUTOMATED_REFUND = "AUTOMATED_REFUND";
	public final static String WITHDRAWAL_MODE_AUTOMATED_PLAYER = "AUTOMATED_PLAYER";
	public final static String WITHDRAWAL_ONLINE = "ONLINE";
	public final static String WITHDRAWAL_OFFLINE = "OFFLINE";

	// GAMING STATUS
	public final static String GAME_STATUS_ACTIVE = "ACTIVE";
	public final static String GAME_STATUS_INACTIVE = "INACTIVE";
	public final static String GAME_STATUS_TERMINATE = "TERMINATE";
	public final static String GAME_INVETORY_STATUS_YOT = "YOT";
	public final static String GAME_INVETORY_STATUS_FINISHED = "FINISHED";
	public final static String GAME_INVETORY_STATUS_ATF = "ATF";
	public final static String GAME_STATUS_SALE_HOLD = "SALE_HOLD";
	public final static String TICKET_FIXED_SET_TYPE = "FIXED_SET";
	public final static String TICKET_PROB_SET_TYPE = "PROBABILISTIC";

	// Freeze STATUS
	public final static String PLAYER_FREEZE_STATUS_ACTIVE = "ACTIVE";
	public final static String PLAYER_FREEZE_STATUS_INACTIVE = "INACTIVE";

	/*
	 * CONSTANTS REGARDING PAYMENT GATEWAY MODULE.
	 */

	public final static String IGS_PLAYER = "IGS_PLAYER";

	public final static Integer PLAYER_VALID_AGE = 16;
	public final static Integer VALID_YEAR = 1993;

	/*
	 * Game Type in igs game mster table.
	 */

	public final static String INSTANT_GAME = "INSTANT GAME";
	public final static String SKILL_GAME = "SKILL GAME";
	public final static String SCRATCH_GAME = "SCRATCH GAME";

	// inbox message constant
	public final static String INBOX_MSG_READ = "READ";
	public final static String INBOX_MSG_UNREAD = "UNREAD";
	public final static String INBOX_MSG_DELETED = "DELETED";

	// gamefinish constants
	public final static String GAME_FINISH_TX_STATUS_WIN = "WINNING_IGE";
	public final static String IGS_CURRENCY_SIGN = "£";

	/*
	 * 
	 * Age Verification related constants
	 */
	public final static String AGE_VERIFICATION_STATUS_NOT_INITIATED = "NOT_INITIATED";

	public final static String AGE_VERIFICATION_STATUS_PENDING = "PENDING";
	public final static String AGE_VERIFICATION_STATUS_VERIFIED = "VERIFIED";
	public final static String AGE_VERIFICATION_STATUS_DUPLICATE = "DUPLICATE";
	public final static String AGE_VERIFICATION_STATUS_REJECTED = "REJECTED";
	public final static String AGE_VERIFICATION_STATUS_MINOR = "UNDER_AGE";
	public final static String AGE_VERIFICATION_STATUS_SELF_EXCLUDED = "SELF_EXCLUDED";
	public final static String AGE_VERIFICATION_MATCH_TYPE_NotAvailable = "NotAvailable";
	public final static String AGE_VERIFICATION_MATCH_TYPE_Match = "Match";
	public final static String AGE_VERIFICATION_MATCH_TYPE_NotVerified = "NotVerified";
	public final static String AGE_VERIFICATION_MATCH_TYPE_VERIFIED = "Verified";

	public final static String AGE_VERIFICATION_CC_STATUS_PENDING = "CC_PENDING";
	public final static String AGE_VERIFICATION_CC_STATUS_OK_ON_SAMPLE = "OK_ON_S";
	public final static String AGE_VERIFICATION_PAYMENT_MODE_CC = "CC";
	public final static int NO_OF_HOURS = 66;
	public final static String AGE_VERIFICATION_MODE_ONLINE = "ONLINE";
	public final static String AGE_VERIFICATION_MODE_OFFLINE = "OFFLINE";
	public final static String AGE_VERIFICATION_LOG_NOT_AVAILABLE = "NOT_AVAILABLE";
	public final static String AGE_VERIFICATION_LOG_NOT_VERIFIED = "NOT_VERIFIED";
	public final static String AGE_VERIFICATION_MODE_SAMPLE = "SAMPLE";

	/*
	 * merchant service provider status
	 */
	public final static String SERVICE_PROVIDER_STATUS_ACTIVE = "ACTIVE";
	public final static String SERVICE_PROVIDER_STATUS_INACTIVE = "INACTIVE";
    public final static String REDEEM_ACC_MASTER_FREEZE= "FREEZE"; 
	/*
	 * charity
	 */
	public final static String CHARITY_STATUS_ACTIVE = "ACTIVE";
	public final static String CHARITY_STATUS_INACTIVE = "INACTIVE";
	public static final String PLR_TX_TYPE_WIN = "WINNING";
	public static final String PLR_TX_TYPE_TX_CANCEL = "TX_CANCEL";
	public static final String PLR_TX_TYPE_WITHDRAW = "WITHDRAW";
	public static final String PLR_TX_TYPE_DEPOSIT = "DEPOSIT";
	public static final String PLR_TX_TYPE_PROMO = "BONUS";
	public static final String PLR_TX_TYPE_PURCHASE = "PURCHASE";
	/*
	 * winning approval status
	 */
	public final static String SGE_WIN_APPROVAL_PENDING = "PENDING";
	
	public final static String IGE_WIN_APPROVAL_PENDING = "PENDING";
	public final static String IGE_WIN_APPROVAL_APPROVED = "APPROVED";
	public final static String IGE_WIN_APPROVAL_REJECTED = "REJECTED";

	public final static String TRANSFER_TO_SUBWALLET = "TRANSFER_TO_SUBWALLET";
	public final static String TRANSFER_FROM_SUBWALLET = "TRANSFER_FROM_SUBWALLET";
	public final static String TRANSFER_TO_SUBWALLET_CANCEL = "TRANSFER_TO_SUBWALLET_CANCEL";
	public final static String TRANSFER_FROM_SUBWALLET_CANCEL = "TRANSFER_FROM_SUBWALLET_CANCEL";
}
