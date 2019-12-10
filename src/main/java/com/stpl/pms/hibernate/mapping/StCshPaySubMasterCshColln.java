package com.stpl.pms.hibernate.mapping;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import com.stpl.pms.utility.Utility;

/**
 * StCshPaySubMasterCshColln entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterCshColln extends StCshPaySubMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private Integer countryId;
	private String city;
	private Blob pinCode;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterCshColln() {
	}

	/** full constructor */
	public StCshPaySubMasterCshColln(Integer subTypeId, Integer countryId,
			String city, Blob pinCode, String status) {
		super();
		this.subTypeId = subTypeId;
		this.countryId = countryId;
		this.city = city;
		this.pinCode = pinCode;
		this.status = status;
	}


	// Property accessors

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

	public Integer getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setPinCode(Blob pinCode) {
		this.pinCode = pinCode;
	}

	public Blob getPinCode() {
		return pinCode;
	}
	public String getPinCodeString() {
		String s="";
		try {
			s= Utility.blobToString(pinCode);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}