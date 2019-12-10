package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

public class IpDetails implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> ip;
	private int noOfGames;

	public List<String> getIp() {
		return ip;
	}

	public void setIp(List<String> ip) {
		this.ip = ip;
	}
	
	public void setIp(String ip) {
		if(this.ip == null){
			this.ip = new ArrayList<String>();
		}
		this.ip.add(ip);
	}


	public int getNoOfGames() {
		return noOfGames;
	}

	public void setNoOfGames(int noOfGames) {
		this.noOfGames = noOfGames;
	}
	
	@Override
	public String toString() {
		return "IpDetails [ip=" + ip + ", noOfGames=" + noOfGames + "]";
	}
	
}
