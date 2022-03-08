package com.jfdeveloper.punchtime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfdeveloper.punchtime.entities.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long>  {

}
