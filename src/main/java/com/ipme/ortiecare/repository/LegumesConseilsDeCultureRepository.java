package com.ipme.ortiecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ipme.ortiecare.model.LegumesConseilsDeCulture;
import com.ipme.ortiecare.model.LegumesConseilsDeCulturePK;

@Repository
public interface LegumesConseilsDeCultureRepository extends JpaRepository<LegumesConseilsDeCulture, LegumesConseilsDeCulturePK> {
	
}
