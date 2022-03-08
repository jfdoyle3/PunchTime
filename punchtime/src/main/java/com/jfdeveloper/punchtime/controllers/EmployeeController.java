package com.jfdeveloper.punchtime.controllers;


import com.jfdeveloper.punchtime.entities.Employee;
import com.jfdeveloper.punchtime.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    @ResponseBody
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name) {
        return new ResponseEntity<>(repository.findAllByName(name), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee) {
        return new ResponseEntity<>(repository.save(newEmployee), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updates) {
        Employee Employee = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) Employee.setName(updates.getName());

        return repository.save(Employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Employee ID " + id + " removed", HttpStatus.OK);
    }
}
