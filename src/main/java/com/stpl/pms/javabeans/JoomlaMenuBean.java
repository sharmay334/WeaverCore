package com.stpl.pms.javabeans;

import java.util.List;

public class JoomlaMenuBean {
	private Integer id;
	private String title;
	private String alias;
	private List<Integer> availModules;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public List<Integer> getAvailModules() {
		return availModules;
	}

	public void setAvailModules(List<Integer> availModules) {
		this.availModules = availModules;
	}

}
