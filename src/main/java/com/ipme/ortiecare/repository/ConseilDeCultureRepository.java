package com.ipme.ortiecare.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.ConseilDeCulture;

public interface ConseilDeCultureRepository extends JpaRepository<ConseilDeCulture, UUID>{

	@Query("SELECT * FROM conseils_de_culture where id_conseil = :id")
	ConseilDeCulture findByUUID(@Param("id")UUID id);
	
	@Query("SELECT * FROM conseils_de_culture where titre = :titre")
	ConseilDeCulture findByTitle(@Param("titre")String titre);
	
//	@Query("SELECT * FROM conseils_de_culture ")
//	ConseilDeCulture findByUUID(UUID id);
}