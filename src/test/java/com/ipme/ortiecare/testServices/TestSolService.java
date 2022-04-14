package com.ipme.ortiecare.testServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.repository.SolRepository;
import com.ipme.ortiecare.services.SolService;

public class TestSolService {
	
	@Autowired
	@InjectMocks
	SolService solService;
	
	@Mock
	private SolRepository mockedSolRepo;
	
	@Test
	public void testCreationSol() {
		when(mockedSolRepo.save(Mockito.any(Sol.class))).thenReturn(new Sol(null, null, null, null, null, null));
		
		Sol testSol = solService.create(null, null, null, null, null);
		
		Assertions.assertEquals(testSol.getId(), null);
		assertThat(testSol).isNotNull();
		assertThat(testSol).usingRecursiveComparison().isEqualTo(new Sol (null, null, null, null, null, null));
		Mockito.verify(mockedSolRepo, times(1)).save(Mockito.any(Sol.class));
		
	}

}
