package com.ipme.ortiecare.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.Legumes;

public interface LegumesRepository extends JpaRepository<Legumes,UUID>{
	
	@Query("SELECT * FROM legumes where id_legume = :id")
	Legumes findByUUID(@Param("id")UUID id_legume);
}
