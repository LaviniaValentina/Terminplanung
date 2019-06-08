package com.webapp.mapper;

import com.webapp.dto.TerminDTO;
import com.webapp.entities.Benutzer;
import com.webapp.entities.Termin;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-08T23:03:58+0300",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.17.0.v20190306-2240, environment: Java 12.0.1 (Oracle Corporation)"
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
        ArrayList<Benutzer> arrayList = terminDTO.getBenutzerList();
        if ( arrayList != null ) {
            termin.setBenutzerList( new ArrayList<Benutzer>( arrayList ) );
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
        ArrayList<Benutzer> arrayList = termin.getBenutzerList();
        if ( arrayList != null ) {
            terminDTO.setBenutzerList( new ArrayList<Benutzer>( arrayList ) );
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
