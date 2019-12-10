package com.stpl.pms.controller.um;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionSupport;

public class SearchGameAction extends ActionSupport  {

	HttpServletRequest servletRequest;
	HttpSession session;
	List<GameSearchBean> gameList;
	private String xmlType;
	private String gameName;
	private int gameNumber;

	private int totalTickets;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	@Override
	public String execute() throws Exception {

		return "SUCCESS";
	}

	public String search() throws Exception {
		System.out.println(" in side search game----");
		System.out.println(" game name is " + gameName);
		System.out.println(" game number is " + gameNumber);

		String sqlQuery = "select xml_type,game_no,game_name,no_of_tickets,price from itgs_input ";
		String str = "where ";
		String realQuery = null;
		if (gameNumber != 0) {
			str = str + "game_no=" + gameNumber + " and ";
		}
		if (!gameName.equals("")) {
			str = str + "game_name like '%" + gameName + "%' and ";
		}

		if (gameNumber == 0 && gameName.equals("")) {
			realQuery = sqlQuery;

		} else {
			str = str.substring(0, str.lastIndexOf(" and"));
			realQuery = sqlQuery + " " + str;
		}
		System.out.println("before query  query is " + realQuery);
		ResultSet rs = null;
		System.out.println(" query is " + realQuery);
		gameList = new ArrayList<GameSearchBean>();

		while (rs.next()) {
			GameSearchBean gsb = new GameSearchBean();
			gsb.setGameName(rs.getString("game_name"));
			gsb.setGameNumber(rs.getInt("game_no"));
			gsb.setGamePrice(rs.getInt("price"));
			//gsb.setXmlType(rs.getString("xml_type"));
		//	gsb.setTotalTickets(rs.getInt("no_of_tickets"));
			gameList.add(gsb);
		}
		System.out.println(" before setting in session--------");
		session = servletRequest.getSession();
		session.setAttribute("GAME_LIST", gameList);
		System.out.println(" after session setting----");
		//con.close();
		rs.close();
		//stmt.close();
		System.out.println(" returning success------");
		return "SUCCESS";

	}

	public String viewDetails() {
		HttpSession session = servletRequest.getSession();
		session.setAttribute("GAME_NO", gameNumber);
		session.setAttribute("GAME_NAME", gameName);
		session.setAttribute("TOTAL_TICKETS", totalTickets);
		session.setAttribute("XML_TYPE", xmlType);
		return "SUCCESS";
	}

	public List<GameSearchBean> getGameList() {
		return gameList;
	}

	public int getTotalTickets() {
		return totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}

	public String getXmlType() {
		return xmlType;
	}

	public void setXmlType(String xmlType) {
		this.xmlType = xmlType;
	}

}
