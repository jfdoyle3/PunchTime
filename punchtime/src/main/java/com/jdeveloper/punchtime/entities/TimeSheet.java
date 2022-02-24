package com.jdeveloper.punchtime.entities;

import javax.persistence.*;


@Entity
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String punchIn;
    private String punchOut;
	private Double hours;
	
    public TimeSheet() {}

	public TimeSheet(String date, String punchIn, String punchOut) {
		this.punchIn = punchIn;
		this.punchOut = punchOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
