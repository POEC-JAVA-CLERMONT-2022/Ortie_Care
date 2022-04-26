package com.ipme.ortiecare.testServices;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.services.LegumeService;
import com.ipme.ortiecare.services.DTO.LegumeDTO;

public class IntegrationTestSolLegumeRelation {
	
	@InjectMocks
	LegumeService legumeService;


	@Test
	public void IntegrationTestSolLegumeRelation() {

		// mettre en h2 la bdd avec save sur le repo

		Legume legume1 = legumeService.create("testLegume1", 0, 0, null, null, false, false, null);
		Legume legume2 = legumeService.create("testLegume2", 0, 0, null, null, false, false, null);
		legumeService.addAssociationLegumeLegume(legume1, legume2);
		List<LegumeDTO> cesLegumesAssocies = this.legumeService.findListeLegumesAssocies(legume1.getIdLegume());
		Assertions.assertEquals(legume1.getIdLegume(), null);
		
		// findById légume avec id créee

	}
}