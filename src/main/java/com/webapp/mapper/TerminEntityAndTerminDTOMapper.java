package com.webapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.webapp.dto.TerminDTO;
import com.webapp.entities.Termin;

@Mapper
public interface TerminEntityAndTerminDTOMapper {

	Termin mapTerminDtoToTermin(TerminDTO terminDTO);

	TerminDTO mapTerminToTerminDto(Termin termin);

	List<TerminDTO> mapTerminListToTerminDtoList(List<Termin> terminList);

}
