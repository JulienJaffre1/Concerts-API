package com.services.impl;
import com.dtos.SalleDto;
import com.entities.Salle;
import com.mapper.SalleMapper;
import com.repositories.SalleRepository;
import com.services.SalleService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("SalleService")
public class SalleServiceImpl implements SalleService, SalleMapper {
    private final SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        Salle salle = salleDtoToEntity(salleDto);
        salle = salleRepository.save(salle);
        return salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long salleId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleEntityToDto(salle);
    }

    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(salle -> {
            salleDtos.add(salleEntityToDto(salle));
        });
        return salleDtos;
    }

    public SalleDto salleEntityToDto(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getId());
        salleDto.setNom(salle.getNom());
        salleDto.setCapacite(salle.getCapacite());
        return salleDto;
    }

    public Salle salleDtoToEntity(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setId(salleDto.getId());
        salle.setNom(salleDto.getNom());
        salle.setCapacite(salleDto.getCapacite());
        return salle;
    }
}
