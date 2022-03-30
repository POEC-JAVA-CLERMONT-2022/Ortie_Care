package com.ipme.ortiecare.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.Legume;

public interface LegumesRepository extends JpaRepository<Legume,UUID>{
	
	@Query("SELECT * FROM legumes where id_legume = :id")
	Legume findByUUID(@Param("id")UUID id_legume);
}
