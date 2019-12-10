package com.stpl.pms.javabeans;

public class BetGamesTvRespParamBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Long user_id;
	private String username;
	private String currency;
	private String info;
	
	private String new_token;
	
	private Double balance;

	private Double balance_after;
	private Integer already_processed;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long userId) {
		user_id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance_after(Double balance_after) {
		this.balance_after = balance_after;
	}

	public Double getBalance_after() {
		return balance_after;
	}

	public void setAlready_processed(Integer already_processed) {
		this.already_processed = already_processed;
	}

	public Integer getAlready_processed() {
		return already_processed;
	}

	public void setNew_token(String new_token) {
		this.new_token = new_token;
	}

	public String getNew_token() {
		return new_token;
	}

}
