package com.jdeveloper.punchtime.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long punchIn;
    private Long punchOut;
	private Double hours;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private Set<Employee> employee=new HashSet<>();
	
	
    public TimeSheet() {}

	public TimeSheet(String date, Long punchIn, Long punchOut) {
		this.punchIn = punchIn;
		this.punchOut = punchOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPunchIn() {
		return punchIn;
	}

	public void setPunchIn(Long punchIn) {
		this.punchIn = punchIn;
	}

	public Long getPunchOut() {
		return punchOut;
	}

	public void setPunchOut(Long punchOut) {
		this.punchOut = punchOut;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours=hours;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	
}
