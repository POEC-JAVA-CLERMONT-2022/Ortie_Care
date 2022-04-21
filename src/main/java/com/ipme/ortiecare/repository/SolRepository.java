package com.ipme.ortiecare.repository;

import java.util.List;
import java.util.UUID;
import com.ipme.ortiecare.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SolRepository extends JpaRepository<Sol, UUID>{
	
	Sol getById(UUID id);
	
	
	
	List<Sol> findByTextureSolContaining(String boutTextureSol);
	
	List<Sol> findByStructureSolContaining(String boutStructureSol);
	
}