/**
 * 
 */
package com.stpl.pms.javabeans;

/**
 * @author yash.sharma
 *
 */
public class StockGroupBean {

	private int stGpId;
	private String stockName;
	private String stockUnder;
	private String qtyCheck;
	private String gstDetCheck;

	public int getStGpId() {
		return stGpId;
	}

	public void setStGpId(int stGpId) {
		this.stGpId = stGpId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockUnder() {
		return stockUnder;
	}

	public void setStockUnder(String stockUnder) {
		this.stockUnder = stockUnder;
	}

	public String getQtyCheck() {
		return qtyCheck;
	}

	public void setQtyCheck(String qtyCheck) {
		this.qtyCheck = qtyCheck;
	}

	public String getGstDetCheck() {
		return gstDetCheck;
	}

	public void setGstDetCheck(String gstDetCheck) {
		this.gstDetCheck = gstDetCheck;
	}

}
