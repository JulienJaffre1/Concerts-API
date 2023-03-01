package com.mapper;

import com.dtos.SoireeDto;
import com.entities.Soiree;

public interface SoireeMapper {
    SoireeDto soireeEntityToDto(Soiree entity);

    Soiree soireeDtoToEntity(SoireeDto soireeDto);
}
