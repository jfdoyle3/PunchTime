package com.jdeveloper.punchtime.repositories;

import com.jdeveloper.punchtime.entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {}
