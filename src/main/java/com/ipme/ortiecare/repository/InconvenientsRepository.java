package com.ipme.ortiecare.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.Inconvenients;

public interface InconvenientsRepository extends JpaRepository<Inconvenients, UUID>{
	@Query("SELECT * FROM inconvenients where id_inconvenients = :id")
	Inconvenients findByUUID(@Param("id")UUID id_inconvenients);
	
}
