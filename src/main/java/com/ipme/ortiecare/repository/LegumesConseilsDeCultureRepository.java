package com.ipme.ortiecare.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.model.LegumesConseilsDeCulture;
import com.ipme.ortiecare.model.LegumesConseilsDeCulturePK;


//TODO: à déplacer
@Repository
public interface LegumesConseilsDeCultureRepository extends JpaRepository<LegumesConseilsDeCulture, LegumesConseilsDeCulturePK> {

	
	
	
}
