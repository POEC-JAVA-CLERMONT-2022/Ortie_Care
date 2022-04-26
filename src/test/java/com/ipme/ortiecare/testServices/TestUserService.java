package com.ipme.ortiecare.testServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.UUID;
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
	
	@InjectMocks
	UserService userService;
	
	@Mock
	private UserRepository mockedUserRepo;

	@Test
	public void testUser() 
	{
		User unUser = this.userService.create("sss", "ddd", "ddd", "fggg");
		assertNotNull(unUser);
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
