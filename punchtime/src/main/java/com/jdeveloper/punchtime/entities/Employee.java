package com.jdeveloper.punchtime.entities;


import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long id;
	private String name;


    @OneToOne
    @JoinColumn(name = "timeshe_id", referencedColumnName = "id")
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
	
	

}
