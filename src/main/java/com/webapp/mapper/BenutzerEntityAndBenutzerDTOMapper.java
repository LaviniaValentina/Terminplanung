package com.webapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.webapp.dto.BenutzerDTO;
import com.webapp.entities.Benutzer;

@Mapper
public interface BenutzerEntityAndBenutzerDTOMapper {

	Benutzer mapBenutzerDtoToBenutzer(BenutzerDTO benutzerDTO);

	BenutzerDTO mapBenutzerToBenutzerDTO(Benutzer benutzer);

	List<BenutzerDTO> mapBenutzerListToBenutzerDtoList(List<Benutzer> benutzerList);

}
