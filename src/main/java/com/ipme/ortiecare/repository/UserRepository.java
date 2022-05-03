package com.ipme.ortiecare.repository;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	
	User getById(@Param("id")UUID id_user);
 
	User findByFirstNameAndLastName(String firstName, String lastName);
	
	List<User> findByIsAdmin(int vraiOuFaux);
	
	User getByIsAdmin(int vraiOuFaux);
}