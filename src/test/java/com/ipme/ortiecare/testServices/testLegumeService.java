package com.ipme.ortiecare.testServices;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.services.LegumeService;

@SpringBootTest
public class testLegumeService {

	@Autowired
	LegumeService legumeService;
	
	@Test
	public void testGetLegumesAssocies()
	{
		legumeService.create("testLegume1", 0, 0, null, false, false, null);
		legumeService.create("testLegume2", 0, 0, null, false, false, null);
		legumeService.create("testLegume3", 0, 0, null, false, false, null);
		legumeService.create("testLegume4", 0, 0, null, false, false, null);
		
		// associer les légumes
		
		
		List<Legume> cesLegumes = this.legumeService.findListeLegumesAssocies(null);
		
		
		
//		String unUser = this.service.create("sss", "ddd", "ddd", "fggg");
//		
//		assertNotNull(unUser);
		
	}
}
