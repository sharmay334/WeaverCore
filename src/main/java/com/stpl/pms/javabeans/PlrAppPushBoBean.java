package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

public class PlrAppPushBoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean selectAll;
//	private ArrayList<String> osArr;
	private ArrayList<Long> verIdArr;
	/**
	 * @return the selectAll
	 */
	public boolean isSelectAll() {
		return selectAll;
	}
	/**
	 * @param selectAll the selectAll to set
	 */
	public void setSelectAll(boolean selectAll) {
		this.selectAll = selectAll;
	}
//	/**
//	 * @return the osArr
//	 */
//	public ArrayList<String> getOsArr() {
//		return osArr;
//	}
//	/**
//	 * @param osArr the osArr to set
//	 */
//	public void setOsArr(ArrayList<String> osArr) {
//		this.osArr = osArr;
//	}
	/**
	 * @return the verIdArr
	 */
	public ArrayList<Long> getVerIdArr() {
		return verIdArr;
	}
	/**
	 * @param verIdArr the verIdArr to set
	 */
	public void setVerIdArr(ArrayList<Long> verIdArr) {
		this.verIdArr = verIdArr;
	}
	
}
