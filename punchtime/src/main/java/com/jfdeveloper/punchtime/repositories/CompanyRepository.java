package com.jfdeveloper.punchtime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfdeveloper.punchtime.entities.Company;
import com.jfdeveloper.punchtime.entities.Shift;

@Repository
	public interface CompanyRepository extends JpaRepository<Company, Long> {

	Object save(Shift newCompany);
	
	
	}

