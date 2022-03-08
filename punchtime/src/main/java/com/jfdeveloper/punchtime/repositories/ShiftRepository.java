package com.jfdeveloper.punchtime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfdeveloper.punchtime.entities.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
	
}
