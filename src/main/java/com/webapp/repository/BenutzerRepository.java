package com.webapp.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.entities.Benutzer;
import com.webapp.entities.Termin;

@Repository
public interface BenutzerRepository extends JpaRepository<Benutzer, Integer>{
	
	@Modifying
	@Query(" ")
	void deleteTerminForBenutzer(Integer benutzerId);

	@Modifying
	@Query()
	Termin createTerminForMehrereBenutzer(Integer benutzerId, String titel, Date start, Date end,
			ArrayList<Benutzer> benutzerList);

	@Modifying
	@Query()
	Termin createTerminForBenutzer(Integer benutzerId, String titel, Date start, Date end);

	@Modifying
	@Query()
	Termin editTerminForBenutzer(Integer benutzerId, String titel, Date start, Date end,
			ArrayList<Benutzer> benutzerList);
}
