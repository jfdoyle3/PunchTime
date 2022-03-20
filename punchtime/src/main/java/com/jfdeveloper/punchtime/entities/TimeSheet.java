package com.jfdeveloper.punchtime.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String employee;
	private String company;
	private Long punchTime;
	
	public TimeSheet() {}

	public TimeSheet(String employee, String company, Long punchTime) {
		this.employee = employee;
		this.company = company;
		this.punchTime = punchTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Long getPunchTime() {
		return punchTime;
	}

	public void setPunchTime(Long punchTime) {
		this.punchTime = punchTime;
	}	
	
}
