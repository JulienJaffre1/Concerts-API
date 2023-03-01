package com.dtos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class SoireeDto {
    private long id;
    private String nom;
    private long salle_id;
    private LocalDateTime date;
}
