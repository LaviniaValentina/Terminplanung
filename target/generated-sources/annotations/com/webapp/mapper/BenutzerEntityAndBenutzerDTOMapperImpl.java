package com.webapp.mapper;

import com.webapp.dto.BenutzerDTO;
import com.webapp.entities.Benutzer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-06-25T17:12:16+0300",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.17.0.v20190306-2240, environment: Java 1.8.0_191 (Oracle Corporation)"
)
public class BenutzerEntityAndBenutzerDTOMapperImpl implements BenutzerEntityAndBenutzerDTOMapper {

    @Override
    public Benutzer mapBenutzerDtoToBenutzer(BenutzerDTO benutzerDTO) {
        if ( benutzerDTO == null ) {
            return null;
        }

        Benutzer benutzer = new Benutzer();

        benutzer.setEmail( benutzerDTO.getEmail() );
        benutzer.setName( benutzerDTO.getName() );

        return benutzer;
    }

    @Override
    public BenutzerDTO mapBenutzerToBenutzerDTO(Benutzer benutzer) {
        if ( benutzer == null ) {
            return null;
        }

        BenutzerDTO benutzerDTO = new BenutzerDTO();

        benutzerDTO.setEmail( benutzer.getEmail() );
        benutzerDTO.setName( benutzer.getName() );

        return benutzerDTO;
    }

    @Override
    public List<BenutzerDTO> mapBenutzerListToBenutzerDtoList(List<Benutzer> benutzerList) {
        if ( benutzerList == null ) {
            return null;
        }

        List<BenutzerDTO> list = new ArrayList<BenutzerDTO>( benutzerList.size() );
        for ( Benutzer benutzer : benutzerList ) {
            list.add( mapBenutzerToBenutzerDTO( benutzer ) );
        }

        return list;
    }
}
