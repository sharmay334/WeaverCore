
package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

public class StCshTpTxnRecords implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private short domainId;
	private Long weaverTxnId;
	private Long tpTxnId;
	private Timestamp requestDate;
	private String mobileNo;
	private String providerName;
	private String status;
	private String requestType;

	public Long getId() {
		return id;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWeaverTxnId() {
		return weaverTxnId;
	}

	public void setWeaverTxnId(Long weaverTxnId) {
		this.weaverTxnId = weaverTxnId;
	}

	public Long getTpTxnId() {
		return tpTxnId;
	}

	public void setTpTxnId(Long tpTxnId) {
		this.tpTxnId = tpTxnId;
	}

	public Timestamp getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
