package com.stpl.pms.hibernate.mapping;

import java.sql.Blob;

public class Itgs {

	private int id;
	private int game_No;
	private String game_Name;
	private Double price;
	private String xml_Type;
	private int no_Of_Tickets;
	private int no_Of_Tickets_Per_Book;
	private int no_Of_Books_Per_Pack;
	private int starting_Pack;
	private byte[] ticket_Str_Xml;
	private byte[] game_Exp_Xml;
	private byte[] pd_Xml;
	private byte[] pdc_Xml;
	private byte[] agtvc_Xml;
	private byte[] location_Xml;
	private String is_Append_Game_No;
	private int virn_Digits;
	private byte[] promo_Xml;
	private int batch_no;
	private String status;
	private byte[] front_img;
	private byte[] back_img;
	private byte[] scratched_img;
  	
	
	
	
	public byte[] getFront_img() {
		return front_img;
	}
	public void setFront_img(byte[] front_img) {
		this.front_img = front_img;
	}
	public byte[] getBack_img() {
		return back_img;
	}
	public void setBack_img(byte[] back_img) {
		this.back_img = back_img;
	}
	public byte[] getScratched_img() {
		return scratched_img;
	}
	public void setScratched_img(byte[] scratched_img) {
		this.scratched_img = scratched_img;
	}
	public int getGame_No() {
		return game_No;
	}
	public void setGame_No(int game_No) {
		this.game_No = game_No;
	}
	public String getGame_Name() {
		return game_Name;
	}
	public void setGame_Name(String game_Name) {
		this.game_Name = game_Name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getXml_Type() {
		return xml_Type;
	}
	public void setXml_Type(String xml_Type) {
		this.xml_Type = xml_Type;
	}
	public int getNo_Of_Tickets() {
		return no_Of_Tickets;
	}
	public void setNo_Of_Tickets(int no_Of_Tickets) {
		this.no_Of_Tickets = no_Of_Tickets;
	}
	public int getNo_Of_Tickets_Per_Book() {
		return no_Of_Tickets_Per_Book;
	}
	public void setNo_Of_Tickets_Per_Book(int no_Of_Tickets_Per_Book) {
		this.no_Of_Tickets_Per_Book = no_Of_Tickets_Per_Book;
	}
	public int getNo_Of_Books_Per_Pack() {
		return no_Of_Books_Per_Pack;
	}
	public void setNo_Of_Books_Per_Pack(int no_Of_Books_Per_Pack) {
		this.no_Of_Books_Per_Pack = no_Of_Books_Per_Pack;
	}
	public int getStarting_Pack() {
		return starting_Pack;
	}
	public void setStarting_Pack(int starting_Pack) {
		this.starting_Pack = starting_Pack;
	}
	public byte[] getTicket_Str_Xml() {
		return ticket_Str_Xml;
	}
	public void setTicket_Str_Xml(byte[] ticket_Str_Xml) {
		this.ticket_Str_Xml = ticket_Str_Xml;
	}
	public byte[] getGame_Exp_Xml() {
		return game_Exp_Xml;
	}
	public void setGame_Exp_Xml(byte[] game_Exp_Xml) {
		this.game_Exp_Xml = game_Exp_Xml;
	}
	public byte[] getPd_Xml() {
		return pd_Xml;
	}
	public void setPd_Xml(byte[] pd_Xml) {
		this.pd_Xml = pd_Xml;
	}
	public byte[] getPdc_Xml() {
		return pdc_Xml;
	}
	public void setPdc_Xml(byte[] pdc_Xml) {
		this.pdc_Xml = pdc_Xml;
	}
	public byte[] getAgtvc_Xml() {
		return agtvc_Xml;
	}
	public void setAgtvc_Xml(byte[] agtvc_Xml) {
		this.agtvc_Xml = agtvc_Xml;
	}
	public byte[] getLocation_Xml() {
		return location_Xml;
	}
	public void setLocation_Xml(byte[] location_Xml) {
		this.location_Xml = location_Xml;
	}
	public String getIs_Append_Game_No() {
		return is_Append_Game_No;
	}
	public void setIs_Append_Game_No(String is_Append_Game_No) {
		this.is_Append_Game_No = is_Append_Game_No;
	}
	public int getVirn_Digits() {
		return virn_Digits;
	}
	public void setVirn_Digits(int virn_Digits) {
		this.virn_Digits = virn_Digits;
	}
	public byte[] getPromo_Xml() {
		return promo_Xml;
	}
	public void setPromo_Xml(byte[] promo_Xml) {
		this.promo_Xml = promo_Xml;
	}
	public int getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(int batch_no) {
		this.batch_no = batch_no;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
