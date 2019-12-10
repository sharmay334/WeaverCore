package com.stpl.pms.action.bo.reports;

public enum ReporProcFromSlave {
	MisPlayerReport, MisDepositAndWithdrawal, MisPlayerBonus, MisPlayerBalance, MisBusinessSummary, MisWagerAndWinning, MisMixReport, 
	MisPlayerBalanceDayWise, MisDailyPlayReport, MisPlrLoginReport, MisPartialPlayerReport,PlayerRegIpCountReport,indiaBetPlayerReport, indiaBetPlayerWagerReport, 
	zapakPlayerReport, zapakPlayerDepositReport, getRummyWagerHourWise, getRummyWagerDayWise, getTotalRegDayWise, getTotalDepAmtDayWise,
	getTotalWithDrawDayWise, getTotalRummyWagerDayWise, getTotalDepRequestStatus, getTotalBonusDayWise, MisRegsitrationReport,
	getPlayerTransactionReports,getDepositDetailPG,getWithdrawalDetailPG,getDepositDetailPT,getWithdrawalDetailPT,getPlayerDepositReport,
	getPlrDepReportWithStatus,getWithDrawalTxnReport,getWithDrawalProcessedTxnReport,getBonusDetailReport,getBonusPlrDetailReport,StCmsCampTracking,
	stCmsCampPlayerRegReport,stCmsCampPlayerDepReport,stCmsCampPlayerWiseDepReport,stCmsCampAppDownReport,getPlrWithDrawalReportWithStatus,
	playerPayCorrectionReport,CampRevenueReport,CampWiseRevenuReport,mobileAppDownloadDetail,getAppsFlyerAndroidReportData,getAppsFlyerIosReportData,
	StCmsReferFriendTracking,campRevReferFrndReport,campRevReferFrndPlrReport,getBonusAnalysisReport,LocationWiseWagerAndWinning,
	deviceWiseWagerAndWinning,plrWiseWagerWinningFromTablet,getTotalNgrIgeDayWise,getTotalNgrSlotDayWise,TicketDetails,MgmtReport,stCshSubwalletRecTracking
	,TDSReport,itPlayerWise,AdCompany;

	public static boolean contains(String procName) {
		for (ReporProcFromSlave obj : ReporProcFromSlave.values()) {
			if ((obj.name()).equals(procName)) {
				return true;
			}
		}
		return false;
	}
}
