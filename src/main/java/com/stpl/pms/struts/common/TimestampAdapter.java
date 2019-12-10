package com.stpl.pms.struts.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimestampAdapter extends XmlAdapter<String, Timestamp> {
	public String marshal(Timestamp v) {
		return v.toString();
	}

	public Timestamp unmarshal(String v) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long datetime=0;
		try {
			datetime=format.parse(v).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Timestamp(datetime);
	}
}
