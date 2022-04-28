package com.ipme.ortiecare.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.repository.ConseilDeCultureRepository;
import com.ipme.ortiecare.services.ConseilDeCultureService;

public class TestConseilDeCultureService {
	@Autowired
	@InjectMocks
	ConseilDeCultureService conseilDeCultureService;

	@Mock
	private ConseilDeCultureRepository mockedConseilDeCultureRepo;

	@Test
	public void testCreationConseilDeCulture() {
		when(mockedConseilDeCultureRepo.save(Mockito.any(ConseilDeCulture.class))).thenReturn(new ConseilDeCulture(null, null, null));
		
		ConseilDeCulture testConseilDeCulture = conseilDeCultureService.create(null, null);
		
		Assertions.assertEquals(testConseilDeCulture.getIdConseil(), null);
		assertThat(testConseilDeCulture).isNotNull();
		assertThat(testConseilDeCulture).usingRecursiveComparison().isEqualTo(new ConseilDeCulture(null, null, null));
		Mockito.verify(mockedConseilDeCultureRepo, times(1)).save(Mockito.any(ConseilDeCulture.class));

	}
}
