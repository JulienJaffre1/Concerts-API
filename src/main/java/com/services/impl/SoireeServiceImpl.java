package com.services.impl;
import com.dtos.SoireeDto;
import com.entities.Soiree;
import com.mapper.SoireeMapper;
import com.repositories.SoireeRepository;
import com.services.SoireeService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("SoireeService")
public class SoireeServiceImpl implements SoireeService, SoireeMapper {
    private final SoireeRepository soireeRepository;

    public SoireeServiceImpl(SoireeRepository soireeRepository) {
        this.soireeRepository = soireeRepository;
    }

    @Override
    public SoireeDto saveSoiree(SoireeDto soireeDto) {
        Soiree soiree = soireeDtoToEntity(soireeDto);
        soiree = soireeRepository.save(soiree);
        return soireeEntityToDto(soiree);
    }

    @Override
    public SoireeDto getSoireeById(Long soireeId) {
        Soiree soiree = soireeRepository.findById(soireeId).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        return soireeEntityToDto(soiree);
    }

    @Override
    public boolean deleteSoiree(Long soireeId) {
        soireeRepository.deleteById(soireeId);
        return true;
    }

    @Override
    public List<SoireeDto> getAllSoirees() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<Soiree> soirees = soireeRepository.findAll();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }

    public SoireeDto soireeEntityToDto(Soiree soiree){
        SoireeDto soireeDto = new SoireeDto();
        soireeDto.setId(soiree.getId());
        soireeDto.setNom(soiree.getNom());
        soireeDto.setSalle_id(soiree.getSalle_id());
        soireeDto.setDate(soiree.getDate());
        return soireeDto;
    }

    public Soiree soireeDtoToEntity(SoireeDto soireeDto){
        Soiree soiree = new Soiree();
        soiree.setId(soireeDto.getId());
        soiree.setNom(soireeDto.getNom());
        soiree.setSalle_id(soireeDto.getSalle_id());
        soiree.setDate(soireeDto.getDate());
        return soiree;
    }
}
