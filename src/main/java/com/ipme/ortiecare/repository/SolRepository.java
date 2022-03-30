package com.ipme.ortiecare.repository;

import java.util.UUID;
import com.ipme.ortiecare.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolRepository extends JpaRepository<Sol, UUID>{
	@Query("SELECT * FROM sols WHERE id_sols = :id")
	 Sol findByUUID(@Param("id")UUID id_sols);
}
