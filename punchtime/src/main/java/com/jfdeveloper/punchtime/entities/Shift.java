package com.jfdeveloper.punchtime.entities;

import javax.persistence.*;

@Entity
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long punchIn;
    private Long punchOut;
	private Double hours;
	
	@OneToOne
	private Employee employee;
	
	@OneToOne
	private Company company;
	
	
    public Shift() {}

	public Shift(Long punchIn, Long punchOut) {
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
