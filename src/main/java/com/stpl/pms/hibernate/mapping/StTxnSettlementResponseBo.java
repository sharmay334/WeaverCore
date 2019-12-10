package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StTxnSettlementResponseBo entity. @author MyEclipse Persistence Tools
 */

public class StTxnSettlementResponseBo implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long requestId;
	private Integer userId;
	private Timestamp settlementDate;
	private String remarks;
	private String settlementType;

	// Constructors

	/** default constructor */
	public StTxnSettlementResponseBo() {
	}

	/** full constructor */
	public StTxnSettlementResponseBo(Long requestId, Integer userId,
			Timestamp settlementDate, String remarks, String settlementType) {
		this.requestId = requestId;
		this.userId = userId;
		this.settlementDate = settlementDate;
		this.remarks = remarks;
		this.settlementType = settlementType;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getSettlementDate() {
		return this.settlementDate;
	}

	public void setSettlementDate(Timestamp settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSettlementType() {
		return this.settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

}