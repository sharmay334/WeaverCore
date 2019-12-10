package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponseMpower entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseMpower implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long requestId;
	private String token;
	private String respCode;
	private String respText;
	private String invoiceAmt;
	private String invoiceTax;
	private String invoiceDesc;
	private String invoiceTxnId;
	private String invoiceUrl;
	private String status;
	private String plrName;
	private String plrPhone;
	private String plrEmail;
	private String receiptUrl;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseMpower() {
	}

	/** minimal constructor */
	public StCshPlrDepositResponseMpower(String token) {
		this.token = token;
	}

	/** full constructor */
	public StCshPlrDepositResponseMpower(Long requestId, String token,
			String respCode, String respText, String invoiceAmt,
			String invoiceTax, String invoiceDesc, String invoiceTxnId,
			String invoiceUrl, String status, String plrName, String plrPhone,
			String plrEmail, String receiptUrl) {
		this.requestId = requestId;
		this.token = token;
		this.respCode = respCode;
		this.respText = respText;
		this.invoiceAmt = invoiceAmt;
		this.invoiceTax = invoiceTax;
		this.invoiceDesc = invoiceDesc;
		this.invoiceTxnId = invoiceTxnId;
		this.invoiceUrl = invoiceUrl;
		this.status = status;
		this.plrName = plrName;
		this.plrPhone = plrPhone;
		this.plrEmail = plrEmail;
		this.receiptUrl = receiptUrl;
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRespCode() {
		return this.respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespText() {
		return this.respText;
	}

	public void setRespText(String respText) {
		this.respText = respText;
	}

	public String getInvoiceAmt() {
		return this.invoiceAmt;
	}

	public void setInvoiceAmt(String invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public String getInvoiceTax() {
		return this.invoiceTax;
	}

	public void setInvoiceTax(String invoiceTax) {
		this.invoiceTax = invoiceTax;
	}

	public String getInvoiceDesc() {
		return this.invoiceDesc;
	}

	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}

	public String getInvoiceTxnId() {
		return this.invoiceTxnId;
	}

	public void setInvoiceTxnId(String invoiceTxnId) {
		this.invoiceTxnId = invoiceTxnId;
	}

	public String getInvoiceUrl() {
		return this.invoiceUrl;
	}

	public void setInvoiceUrl(String invoiceUrl) {
		this.invoiceUrl = invoiceUrl;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlrName() {
		return this.plrName;
	}

	public void setPlrName(String plrName) {
		this.plrName = plrName;
	}

	public String getPlrPhone() {
		return this.plrPhone;
	}

	public void setPlrPhone(String plrPhone) {
		this.plrPhone = plrPhone;
	}

	public String getPlrEmail() {
		return this.plrEmail;
	}

	public void setPlrEmail(String plrEmail) {
		this.plrEmail = plrEmail;
	}

	public String getReceiptUrl() {
		return this.receiptUrl;
	}

	public void setReceiptUrl(String receiptUrl) {
		this.receiptUrl = receiptUrl;
	}

}