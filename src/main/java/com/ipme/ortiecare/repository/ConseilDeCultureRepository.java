package com.ipme.ortiecare.repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.ConseilDeCulture;

@Repository
public interface ConseilDeCultureRepository extends JpaRepository<ConseilDeCulture, UUID>{

	@Query(value="SELECT * FROM conseils_de_culture where id_conseil = :id", nativeQuery = true)
	ConseilDeCulture findByUUID(@Param("id")UUID id_conseil);
	
	@Query(value="SELECT * FROM conseils_de_culture where titre = :titre", nativeQuery = true)
	ConseilDeCulture findByTitle(@Param("titre")String titre);
	
	public List<ConseilDeCulture> findByDescriptionContaining(String boutDescription);

}