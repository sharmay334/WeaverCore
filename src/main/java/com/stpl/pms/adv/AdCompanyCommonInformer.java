package com.stpl.pms.adv;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.stpl.pms.exception.PMSException;

public abstract class AdCompanyCommonInformer extends AdCompanyGenericInformer {
	private static final Logger logger = Logger.getLogger(AdCompanyCommonInformer.class);
	
	private Long offerId;
	private Long advSub;
	private Double amount;
	private Long camptrackId;
	
	public AdCompanyCommonInformer(Long offerId, Long advSub, double amount, Long camptrackId) {
		super();
		this.offerId = offerId;
		this.advSub = advSub;
		this.amount = amount;
		this.camptrackId = camptrackId;
	}

	@Override
	protected abstract String fetchUrl() throws PMSException;
	protected abstract boolean isEligible(Session session);
	
	protected String fetchData(){
		logger.info("preparing url params");
		StringBuffer sb =new StringBuffer();
		sb.append("offer_id=");
		sb.append(this.offerId);
		
		sb.append("&");
		sb.append("adv_sub=");
		sb.append(this.advSub);
		
		sb.append("&");
		sb.append("amount=");
		sb.append(this.amount);
		logger.info("returning url params = "+sb.toString());
		return sb.toString();
	}
	
	public boolean checkAndinform(Session session){
		if(isEligible(session)){
			asyncSend();
			return true;
		}
		return false;
	}

	public Long getOfferId() {
		return offerId;
	}

	public Long getAdvSub() {
		return advSub;
	}

	public double getAmount() {
		return amount;
	}

	public Long getCamptrackId() {
		return camptrackId;
	}
}
