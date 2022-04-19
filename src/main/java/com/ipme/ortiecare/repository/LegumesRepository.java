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
	
	// Ajout d'association legume => legume
	@Query(value="INSERT INTO legumes_legumes_associes VALUES (:idLegume1 , :idLegume2)", nativeQuery=true)
	Integer addAssociationLegumeLegume(@Param("idLegume1") UUID id_legume1, @Param("idLegume2") UUID id_legume2);
	
	// A test
	@Query("SELECT l1 from LegumesLegumesAssocies lla INNER JOIN lla.assoLegumes.legume1 l1 INNER JOIN lla.assoLegumes.legume2 l2 WHERE l2.idLegume = :id ")
	List<Legume> findLegumesAssocies(@Param("id") UUID idLegume);
	
	
	
	
	
	
	// A garder pour l'instant
	
//	@Query(value="SELECT * FROM legumes_legumes_associes WHERE legume_id_legume = :idLegume", nativeQuery = true)
//	Object[] getAssociatedLegumes(@Param("idLegume")UUID idLegume);
	
	//List<Legume> findByIdLegume_ConseilDeCulture_IdLegume (UUID idLegume);
	
	
}