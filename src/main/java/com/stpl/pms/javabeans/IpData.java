package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

public class IpData implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<IpDetails> ipDetails;

	public List<IpDetails> getIpDetails() {
		return ipDetails;
	}

	public void setIpDetails(List<IpDetails> ipDetails) {
		this.ipDetails = ipDetails;
	}
	
	public void setIpDetails(IpDetails bean) {
		if(this.ipDetails == null){
			this.ipDetails = new ArrayList<IpDetails>();
		}
		this.ipDetails.add(bean);
	}

}
