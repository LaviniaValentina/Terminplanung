package com.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapp.entities.Termin;

@Repository
public interface TerminRepository extends CrudRepository<Termin, Integer> {
}
