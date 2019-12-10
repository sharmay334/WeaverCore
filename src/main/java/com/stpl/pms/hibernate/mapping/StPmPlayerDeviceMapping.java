package com.stpl.pms.hibernate.mapping;

public class StPmPlayerDeviceMapping implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId; 
	private String imeiNo;
	private String appType;
	private String deviceId;
	
	/** default constructor */
	public StPmPlayerDeviceMapping() {
	}

	public StPmPlayerDeviceMapping(Long playerId, String imeiNo, String appType,
			String deviceId) {
			
		this.playerId = playerId;
		this.imeiNo = imeiNo;
		this.appType = appType;
		this.deviceId = deviceId;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}	

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


}
