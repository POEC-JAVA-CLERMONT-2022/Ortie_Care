package com.ipme.ortiecare.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.ConseilDeCulture;

@Repository
public interface ConseilDeCultureRepository extends JpaRepository<ConseilDeCulture, UUID>{
	
	ConseilDeCulture getById(@Param("id")UUID id_conseil);
	
	ConseilDeCulture findByTitre(String titre);
	
	public List<ConseilDeCulture> findByDescriptionContaining(String boutDescription);
	
	// nativeQuery pour récup les conseils pour un ID legume
	@Query(value="SELECT C.id_conseil, C.description, C.titre FROM conseils_de_culture C,legumes_conseils_de_culture LC where C.id_conseil=LC.conseils_de_culture_id_conseil AND LC.legume_id_legume = :id", nativeQuery=true)
	List<ConseilDeCulture> findConseilsLegume(@Param("id") UUID idLegume);
	
}