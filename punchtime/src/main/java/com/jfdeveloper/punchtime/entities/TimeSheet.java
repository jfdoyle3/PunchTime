package com.jfdeveloper.punchtime.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
		
	// Employee
	// Company
	// Position / Department
	// Week Start
	// Week Ending
	// Total Hours
	
	
}
