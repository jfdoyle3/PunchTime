package com.jfdeveloper.punchtime.repositories;

import com.jfdeveloper.punchtime.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByName(String name);

}
