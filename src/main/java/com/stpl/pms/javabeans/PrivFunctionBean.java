package com.stpl.pms.javabeans;

import java.util.Set;

public class PrivFunctionBean  implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<String> functionSet;
	private Set<Integer> privSet;
	
	
	public void setFunctionSet(Set<String> functionSet) {
		this.functionSet = functionSet;
	}
	public Set<String> getFunctionSet() {
		return functionSet;
	}
	public void setPrivSet(Set<Integer> privSet) {
		this.privSet = privSet;
	}
	public Set<Integer> getPrivSet() {
		return privSet;
	}
	
	
	
	
}
