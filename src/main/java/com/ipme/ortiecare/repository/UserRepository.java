package com.ipme.ortiecare.repository;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ipme.ortiecare.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
 @Query(value="SELECT * FROM users WHERE id_user = :id", nativeQuery = true)
 User findByUUID(@Param("id")UUID id_user);
 
 @Query(value="SELECT is_admin FROM users WHERE id_user = :id", nativeQuery=true)
 boolean isThisAdmin(@Param("id")UUID id_user); 
}