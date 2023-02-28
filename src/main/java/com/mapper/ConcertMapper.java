package com.mapper;

import com.dtos.ConcertDto;
import com.entities.Concert;

public interface ConcertMapper {
    ConcertDto concertEntityToDto(Concert Entity);

    Concert concertDtoToEntity(ConcertDto concertDto);
}
