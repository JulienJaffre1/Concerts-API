package com.services;

import com.dtos.SoireeDto;

import java.util.List;

public interface SoireeService {
    /**
     * Sauve a dog
     */
    SoireeDto saveSoiree(SoireeDto soireeDto);

    /**
     * Get a dog by it's id
     */
    SoireeDto getSoireeById(Long soireeId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteSoiree(Long soireeId);

    /**
     * Get all the dogs
     */
    List<SoireeDto> getAllSoirees();
}
