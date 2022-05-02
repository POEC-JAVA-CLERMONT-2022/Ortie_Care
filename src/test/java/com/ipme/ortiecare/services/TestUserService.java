package com.ipme.ortiecare.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.repository.LegumesRepository;
import com.ipme.ortiecare.repository.UserRepository;
import com.ipme.ortiecare.services.UserService;

@SpringBootTest
public class TestUserService {
	
	@Mock
	private UserRepository mockedUserRepo;
	// Injection du mock pour l'instanciation du service (permet d'appeller le service mocké et ainsi utiliser des objets mockés
	@InjectMocks
	UserService userService;
	
	// Test création User, vérification des données retournés lors de l'appel de la méthode getNomComplet
	@Test
	public void testCreateUser()
	{
		User unUser = this.userService.create("sss", "ddd", "ddd", "fggg");
		assertNotNull(unUser);
		Assertions.assertEquals(unUser.getNomComplet(), new User(UUID.randomUUID(),"sss", "ddd", "ddd", "fggg").getNomComplet());
	}
	
	@Test
    public void testAdmin() 
	{
	    when(mockedUserRepo.save(Mockito.any(User.class))).thenReturn(new User(null, null, null, null, null));
	    User testUser = userService.create(null, null, null, null);
	    assertThat(testUser.isAdmin()).isFalse();
	    testUser.setAdmin(true);
	    assertThat(testUser.isAdmin()).isTrue();
	}
	
	
}
