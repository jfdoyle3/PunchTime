package com.jfdeveloper.punchtime.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jfdeveloper.punchtime.entities.Company;
import com.jfdeveloper.punchtime.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

	@Autowired
	private CompanyRepository repository;
	
	@GetMapping
	@ResponseBody
	public List<Company> getCompany() { return repository.findAll(); } 
	
    @PostMapping
    public ResponseEntity<Company> addEmployee(@RequestBody Company newCompany) {
        return new ResponseEntity<>(repository.save(newCompany), HttpStatus.CREATED);
    }
	 
	 
}
