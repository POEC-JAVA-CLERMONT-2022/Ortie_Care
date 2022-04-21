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
	//TODO: utiliser JPA
	ConseilDeCulture findByTitle(@Param("titre")String titre);
	
	public List<ConseilDeCulture> findByDescriptionContaining(String boutDescription);
	// A test
	@Query("SELECT c from LegumesConseilsDeCulture lcc INNER JOIN lcc.conseilLegume.legume l1 INNER JOIN lcc.conseilLegume.conseil c WHERE l1.idLegume = :id ")
	List<ConseilDeCulture> findConseilsLegume(@Param("id") UUID idLegume);

}