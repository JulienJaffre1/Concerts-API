package com.dtos;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ConcertDto {
    private long id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private long groupe;
    private long salle;
    private short prix;
}
