package com.jdeveloper.punchtime.entities;

import java.text.ParseException;

import javax.persistence.*;

import com.jdeveloper.punchtime.utils.DateTimeUtils;

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private String punchIn;
    private String punchOut;
	@SuppressWarnings("unused")
	private Double hours;
	
    public Shift() {}

	public Shift(String date, String punchIn, String punchOut) {
		this.date = date;
		this.punchIn = punchIn;
		this.punchOut = punchOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPunchIn() {
		return punchIn;
	}

	public void setPunchIn(String punchIn) {
		this.punchIn = punchIn;
	}

	public String getPunchOut() {
		return punchOut;
	}

	public void setPunchOut(String punchOut) {
		this.punchOut = punchOut;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {

		this.hours=hours;
	}
}
