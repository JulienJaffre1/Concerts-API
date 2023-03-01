package com.controllers;

import com.dtos.SalleDto;
import com.services.impl.SalleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salle")
public class SalleController {

    private final SalleServiceImpl salleService;

    public SalleController(SalleServiceImpl salleService) {
        this.salleService = salleService;
    }

    /**
     * <p>Get all dogs in the system</p>
     * @return List<DogDto>
     */
    @GetMapping
    public List<SalleDto> getsalles() {
        return salleService.getAllSalles();
    }
    /**
     * Method to get the dog based on the ID
     */
    @GetMapping("/{id}")
    public SalleDto getsalle(@PathVariable Long id){
        return salleService.getSalleById(id);
    }

    /**
     * Create a new Dog in the system
     */
    @PostMapping
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto){
        return salleService.saveSalle(salleDto);
    }

    /**
     * Delete a dog by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteSalle(@PathVariable Long id){
        return salleService.deleteSalle(id);
    }

}
