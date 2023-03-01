package com.mapper;

import com.dtos.SalleDto;
import com.entities.Salle;

public interface SalleMapper {
    SalleDto salleEntityToDto(Salle entity);

    Salle salleDtoToEntity(SalleDto salleDto);
}
