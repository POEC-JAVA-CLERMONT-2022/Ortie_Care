package com.ipme.ortiecare.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.model.ConseilDeCulture;

@Repository
public interface LegumesRepository extends JpaRepository<Legume,UUID>{
	
	@Query(value="SELECT * FROM legumes where id_legume = :id", nativeQuery = true)
	Legume findByUUID(@Param("id")UUID id_legume);
	
	Legume findByNom (String nom);
	
	List<Legume> findByNomStartingWith(String nom);
	
	
	@Query(value="INSERT INTO legumes_legumes_associes VALUES (:idLegume1 , :idLegume2)", nativeQuery=true)
	Integer addAssociationLegumeLegume(@Param("idLegume1, idLegume2") UUID id_legume1, UUID id_legume2);
	
	@Query(value="SELECT * FROM legumes_legumes_associes WHERE legume_id_legume = :idLegume", nativeQuery = true)
	Object[] getAssociatedLegumes(@Param("idLegume")UUID idLegume);
	
	List<ConseilDeCulture> findByIdLegume_ConseilDeCulture_IdLegume (UUID idLegume);
	
}