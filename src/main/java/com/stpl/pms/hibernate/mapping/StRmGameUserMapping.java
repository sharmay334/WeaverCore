package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StRmGameUserMapping {

	private int id;
	private int user_id;
	private int game_no;
	private String status;
	private String save_mode;
	private Timestamp date_time;
	private int batch_no;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGame_no() {
		return game_no;
	}

	public void setGame_no(int game_no) {
		this.game_no = game_no;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDate_time() {
		return date_time;
	}

	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}

	public String getSave_mode() {
		return save_mode;
	}

	public void setSave_mode(String save_mode) {
		this.save_mode = save_mode;
	}

	public int getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(int batch_no) {
		this.batch_no = batch_no;
	}

}
