package com.stpl.pms.hibernate.mapping;

public interface ActionFunctionMappingInterface {
	
	public Integer getFnId();

	public void setFnId(Integer fnId);

	public Integer getActionId();

	public void setActionId(Integer actionId);

	public String getActionName();

	public void setActionName(String actionName);

	public String getActionDesc();

	public void setActionDesc(String actionDesc);

	public String getActionUrl();

	public void setActionUrl(String actionUrl);

	public String getStatus();

	public void setStatus(String status);
}
