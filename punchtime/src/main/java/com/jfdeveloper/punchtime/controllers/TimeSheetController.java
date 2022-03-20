package com.jfdeveloper.punchtime.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfdeveloper.punchtime.entities.TimeSheet;
import com.jfdeveloper.punchtime.repositories.TimeSheetRepository;
import com.jfdeveloper.punchtime.utils.DateTimeUtils;


@RestController
@RequestMapping("/api/timesheets")
public class TimeSheetController {
	
	@Autowired
	private TimeSheetRepository repository;
	
	
	@GetMapping
	@ResponseBody
	public List<TimeSheet> getTimesheet() { return repository.findAll(); } 
	
	@PostMapping
	public ResponseEntity<TimeSheet> addTimeSheet(@RequestBody TimeSheet newTimeSheet) throws ParseException {
		return new ResponseEntity<>(repository.save(newTimeSheet), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeShift(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Shift ID " + id + " removed", HttpStatus.OK);
	}
}