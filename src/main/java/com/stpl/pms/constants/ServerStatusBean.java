package com.stpl.pms.constants;

public class ServerStatusBean {

	public static int GAME_START_RANGE;	
	public static int GAME_END_RANGE;
	public static String SERVER_TYPE;  // U means UAT and P means PRODUCTION
	public static int getGAME_START_RANGE() {
		return GAME_START_RANGE;
	}
	public static void setGAME_START_RANGE(int gAME_START_RANGE) {
		GAME_START_RANGE = gAME_START_RANGE;
	}
	public static int getGAME_END_RANGE() {
		return GAME_END_RANGE;
	}
	public static void setGAME_END_RANGE(int gAME_END_RANGE) {
		GAME_END_RANGE = gAME_END_RANGE;
	}
	public static String getSERVER_TYPE() {
		return SERVER_TYPE;
	}
	public static void setSERVER_TYPE(String sERVER_TYPE) {
		SERVER_TYPE = sERVER_TYPE;
	}
	
}
