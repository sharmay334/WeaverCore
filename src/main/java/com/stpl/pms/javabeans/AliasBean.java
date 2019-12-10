package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AliasBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int aliasId;
	private String aliasName;
	private String status;

	

	public int getAliasId() {
		return aliasId;
	}

	public void setAliasId(int aliasId) {
		this.aliasId = aliasId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	@Override
	public String toString() {
		return "AliasBean [aliasName=" + aliasName + ", aliasId="
				+ aliasId + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
