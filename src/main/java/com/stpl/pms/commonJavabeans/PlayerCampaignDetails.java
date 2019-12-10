package com.stpl.pms.commonJavabeans;

import static com.stpl.pms.utility.Utility.notNull;

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.stpl.pms.hibernate.mapping.StCmsCampaignMaster;
import com.stpl.pms.hibernate.mapping.StCmsCampaignTracking;

public class PlayerCampaignDetails{
	private StCmsCampaignTracking campaignTracking;
	
	Map<String, String> paramMap = new TreeMap<>();
	
	public PlayerCampaignDetails(StCmsCampaignTracking campaignTracking, StCmsCampaignMaster campaignMaster) {
		this.campaignTracking = campaignTracking;
		this.prepareMap(campaignMaster);
	}
	
	public PlayerCampaignDetails(StCmsCampaignTracking campaignTracking) {
		this.campaignTracking = campaignTracking;
	}

	public StCmsCampaignTracking getCampaignTracking() {
		return campaignTracking;
	}
	public void setCampaignTracking(StCmsCampaignTracking campaignTracking) {
		this.campaignTracking = campaignTracking;
	}
	
	public void prepareMap(StCmsCampaignMaster master){
		insertFilledKey(paramMap,master.getParam1(),campaignTracking.getValue1());
		insertFilledKey(paramMap, master.getParam2(),campaignTracking.getValue2());
		insertFilledKey(paramMap, master.getParam3(),campaignTracking.getValue3());
		insertFilledKey(paramMap, master.getParam4(),campaignTracking.getValue4());
		insertFilledKey(paramMap, master.getParam5(),campaignTracking.getValue5());
		insertFilledKey(paramMap, master.getParam6(),campaignTracking.getValue6());
		insertFilledKey(paramMap, master.getParam7(),campaignTracking.getValue7());
		insertFilledKey(paramMap, master.getParam8(),campaignTracking.getValue8());
		insertFilledKey(paramMap, master.getParam9(),campaignTracking.getValue9());
		insertFilledKey(paramMap, master.getParam10(),campaignTracking.getValue10());
	}
	public String getParamAsString(){
		return new Gson().toJson(this.paramMap).toString();
	}
	
	private void insertFilledKey(Map<String, String> paramMap,String key,String value){
		if(notNull(key) && notNull(value))
			paramMap.put(key, value);
	}
}
