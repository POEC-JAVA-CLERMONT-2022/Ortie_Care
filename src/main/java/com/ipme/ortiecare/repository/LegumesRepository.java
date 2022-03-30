package com.ipme.ortiecare.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.Legume;

@Repository
public interface LegumesRepository extends JpaRepository<Legume,UUID>{
	
	@Query(value="SELECT * FROM legumes where id_legume = :id", nativeQuery = true)
	Legume findByUUID(@Param("id")UUID id_legume);
}
