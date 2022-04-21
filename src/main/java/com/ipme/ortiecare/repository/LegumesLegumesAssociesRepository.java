package com.ipme.ortiecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ipme.ortiecare.model.LegumesLegumesAssocies;
import com.ipme.ortiecare.model.LegumesLegumesAssociesPK;

@Repository
public interface LegumesLegumesAssociesRepository extends JpaRepository<LegumesLegumesAssocies, LegumesLegumesAssociesPK>{

}
