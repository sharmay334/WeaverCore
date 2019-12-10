package com.stpl.pms.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class RGEInformerUtil {
	private static final Logger LOGGER = LogManager.getLogger(RGEInformerUtil.class);
	
	public static final void informBonusRedemption(BonusMessageContext messageContext){
		try {
			LOGGER.info("Informing rummy engine for player bonus disbursal...");
			LOGGER.info("URL :"+messageContext.getUrl()+", QueryString :"+messageContext.getQueryParam());
			LOGGER.info(Utility.callUrl(messageContext.getUrl(), messageContext.getQueryParam()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class BonusMessageContext{
		private String url;
		private Long playerId;
		private Double amount;


		public String getUrl() {
			return url;
		}
		public BonusMessageContext setUrl(String url) {
			this.url = url;
			return this;
		}
		public Long getPlayerId() {
			return playerId;
		}
		public BonusMessageContext setPlayerId(Long playerId) {
			this.playerId = playerId;
			return this;
		}
		public Double getAmount() {
			return amount;
		}
		public BonusMessageContext setAmount(Double amount) {
			this.amount = amount;
			return this;
		}

		public String getQueryParam() throws JsonGenerationException, JsonMappingException, IOException{
			Map<String,Object> json = new HashMap<>();
			json.put("playerId", playerId);
			json.put("amount", amount);
			return new StringBuilder()
					.append("requestData=").append(Utility.beanToJSON(json, false)).toString();
		}
	}
}
