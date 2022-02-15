package com.jdeveloper.punchtime.entities;

import javax.persistence.*;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
//    private String role;
//    private String department;
//    private String location;
//    private String supervisor;
//    private Double salary;
//    private Date dateHired;

//    @OneToOne
//    @JoinColumn(name = "developer_id", referencedColumnName = "id")
//    private Shift shift;

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

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getSupervisor() {
//        return supervisor;
//    }
//
//    public void setSupervisor(String supervisor) {
//        this.supervisor = supervisor;
//    }
//
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//    public Date getDateHired() {
//        return dateHired;
//    }
//
//    public void setDateHired (Date dateHired) {
//        this.dateHired = dateHired;
//    }
}
