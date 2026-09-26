package com.taxy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxy.entity.KidProfile;

public interface KidProfileRepository extends JpaRepository<KidProfile, Long> {
	
	boolean existsByUsername(String username);
	Optional<KidProfile> findByUsername(String username);

}