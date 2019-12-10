package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StGenCurrencyConversionRateHistory entity. @author MyEclipse Persistence
 * Tools
 */

public class StGenCurrencyConversionRateHistory implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer fromCurrencyId;
	private Integer toCurrencyId;
	private Double exchangeRate;
	private Integer exchangeChargeCurrencyId;
	private Double exchangeCharge;
	private Timestamp exchangeDate;
	private Timestamp updatedDate;

	// Constructors

	/** default constructor */
	public StGenCurrencyConversionRateHistory() {
	}

	/** full constructor */
	public StGenCurrencyConversionRateHistory(Integer fromCurrencyId,
			Integer toCurrencyId, Double exchangeRate,
			Integer exchangeChargeCurrencyId, Double exchangeCharge,
			Timestamp exchangeDate, Timestamp updatedDate) {
		this.fromCurrencyId = fromCurrencyId;
		this.toCurrencyId = toCurrencyId;
		this.exchangeRate = exchangeRate;
		this.exchangeChargeCurrencyId = exchangeChargeCurrencyId;
		this.exchangeCharge = exchangeCharge;
		this.exchangeDate = exchangeDate;
		this.updatedDate = updatedDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFromCurrencyId() {
		return this.fromCurrencyId;
	}

	public void setFromCurrencyId(Integer fromCurrencyId) {
		this.fromCurrencyId = fromCurrencyId;
	}

	public Integer getToCurrencyId() {
		return this.toCurrencyId;
	}

	public void setToCurrencyId(Integer toCurrencyId) {
		this.toCurrencyId = toCurrencyId;
	}

	public Double getExchangeRate() {
		return this.exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Integer getExchangeChargeCurrencyId() {
		return this.exchangeChargeCurrencyId;
	}

	public void setExchangeChargeCurrencyId(Integer exchangeChargeCurrencyId) {
		this.exchangeChargeCurrencyId = exchangeChargeCurrencyId;
	}

	public Double getExchangeCharge() {
		return this.exchangeCharge;
	}

	public void setExchangeCharge(Double exchangeCharge) {
		this.exchangeCharge = exchangeCharge;
	}

	public Timestamp getExchangeDate() {
		return this.exchangeDate;
	}

	public void setExchangeDate(Timestamp exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public Timestamp getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}