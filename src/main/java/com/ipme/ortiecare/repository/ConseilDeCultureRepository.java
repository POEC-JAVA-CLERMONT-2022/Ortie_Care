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
	
	// nativeQuery pour récup les conseils pour un ID legume
	@Query(value="SELECT C.id_conseil, C.description, C.titre FROM conseils_de_culture C,legumes_conseils_de_culture LC where C.id_conseil=LC.conseils_de_culture_id_conseil AND LC.legume_id_legume = :id", nativeQuery=true)
	List<ConseilDeCulture> findConseilsLegume(@Param("id") UUID idLegume);
	
	// A test quand le reste marchera : query generé pour recup les conseils d'un id legume
//	@Query("SELECT c from LegumesConseilsDeCulture lcc INNER JOIN lcc.conseilLegume.legume l1 INNER JOIN lcc.conseilLegume.conseil c WHERE l1.idLegume = :id ")
//	List<ConseilDeCulture> findConseilsLegume(@Param("id") UUID idLegume);	
}