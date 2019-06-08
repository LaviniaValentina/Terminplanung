package com.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webapp.entities.Termin;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Integer> {
	
	@Modifying
	@Query()
	List<Termin> getAllTermineFuerBenutzer(Integer benutzerId);

	@Modifying
	@Query()
	List<Termin> getAllTermineUndBenutzer();
}
