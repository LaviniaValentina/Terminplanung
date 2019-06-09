package com.webapp.mapper;

import com.webapp.dto.TerminDTO;
import com.webapp.entities.Benutzer;
import com.webapp.entities.Termin;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-09T22:33:22+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
public class TerminEntityAndTerminDTOMapperImpl implements TerminEntityAndTerminDTOMapper {

    @Override
    public Termin mapTerminDtoToTermin(TerminDTO terminDTO) {
        if ( terminDTO == null ) {
            return null;
        }

        Termin termin = new Termin();

        termin.setTitel( terminDTO.getTitel() );
        termin.setStart( terminDTO.getStart() );
        termin.setEnd( terminDTO.getEnd() );
        List<Benutzer> list = terminDTO.getBenutzerList();
        if ( list != null ) {
            termin.setBenutzerList( new ArrayList<Benutzer>( list ) );
        }

        return termin;
    }

    @Override
    public TerminDTO mapTerminToTerminDto(Termin termin) {
        if ( termin == null ) {
            return null;
        }

        TerminDTO terminDTO = new TerminDTO();

        terminDTO.setTitel( termin.getTitel() );
        terminDTO.setStart( termin.getStart() );
        terminDTO.setEnd( termin.getEnd() );
        List<Benutzer> list = termin.getBenutzerList();
        if ( list != null ) {
            terminDTO.setBenutzerList( new ArrayList<Benutzer>( list ) );
        }

        return terminDTO;
    }

    @Override
    public List<TerminDTO> mapTerminListToTerminDtoList(List<Termin> terminList) {
        if ( terminList == null ) {
            return null;
        }

        List<TerminDTO> list = new ArrayList<TerminDTO>( terminList.size() );
        for ( Termin termin : terminList ) {
            list.add( mapTerminToTerminDto( termin ) );
        }

        return list;
    }
}
