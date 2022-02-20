package com.jdeveloper.punchtime.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdeveloper.punchtime.entities.Shift;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {}
