package com.ipme.ortiecare.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.services.LegumeService;
import com.ipme.ortiecare.services.DTO.LegumeDTO;
@SpringBootTest
public class IntegrationTestSolLegumeRelation {
	
	
	@Autowired
	LegumeService legumeService;

	// OK
	@Test
	public void integrationTestFindLegumeAssocie() {
		
		Legume legume1 = legumeService.create("testLegume1", 0, 0, null, null, false, false, null);
		Legume legume2 = legumeService.create("testLegume2", 0, 0, null, null, false, false, null);
		legumeService.addAssociationLegumeLegume(legume1, legume2);
		List<LegumeDTO> cesLegumesAssocies = this.legumeService.findListeLegumesAssocies(legume1.getIdLegume());
		Assertions.assertEquals(legume1.getIdLegume(), null);
		Assertions.assertNotNull(cesLegumesAssocies);
		Assertions.assertEquals(1, cesLegumesAssocies.size());
		Assertions.assertEquals(legume2.getNom(), cesLegumesAssocies.get(0).getNom());
	}
}