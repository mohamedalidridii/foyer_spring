package org.example.tpfoyer.mapper;

import org.example.tpfoyer.dto.ChambreDTO;
import org.example.tpfoyer.entities.Chambre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChambreMapper {

    ChambreDTO toDTO(Chambre chambre);  // Changed from toDoto to toDTO
    Chambre toEntity(ChambreDTO chambreDTO);
}