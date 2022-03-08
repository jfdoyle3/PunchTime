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

import com.jfdeveloper.punchtime.entities.Shift;
import com.jfdeveloper.punchtime.repositories.ShiftRepository;
import com.jfdeveloper.punchtime.utils.DateTimeUtils;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

	@Autowired
	private ShiftRepository repository;

	@GetMapping
	@ResponseBody
	public List<Shift> getShifts() {
		return repository.findAll();
	}

	@PostMapping
	public ResponseEntity<Shift> addShift(@RequestBody Shift newShift) throws ParseException {
		newShift.setHours(DateTimeUtils.calculateHours(newShift.getPunchIn(), newShift.getPunchOut()));
		return new ResponseEntity<>(repository.save(newShift), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeShift(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Shift ID " + id + " removed", HttpStatus.OK);
	}
}
