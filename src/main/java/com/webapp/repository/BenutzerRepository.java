package com.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapp.entities.Benutzer;

@Repository
public interface BenutzerRepository extends CrudRepository<Benutzer, Integer>{
	
	 Benutzer findByEmail(String email);
	 
}
