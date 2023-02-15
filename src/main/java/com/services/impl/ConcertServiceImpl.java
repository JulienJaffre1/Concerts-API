package com.services.impl;
import com.dtos.ConcertDto;
import com.entities.Concert;
import com.repositories.ConcertRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRepository concertRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) {
        Concert concert = concertDtoToEntity(concertDto);
        concert = concertRepository.save(concert);
        return concertEntityToDto(concert);
    }

    @Override
    public ConcertDto getConcertById(Long concertId) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertEntityToDto(concert);
    }

    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(concert -> {
            concertDtos.add(concertEntityToDto(concert));
        });
        return concertDtos;
    }

    private ConcertDto concertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setId(concert.getId());
        concertDto.setDateDebut(concert.getDateDebut());
        concertDto.setDateFin(concert.getDateFin());
        concertDto.setGroupe_id(concert.getGroupe_id());
        concertDto.setSoiree_id(concert.getSoiree_id());
        concertDto.setPrix(concert.getPrix());
        return concertDto;
    }

    private Concert concertDtoToEntity(ConcertDto concertDto){
        Concert concert = new Concert();
        concert.setId(concertDto.getId());
        concert.setDateDebut(concertDto.getDateDebut());
        concert.setDateFin(concertDto.getDateFin());
        concert.setGroupe_id(concertDto.getGroupe_id());
        concert.setSoiree_id(concertDto.getSoiree_id());
        concert.setPrix(concertDto.getPrix());
        return concert;
    }
}
