package com.benjdiya.monoapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@Entity @NoArgsConstructor @AllArgsConstructor
public class History {
    @jakarta.persistence.Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDateTime time;

    @ManyToOne
    private Offres offre;
    @ManyToOne
    private Utilisateur utilisateur;
}