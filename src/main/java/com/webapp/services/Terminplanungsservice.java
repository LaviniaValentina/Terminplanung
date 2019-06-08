package com.webapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.entities.Benutzer;
import com.webapp.entities.Termin;
import com.webapp.repository.BenutzerRepository;
import com.webapp.repository.TerminRepository;

@Service
public class Terminplanungsservice {

	@Autowired
	private BenutzerRepository benutzerRepository;

	@Autowired
	private TerminRepository terminRepository;

	public Optional<Benutzer> getBenutzer(Integer id) {
		return benutzerRepository.findById(id);
	}

	public void deleteBenutzer(Integer benutzerId) {
		benutzerRepository.deleteById(benutzerId);
	}

	public Benutzer saveBenutzer(Benutzer benutzer) {
		return benutzerRepository.save(benutzer);
	}

	public List<Benutzer> getAllBenutzer() {
		return (List<Benutzer>) benutzerRepository.findAll();
	}
	
	public void deleteTermin(Integer terminId) {
		terminRepository.deleteById(terminId);
	}
	
	public List<Termin> getAllTermine() {
		return (List<Termin>) terminRepository.findAll();
	}
	
	public Termin saveTermin(Termin termin) {
		return terminRepository.save(termin);
	}
	
	
	
}
