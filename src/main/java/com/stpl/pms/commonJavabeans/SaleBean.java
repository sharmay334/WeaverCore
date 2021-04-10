package com.stpl.pms.commonJavabeans;

public class SaleBean {

	private Double qty;
	private Double price;
	private Double gstPercentage;
	private Double saleAmount;
	private Integer itemRepeat;
	private Double purchasePrice;
	private Integer purchaseRepeat;
	
	private Integer creditNoteRepeat;
	private Double creditNoteQty;
	private Double creditNotePrice;
	private Double creditNoteAmount;
	
	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getItemRepeat() {
		return itemRepeat;
	}

	public void setItemRepeat(Integer itemRepeat) {
		this.itemRepeat = itemRepeat;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getPurchaseRepeat() {
		return purchaseRepeat;
	}

	public void setPurchaseRepeat(Integer purchaseRepeat) {
		this.purchaseRepeat = purchaseRepeat;
	}

	public Integer getCreditNoteRepeat() {
		return creditNoteRepeat;
	}

	public void setCreditNoteRepeat(Integer creditNoteRepeat) {
		this.creditNoteRepeat = creditNoteRepeat;
	}

	public Double getCreditNoteQty() {
		return creditNoteQty;
	}

	public void setCreditNoteQty(Double creditNoteQty) {
		this.creditNoteQty = creditNoteQty;
	}

	public Double getCreditNotePrice() {
		return creditNotePrice;
	}

	public void setCreditNotePrice(Double creditNotePrice) {
		this.creditNotePrice = creditNotePrice;
	}

	public Double getGstPercentage() {
		return gstPercentage;
	}

	public void setGstPercentage(Double gstPercentage) {
		this.gstPercentage = gstPercentage;
	}

	public Double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Double getCreditNoteAmount() {
		return creditNoteAmount;
	}

	public void setCreditNoteAmount(Double creditNoteAmount) {
		this.creditNoteAmount = creditNoteAmount;
	}

	
}
