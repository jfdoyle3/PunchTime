package com.jdeveloper.punchtime.controllers;

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


import com.jdeveloper.punchtime.entities.TimeSheet;
import com.jdeveloper.punchtime.repositories.TimeSheetRepository;

@RestController
@RequestMapping("/api/shifts")
public class TimeSheetController {

    @Autowired
    private TimeSheetRepository repository;
    


    @GetMapping
    @ResponseBody
    public List<TimeSheet> getShifts() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<TimeSheet> addShift(@RequestBody TimeSheet newShift) {
    	
        return new ResponseEntity<>(repository.save(newShift), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    @ResponseBody
//    public Shift updateShift(@PathVariable Long id, @RequestBody Shift updates) {
//        Shift shift = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        if (updates.getName() != null) Shift.setName(updates.getName());
//        if (updates.getRole()!= null) Shift.setRole(updates.getRole());
//        if (updates.getDepartment() != null) Shift.setDepartment(updates.getDepartment());
//        if (updates.getLocation()!= null) Shift.setLocation(updates.getLocation());
//        if (updates.getSupervisor()!= null) Shift.setSupervisor(updates.getSupervisor());
//        if (updates.getSkills() != null) Shift.setSkills(updates.getSkills());
//        if (updates.getSalary()!= null) Shift.setSalary(updates.getSalary());
//        if (updates.getDateHired()!= null) Shift.setDateHired(updates.getDateHired());
//
//        return repository.save(shift);
//    }


      // TODO: Assign Employee Shifts
      // TODO: REFACTOR/FIX THIS TO WORK
//    @PostMapping("/{empId}")
//    public @ResponseBody Post newPost(@PathVariable Long empId, @RequestBody Post newPost) {
//        Shift poster = repository.findById(empId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Developer Not Found"));
//        newPost.setEmpoyee(poster);
//        return repository.save(newPost);
 //   }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeShift(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Shift ID " + id + " removed", HttpStatus.OK);
    }
}
