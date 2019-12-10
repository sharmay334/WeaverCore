package com.stpl.pms.hibernate.mapping;

public interface PrivilegeRepMgmtInterface {
	public Integer getFnId();

	public void setFnId(Integer fnId);

	public String getFunctionName();

	public void setFunctionName(String functionName);

	public Integer getPrivId();

	public void setPrivId(Integer privId);

	public String getPrivNameCode();

	public void setPrivNameCode(String privNameCode);

	public Short getGroupId();

	public void setGroupId(Short groupId);

	public String getGroupNameCode();

	public void setGroupNameCode(String groupNameCode);

	public String getPrivStatus();

	public void setPrivStatus(String privStatus);

	public String getTier();

	public void setTier(String tier);

	public String getRelatedTo();

	public void setRelatedTo(String relatedTo);

	public String getDependentPriv();

	public void setDependentPriv(String dependentPriv);

	public String getCheckLogin();

	public void setCheckLogin(String checkLogin);

	public String getIsDefault();

	public void setIsDefault(String isDefault);

	public String getIsDefaultGroup();

	public void setIsDefaultGroup(String isDefaultGroup);
}
