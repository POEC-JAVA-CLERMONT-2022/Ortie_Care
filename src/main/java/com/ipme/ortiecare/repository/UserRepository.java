package com.ipme.ortiecare.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.*;

public interface UserRepository extends JpaRepository<User, UUID> {
 @Query("SELECT * FROM users WHERE id_user = :id")
 User findByUUID(@Param("id")UUID id_user);
 
 @Query("SELECT is_admin FROM users WHERE id_user = :id")
 boolean isThisAdmin(@Param("id")UUID id_user); 
}
