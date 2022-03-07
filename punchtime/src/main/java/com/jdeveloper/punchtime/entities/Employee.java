package com.jdeveloper.punchtime.entities;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;


    @OneToMany(fetch=FetchType.LAZY)
    private TimeSheet shift;

	public Employee() {
	}

	public Employee(String name) {
		super();
		this.name = name;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TimeSheet getShift() {
		return shift;
	}

	public void setShift(TimeSheet shift) {
		this.shift = shift;
	}
	
	

}
