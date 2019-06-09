package com.webapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	public Benutzer getBenutzer(Integer id) {
		return benutzerRepository.findById(id).get();
	}

	public void deleteBenutzer(Integer benutzerId) {
		benutzerRepository.deleteById(benutzerId);
	}

	public Benutzer saveBenutzer(Benutzer benutzer) {
		return benutzerRepository.save(benutzer);
	}

	public List<Benutzer> getAllBenutzer() {
		List<Benutzer> benutzerList = new ArrayList<>();
		benutzerRepository.findAll().forEach(benutzer -> benutzerList.add(benutzer));
		return benutzerList;
	}

	public void deleteTermin(Integer terminId) {
		terminRepository.deleteById(terminId);
	}

	public List<Termin> getAllTermine() {
		List<Termin> terminList = new ArrayList<>();
		terminRepository.findAll().forEach(termin -> terminList.add(termin));
		return terminList;
	}

	public Termin getTermin(Integer id) {
		return terminRepository.findById(id).get();
	}

	public Termin saveTermin(Termin termin) {
		return terminRepository.save(termin);
	}

	public void deleteTermineForBenutzer(Integer benutzerId) {
		Benutzer benutzer = getBenutzer(benutzerId);
		List<Termin> terminList = getAllTermine();
		for (Termin termin : terminList) {
			if (termin.getBenutzerList().contains(benutzer) && termin.getBenutzerList().size() == 1) {
				deleteTermin(termin.getId());
			} else if (termin.getBenutzerList().contains(benutzer) && termin.getBenutzerList().size() > 1) {
				termin.getBenutzerList().remove(benutzer);
				saveTermin(termin);
			}
		}
	}

	public void deleteTerminForBenutzer(Integer benutzerId, Integer terminId) {
		Benutzer benutzer = getBenutzer(benutzerId);
		List<Termin> terminList = getAllTermine();
		for (Termin termin : terminList) {
			if (termin.getBenutzerList().contains(benutzer) && termin.getId().intValue() == terminId.intValue()) {
				deleteTermin(termin.getId());
			}
		}
	}

	public Termin createTerminOnlyForBenutzer(Integer benutzerId, Date start, Date end, String titel) throws Exception {

		boolean canCreate = true;
		Benutzer benutzer = getBenutzer(benutzerId);
		List<Termin> terminList = getAllTermine();
		for (Termin termin : terminList) {
			if (termin.getBenutzerList().contains(benutzer)) {
				if (!isValidDate(termin, start, end)) {
					canCreate = false;
				} else {
					canCreate = true;
				}
			}
		}
		if (canCreate) {
			List<Benutzer> benutzerList = new ArrayList<>();
			benutzerList.add(benutzer);
			Termin termin = new Termin(titel, start, end, benutzerList);
			saveTermin(termin);
			return termin;
		} else {
			throw new Exception("Zeitpunkt für Termin ungültig. Es gibt Überlappungen.");
		}
	}

	public Benutzer createBenutzer(String name, String email) {
		Benutzer benutzer = new Benutzer(name, email);
		saveBenutzer(benutzer);
		return benutzer;
	}

	public Benutzer editBenutzerName(Integer benutzerId, String name) {
		Benutzer benutzer = getBenutzer(benutzerId);
		benutzer.setName(name);
		saveBenutzer(benutzer);
		return benutzer;
	}

	public Benutzer editBenutzerEmail(Integer benutzerId, String email) {
		Benutzer benutzer = getBenutzer(benutzerId);
		benutzer.setEmail(email);
		saveBenutzer(benutzer);
		return benutzer;
	}

	public Termin editTerminTitel(Integer terminId, String titel) {
		Termin termin = getTermin(terminId);
		termin.setTitel(titel);
		saveTermin(termin);
		return termin;
	}

	public Termin editTerminDate(Integer terminId, Date start, Date end) throws Exception {
		Termin termin = getTermin(terminId);
		if (isValidDate(termin, start, end)) {
			termin.setStart(start);
			termin.setEnd(end);
			saveTermin(termin);
			return termin;
		} else {
			throw new Exception("Zeitpunkt für Termin ungültig. Es gibt Überlappungen.");
		}
	}

	public Termin editTerminBenutzer(Integer terminId, Integer benutzerId) {
		Termin termin = getTermin(terminId);
		Benutzer benutzer = getBenutzer(benutzerId);
		List<Benutzer> benutzerList = termin.getBenutzerList();
		if (benutzerList.contains(benutzer)) {
			return termin;
		} else {
			benutzerList.add(benutzer);
			return termin;
		}
	}

	private boolean isValidDate(Termin termin, Date start, Date end) {

		Date startTermin = termin.getStart();
		Date endTermin = termin.getEnd();
		if (start.after(startTermin) && start.before(endTermin)) {
			return false;
		} else if (start.before(startTermin) && end.after(startTermin)) {
			return false;
		} else if (start.equals(startTermin) && end.equals(endTermin)) {
			return false;
		}

		return true;

	}
}
