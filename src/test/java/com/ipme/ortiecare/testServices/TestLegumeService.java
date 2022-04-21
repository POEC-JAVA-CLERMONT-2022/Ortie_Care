package com.ipme.ortiecare.testServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Set;
import java.util.UUID;


import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.repository.LegumesRepository;
import com.ipme.ortiecare.services.LegumeService;

//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestLegumeService {

	@InjectMocks
	LegumeService legumeService;
	
	@Mock
	private LegumesRepository mockedLegumeRepo;
	
	@Test
	public void testGetLegumesAssocies()
	{
		legumeService.create("testLegume1", 0, 0, null, null, false, false, null);
		legumeService.create("testLegume2", 0, 0, null, null, false, false, null);
		legumeService.create("testLegume3", 0, 0, null, null, false, false, null);
		legumeService.create("testLegume4", 0, 0, null, null, false, false, null);
		// associer les l�gumes
		
		List<Legume> cesLegumes = this.legumeService.findListeLegumesAssocies(null);
		
	}
	
	// Test utilisation Mock
	@Test
	public void testCreationLegume()
	{
		when(mockedLegumeRepo.save(Mockito.any(Legume.class))).thenReturn(new Legume(null, null, 0, 0, null, null, false, false, null));
		Legume testLegume = legumeService.create(null, 0, 0, null, null, false, false, null);
		// test null
		assertNotNull(testLegume);
		// test id null comme dans le test
		Assertions.assertEquals(testLegume.getIdLegume(), null);
		// test objet non null
		assertThat(testLegume).isNotNull();
		// test id null comme dans le test
		assertThat(testLegume.getIdLegume()).isNull();
		// test si les r�f�rences sont �gales
		assertThat(testLegume).isSameAs(new Legume(null, null, 0, 0, null, null, false, false, null));
		// test si tous les champs sont ok par rapport au premier argument
		assertThat(testLegume).usingRecursiveComparison().isEqualTo(new Legume (null, null, 0, 0, null, null, false, false, null));
		// Verifie une fois l'utilisation du repo mocked avec un legume mocked
		Mockito.verify(mockedLegumeRepo, times(1)).save(Mockito.any(Legume.class));
		
	}	
}
