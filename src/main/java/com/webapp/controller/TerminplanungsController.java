package com.webapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp.dto.BenutzerDTO;
import com.webapp.dto.TerminDTO;
import com.webapp.entities.Benutzer;
import com.webapp.entities.Termin;
import com.webapp.mapper.BenutzerEntityAndBenutzerDTOMapper;
import com.webapp.mapper.TerminEntityAndTerminDTOMapper;
import com.webapp.services.Terminplanungsservice;

@Controller
public class TerminplanungsController {

	@Autowired
	private Terminplanungsservice terminplanungsservice;

	@Autowired
	private BenutzerEntityAndBenutzerDTOMapper benutzerMapper;

	@Autowired
	private TerminEntityAndTerminDTOMapper terminMapper;

	@GetMapping("/allBenutzer")
	public List<BenutzerDTO> getAllBenutzer() {
		return benutzerMapper.mapBenutzerListToBenutzerDtoList(terminplanungsservice.getAllBenutzer());
	}

	@GetMapping("/allTermine")
	public List<TerminDTO> getAllTermine() {
		return terminMapper.mapTerminListToTerminDtoList(terminplanungsservice.getAllTermine());
	}

	@GetMapping("/benutzer")
	public BenutzerDTO getBenutzerById(@RequestParam(name = "id") Integer id) {
		return benutzerMapper.mapBenutzerToBenutzerDTO(terminplanungsservice.getBenutzer(id));
	}

	@GetMapping("/termin")
	public TerminDTO getTerminById(@RequestParam(name = "id") Integer id) {
		return terminMapper.mapTerminToTerminDto(terminplanungsservice.getTermin(id));
	}

	@PostMapping("/create/benutzer")
	public BenutzerDTO createBenutzer(@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email) {
		Benutzer newBenutzer = terminplanungsservice.createBenutzer(name, email);
		return benutzerMapper.mapBenutzerToBenutzerDTO(newBenutzer);
	}

	@PostMapping("/create/termin")
	public TerminDTO createTerminOnlyForBenutzer(@RequestParam(name = "benutzerId") Integer benutzerId,
			@RequestParam(name = "start") Date start, @RequestParam(name = "end") Date end,
			@RequestParam(name = "titel") String titel) throws Exception {
		Termin newTermin = terminplanungsservice.createTerminOnlyForBenutzer(benutzerId, start, end, titel);
		return terminMapper.mapTerminToTerminDto(newTermin);
	}

	@PutMapping("/update/termin/date")
	public TerminDTO updateTerminDate(@RequestParam(name = "terminId") Integer terminId,
			@RequestParam(name = "start") Date start, @RequestParam(name = "end") Date end) throws Exception {
		Termin newTermin = terminplanungsservice.editTerminDate(terminId, start, end);
		return terminMapper.mapTerminToTerminDto(newTermin);
	}

	@PutMapping("/update/termin/titel")
	public TerminDTO updateTerminTitel(@RequestParam(name = "terminId") Integer terminId,
			@RequestParam(name = "titel") String titel) {
		Termin newTermin = terminplanungsservice.editTerminTitel(terminId, titel);
		return terminMapper.mapTerminToTerminDto(newTermin);
	}

	@PutMapping("/update/termin/benutzer")
	public TerminDTO updateTerminBenutzer(@RequestParam(name = "terminId") Integer terminId,
			@RequestParam(name = "benutzerId") Integer benutzerId) {
		Termin newTermin = terminplanungsservice.editTerminBenutzer(terminId, benutzerId);
		return terminMapper.mapTerminToTerminDto(newTermin);
	}

	@PutMapping("/update/benutzer/name")
	public BenutzerDTO updateBenutzerName(@RequestParam(name = "benutzerId") Integer benutzerId,
			@RequestParam(name = "name") String name) {
		Benutzer newBenutzer = terminplanungsservice.editBenutzerName(benutzerId, name);
		return benutzerMapper.mapBenutzerToBenutzerDTO(newBenutzer);
	}

	@PutMapping("/update/benutzer/email")
	public BenutzerDTO updateBenutzerDTO(@RequestParam(name = "benutzerId") Integer benutzerId,
			@RequestParam(name = "email") String email) {
		Benutzer newBenutzer = terminplanungsservice.editBenutzerEmail(benutzerId, email);
		return benutzerMapper.mapBenutzerToBenutzerDTO(newBenutzer);
	}

	@DeleteMapping("/delete/benutzer/termine")
	public void deleteTermineForBenutzer(@RequestParam(name = "benutzerId") Integer benutzerId) {
		terminplanungsservice.deleteTermineForBenutzer(benutzerId);
	}

	@DeleteMapping("/delete/benutzer/termin")
	public void deleteTerminForBenutzer(@RequestParam(name = "benutzerId") Integer benutzerId,
			@RequestParam(name = "terminId") Integer terminId) {
		terminplanungsservice.deleteTerminForBenutzer(benutzerId, terminId);
	}

}
