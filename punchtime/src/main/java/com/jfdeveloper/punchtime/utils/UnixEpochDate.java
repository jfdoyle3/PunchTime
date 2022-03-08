package com.jfdeveloper.punchtime.utils;

public class UnixEpochDate {

	private String datein;
	private String dateOut;
	private long unixTimeIn;
	private long unixTimeOut;
	private double hours;
	
	
	public UnixEpochDate(String datein, String dateOut) {
		this.datein = datein;
		this.dateOut = dateOut;
	}

	public String getDatein() {
		return datein;
	}

	public void setDatein(String datein) {
		this.datein = datein;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	public long getUnixTimeIn() {
		return unixTimeIn;
	}

	public void setUnixTimeIn(long unixTimeIn) {
		this.unixTimeIn = unixTimeIn;
	}

	public long getUnixTimeOut() {
		return unixTimeOut;
	}

	public void setUnixTimeOut(long unixTimeOut) {
		this.unixTimeOut = unixTimeOut;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

}
