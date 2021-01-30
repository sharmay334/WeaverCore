package com.stpl.pms.commonJavabeans;

public class SalaryReportBean {

	private int Id;
	private String date;
	private String empId;
	private String attendanceType;
	private String salary;
	private String TA;
	private String dA;
	private String otherExp;
	private String hotelExp;
	private String odoReading;
	private String workingHour;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getAttendanceType() {
		return attendanceType;
	}

	public void setAttendanceType(String attendanceType) {
		this.attendanceType = attendanceType;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTA() {
		return TA;
	}

	public void setTA(String tA) {
		TA = tA;
	}

	public String getdA() {
		return dA;
	}

	public void setdA(String dA) {
		this.dA = dA;
	}

	public String getOtherExp() {
		return otherExp;
	}

	public void setOtherExp(String otherExp) {
		this.otherExp = otherExp;
	}

	public String getHotelExp() {
		return hotelExp;
	}

	public void setHotelExp(String hotelExp) {
		this.hotelExp = hotelExp;
	}

	public String getOdoReading() {
		return odoReading;
	}

	public void setOdoReading(String odoReading) {
		this.odoReading = odoReading;
	}

	public String getWorkingHour() {
		return workingHour;
	}

	public void setWorkingHour(String workingHour) {
		this.workingHour = workingHour;
	}

}
