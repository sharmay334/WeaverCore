package com.stpl.pms.hibernate.mapping;


public class StCshDepositSessionRequestData {
	
	private Long id;
	private Long requestId;
	private String key;
	private String value;
	
	public StCshDepositSessionRequestData(Long requestId, String key, String value) {
		this.requestId = requestId;
		this.key = key;
		this.value = value;
	}
	
	public StCshDepositSessionRequestData(Long requestId, String key) {
		this.requestId = requestId;
		this.key = key;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		StCshDepositSessionRequestData other = (StCshDepositSessionRequestData) obj;
		
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		
		return true;
	}
	
	
	
}
