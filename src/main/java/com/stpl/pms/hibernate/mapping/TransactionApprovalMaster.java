package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class TransactionApprovalMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer empId;
	private Integer juniorAccId;
	private Integer dispacherAccId;
	private Integer seniorAccId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getJuniorAccId() {
		return juniorAccId;
	}

	public void setJuniorAccId(Integer juniorAccId) {
		this.juniorAccId = juniorAccId;
	}

	public Integer getDispacherAccId() {
		return dispacherAccId;
	}

	public void setDispacherAccId(Integer dispacherAccId) {
		this.dispacherAccId = dispacherAccId;
	}

	public Integer getSeniorAccId() {
		return seniorAccId;
	}

	public void setSeniorAccId(Integer seniorAccId) {
		this.seniorAccId = seniorAccId;
	}

}
