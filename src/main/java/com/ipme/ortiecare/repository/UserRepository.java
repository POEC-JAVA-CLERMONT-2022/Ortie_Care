package com.ipme.ortiecare.repository;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.ipme.ortiecare.model.*;

public interface UserRepository extends JpaRepository<User, UUID> {
	
@Query("select * from users where id_user = :id")
User findByUUID(@Param("id")UUID id);

@Query("select is_admin from users where id_user = :id")
boolean isThisIDAdmin(@Param("id")UUID id);
}
