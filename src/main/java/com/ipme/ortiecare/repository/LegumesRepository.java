package com.ipme.ortiecare.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.Legume;

@Repository
public interface LegumesRepository extends JpaRepository<Legume,UUID>{
	
	@Query(value="SELECT * FROM legumes where id_legume = :id", nativeQuery = true)
	Legume findByUUID(@Param("id")UUID id_legume);
	
	@Query(value="INSERT INTO legumes_legumes_associes VALUES (:idLegume1 , :idLegume2)", nativeQuery=true)
	Integer addAssociationLegumeLegume(@Param("idLegume1, idLegume2") UUID id_legume1, UUID id_legume2);
	
//	@Query(value="SELECT * FROM legumes_legumes_associes WHERE legume_id_legume = :idLegume1 AND legumes_associes_id_legume = :idLegume2 GROUP BY legume_id_legume", nativeQuery = true)
//	Object[] doesAssociationsExist(@Param("idLegume1, idLegume2")UUID idLegume1, UUID idLegume2);
}