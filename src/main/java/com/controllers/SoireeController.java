package com.controllers;

import com.dtos.SoireeDto;
import com.services.impl.SoireeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soiree")
public class SoireeController {

    private final SoireeServiceImpl soireeService;

    public SoireeController(SoireeServiceImpl soireeService) {
        this.soireeService = soireeService;
    }

    /**
     * <p>Get all dogs in the system</p>
     * @return List<DogDto>
     */
    @GetMapping
    public List<SoireeDto> getsoirees() {
        return soireeService.getAllSoirees();
    }
    /**
     * Method to get the dog based on the ID
     */
    @GetMapping("/{id}")
    public SoireeDto getsoiree(@PathVariable Long id){
        return soireeService.getSoireeById(id);
    }

    /**
     * Create a new Dog in the system
     */
    @PostMapping
    public SoireeDto saveSoiree(final @RequestBody SoireeDto soireeDto){
        return soireeService.saveSoiree(soireeDto);
    }

    /**
     * Delete a dog by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSoiree(@PathVariable Long id){
        return soireeService.deleteSoiree(id);
    }

}
