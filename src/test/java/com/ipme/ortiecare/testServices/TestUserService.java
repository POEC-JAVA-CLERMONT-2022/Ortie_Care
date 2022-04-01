package com.ipme.ortiecare.testServices;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.repository.UserRepository;
import com.ipme.ortiecare.services.UserService;

@SpringBootTest
public class testUserService {
	
	@Autowired
	UserService service;

	@Test
	public void testUser() {
			String unUser = this.service.create("sss", "ddd", "ddd", "fggg");
			
			assertNotNull(unUser);
			
	


	}
}
