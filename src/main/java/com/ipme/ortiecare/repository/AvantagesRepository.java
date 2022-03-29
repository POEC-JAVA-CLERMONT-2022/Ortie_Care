package com.ipme.ortiecare.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.Avantages;

public interface AvantagesRepository extends JpaRepository<Avantages, UUID>{
	@Query("SELECT * FROM avantages WHERE id_avantage = :id")
	 Avantages findByUUID(@Param("id")UUID id_avantage);
}
