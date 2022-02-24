package com.jdeveloper.punchtime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdeveloper.punchtime.entities.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {}
