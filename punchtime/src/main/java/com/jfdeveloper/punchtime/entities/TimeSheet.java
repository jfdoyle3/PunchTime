package com.jfdeveloper.punchtime.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private String employee;
	
	@OneToOne
	private String company;
	
	
	private String title;
	private Long weekStart;
	private Long weekEnd;
	private Double totalHours;
	
	public TimeSheet() {}

	public TimeSheet(String employee, String company, String title, Long weekStart, Long weekEnd) {
		this.employee = employee;
		this.company = company;
		this.title = title;
		this.weekStart = weekStart;
		this.weekEnd = weekEnd;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getWeekStart() {
		return weekStart;
	}

	public void setWeekStart(Long weekStart) {
		this.weekStart = weekStart;
	}

	public Long getWeekEnd() {
		return weekEnd;
	}

	public void setWeekEnd(Long weekEnd) {
		this.weekEnd = weekEnd;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}
}
