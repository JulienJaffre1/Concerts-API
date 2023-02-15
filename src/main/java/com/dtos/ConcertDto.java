package com.dtos;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConcertDto {
    private long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private long groupe_id;
    private long soiree_id;
    private short prix;
}
